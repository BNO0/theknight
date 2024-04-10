# 🏷️ The Knight - 심리/전략 실시간 온라인 웹게임
![logo](/img/logo.png)

<br>

## 📆 프로젝트 진행 기간
 - 2022.10 ~ 2022.11
 - SSAFY 7기 2학기 자율프로젝트

<br>

## 📖 기획 배경
- ### **두뇌게임에 대한 수요**
  - 더 지니어스를 시작으로 문제적남자, 소사이어티게임, 피의게임 등 다양한 두뇌서바이벌 프로그램이 인기가 있다.
  - 두뇌게임을 주제로 하는 인터넷 카페가 형성되어 있다.
<br>

- ### **오프라인/온라인 진행의 한계**
  - 오프라인 진행의 경우 장소대여비가 비싸고 소수의 인원만 진행할 수 있다.
  - 온라인 진행의 경우 텍스트로만 게임을 진행하고 소통이 제한적이라 몰입감이 떨어진다.
  - 두 방식 모두 사람이 직접 진행하기 때문에 진행자는 게임에 참여할 수 없고 진행과정에서 오류가 발생한다.
<br>

  => 두뇌게임에 대한 수요를 충족시키기 위한 서비스

<br>

## ✔ 주요 기능

- ### Main
  ![main](/img/main.png)
    - 게임하러가기 클릭 시 로비로 이동
    - 게임방법 클릭 시 설명으로 이동
    
- ### Lobby
  ![lobby](/img/lobby.png)
    - 방만들기 가능
    - 방 클릭 시 인원이 차지 않았다면 입장
    
- ### 대기방
  ![대기방](/img/대기방.png)
    - A/B 팀선택 가능
    - Ready/Cancel 가능
    - 방장은 Ready/Cancel 대신 Start (팀인원이 안맞으면 시작불가)
    
- ### 인게임
  ![game1](/img/game_01.png)
    - 팀 내 순서와 좌우 무기 선택 (무기 선택 시 선택가능 무기개수 차감)
  ![game2](/img/game_02.png)
    - 공격자는 [공격위치, 무기, 방어자] 선택 후 공격
    - 방어자는 공격자를 의심하거나 [방어위치] 선택 후 방어 가능
    - 방어자가 방어 후 공격자는 방어자를 의심하거나 패스 가능
  ![game3](/img/game_03.png)
    - 방어자의 행동을 의심하지 않으면 그대로 공격진행 (쌍검은 2회 공격, 한쪽방패당 최대 3회까지 방어가능)
  ![game4](/img/game_04.png)
    - 의심 성공시 의심당한 사람 사망
    - 의심 실패시 의심한 사람 사망
    - 사망한 사람이 리더인 경우 게임 종료
    
- ### 채팅
  ![chatting](/img/chatting.png)
    - 대기방, 인게임에서 좌측 하단 아이콘 클릭 시 채팅 가능
    - tap 키를 통해 팀채팅, 전체채팅 전환가능

- ### 랭킹
  ![rank](/img/rank.png)
    - 게임 결과에 따라 점수 변동
    - 점수에 따른 랭킹 확인 가능

<br>

## 🛠️ 주요 기술

**Frontend**
- Visual Studio Code IDE
- React 18.2.0
- Redux 4.2.0 
- React-Router 6.4.2
- SockJS 1.5.1

**Backend**
- IntelliJ IDE 2022.1.4(Ultimate Edition)
- JDK 11.0.15.1
- Springboot 2.7.3
- MySQL 8.0.30
- Amazon S3
- Swegger 3.0.0
- SockJS 1.5.1

**CI/CD**
- AWS EC2 Ubuntu 20.04 LTS
- NGINX
- Docker

<br>

## 🗂️ 프로젝트 파일 구조
### Frontend
```
📦frontend
 ┣ 📂.idea
 ┣ 📂public
 ┣ 📂src
 ┃ ┣ 📂_assets
 ┃ ┣ 📂_css
 ┃ ┣ 📂_slice
 ┃ ┣ 📂_store
 ┃ ┣ 📂api
 ┃ ┣ 📂commons
 ┃ ┃ ┣ 📂login
 ┃ ┃ ┣ 📂modal
 ┃ ┃ ┗ 📂user
 ┃ ┣ 📂components
 ┃ ┃ ┣ 📂game
 ┃ ┃ ┣ 📂header
 ┃ ┃ ┣ 📂info
 ┃ ┃ ┣ 📂lobby
 ┃ ┃ ┣ 📂main
 ┃ ┃ ┣ 📂memberPage
 ┃ ┃ ┣ 📂rank
 ┃ ┃ ┣ 📂room
 ┃ ┃ ┗ 📂test
 ┃ ┣ 📂function
 ┃ ┣ 📂pages
 ┃ ┃ ┣ 📜Game.js
 ┃ ┃ ┣ 📜Information
 ┃ ┃ ┣ 📜Lobby.js
 ┃ ┃ ┣ 📜Login.js
 ┃ ┃ ┣ 📜Main.js
 ┃ ┃ ┣ 📜MemberPage.js
 ┃ ┃ ┣ 📜Rank.js
 ┃ ┃ ┣ 📜Room.js
 ┃ ┃ ┗ 📜Signup.js
 ┃ ┣ 📂websocket
 ┃ ┣ 📜App.css
 ┃ ┣ 📜App.js
 ┃ ┣ 📜index.css
 ┃ ┣ 📜index.js
 ┃ ┗ 📜ScrollToTop.js
 ┣ 📜.gitignore
 ┣ 📜package-lock.json
 ┣ 📜package.json
 ┣ 📜README.md
```

### Backend
```
📦BE/the-knight
 ┣ 📂gradle
 ┃ ┗ 📂wrapper
 ┣ 📂src
 ┃ ┗ 📂main
 ┃ ┃ ┗ 📂java
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂a301
 ┃ ┃ ┃ ┃ ┃ ┗ 📂theknight
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂chatting
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂game
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂limit
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂member
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂player
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂ranking
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂global
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂aop
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂error
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂properties
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂redis
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂security
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂swagger
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂validation
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂webmvc
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂websocket
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜HelloController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TheKnightApplication.java
 ┣ 📜.gitignore
 ┣ 📜build.gradle
 ┣ 📜gradlew
 ┣ 📜gradlew.bat
 ┗ 📜settings.gradle
```

<br>

## ✔ 팀원 역할 분배
### FE
  - 박민호
  - 이현빈
  - 이현진

### BE
  - 김희영 (Team Leader)
  - 김인태
  - 김현교

<br>
