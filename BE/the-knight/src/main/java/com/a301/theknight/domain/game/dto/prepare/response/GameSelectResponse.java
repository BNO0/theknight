package com.a301.theknight.domain.game.dto.prepare.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GameSelectResponse {
    private boolean selected;
    private boolean canStart;
}
