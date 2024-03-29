package com.a301.theknight.domain.auth.filter;

import com.a301.theknight.domain.auth.model.MemberPrincipal;
import com.a301.theknight.domain.auth.util.TokenProperties;
import com.a301.theknight.domain.auth.service.CustomUserDetailsService;
import com.a301.theknight.domain.auth.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final TokenProperties tokenProperties;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().contains("/websocket")) {
            filterChain.doFilter(request, response);
            return;
        }
        log.info("=====>> [Request] {} {}", request.getMethod(), request.getRequestURI());


        String accessToken = getAccessTokenInRequestHeader(request);
        log.info("  Request Access-Token = {}", accessToken);
        try {
            if (StringUtils.hasText(accessToken) && tokenService.validateToken(accessToken, tokenProperties.getAccess().getName())) {
                Long id = tokenService.getId(accessToken);
                UserDetails userDetails = customUserDetailsService.loadMemberById(id);
                MemberPrincipal memberPrincipal = (MemberPrincipal) userDetails;
                log.info("  Request Member Id = {}, Email = {}", memberPrincipal.getMemberId(), memberPrincipal.getUsername());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            throw new AuthenticationException(e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    private String getAccessTokenInRequestHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
