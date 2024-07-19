# medical-qna-client
의료 질의응답 시스템에 대한 JavaFX 클라이언트

### 목적
1. 시스템 자원과 로그 모니터링
2. 질의응답 서비스 이용

### 학습 목표
객체지향 설계, 디자인패턴 적용, 병렬 프로그래밍, 자료구조와 정렬 알고리즘 직접 구현 등 배운 이론을 실제 적용

<br>

## Architecture
### v2: 새롭게 진행 중
배경: v1의 결합도가 강하고 계층 분리가 명확하게 되지 않아 유지보수와 확장에 어려움을 느낌
|객체들간의 결합도를 낮추기 위한 객체들의 상호작용|
|-|
|<details><summary>1. Controller 계층과의 결합도 줄이기 - Meditator 패턴 (UserContainer)</summary><br>- controller 계층은 화면 입출력 역할에 집중<br>- controller 계층은 오직 UserContainer 객체와 상호작용 <br>- UserContainer가 controller 계층과 비즈니스 로직 클래스들의 상호작용을 중재 </details> &nbsp;&nbsp;&nbsp;&rarr;&nbsp; v1의 controller 계층이 가진 복잡한 의존도 문제를 완화|
|<details><summary>2. 환자, 의사, 운영자 구분 - State 패턴 (User)</summary><br>- 각 상태들(환자, 의사, 운영자)은 User 인터페이스 구현<br>- UserContainer가 상태 관리 </details> &nbsp;&nbsp;&nbsp;&rarr; v1의 상태를 직접 확인하여 경우의 수를 처리하는 문제 완화|
|<details><summary>3. 트랜잭션 스크립트 문제 - Delegation 활용</summary><br>- 각 상태들은 처리해야 할 작업들을 객체로 가짐 </details> &nbsp;&nbsp;&nbsp;&rarr; v1의 데이터를 직접 절차적으로 처리하는 과정 대신 작업 처리 객체들에 위임|
|<details><summary>4. new 생성 - 의존성 주입</summary><br>- UserContainer는 각 상태들의 생성자로 서버를 주입<br>- 각 상태들은 서버로 처리해야 할 작업 객체들의 생성자에 서버를 주입 </details> &nbsp;&nbsp;&nbsp;&rarr; v1의 new로 인한 구체적인 구현에 의존하는 문제 완화|
|<details><summary>5. 서버 통신 관련 여러 객체들의 상호작용 - Facade 패턴 (Server)</summary><br>- Server는 단일 인터페이스로, 복잡한 클래스들의 관계를 하나의 서브 시스템으로 추상화 </details> &nbsp;&nbsp;&nbsp;&rarr; v1의 복잡한 클래스 관계들을 정리하여 간단한 하나의 인터페이스로 접근|
|<details><summary>6. 많은 DTO 관리 - 패키지 구성 (작업 단위)</summary><br>- User와 Server 구현체들은 처리해야 할 작업들을 객체로 가짐 (Delegation 활용)<br>- 상태와 서버의 객체들이 수행할 작업 단위로 패키지를 구성하여 DTO 클래스 관리 </details> &nbsp;&nbsp;&nbsp;&rarr; v1의 많은 클래스 관리 문제 완화|

#### v1: Layered Architecture
| |계층|역할|
|-|-|-|
|(1)|controllers|ui 입출력 전담|
|(2)|business logic|데이터 처리 로직, 핵심 비즈니스 로직 처리|
|(3)|out|데이터베이스, 파일, 네트워크 작업 처리|

#### 기타 설계
| |패턴|적용 내용|
|-|-|-|
|(1)|Observer Pattern|카테고리 상태 관찰하여 질문 리스트 update|
|(2)|Static Factory Method|사용자(환자, 의사, 운영자)에 따라 메뉴 버튼 아이템 변경|
|(3)|Template Method Pattern|(2) 정적 팩토리 메소드 패턴과 함께 활용|
|(4)|Blocking Queue와 <br> Producer-Consumer Pattern|로그를 전송받는 것과 처리하는 것을 두 Thread로 분리하여 <br> 실시간 모니터링 향상 목표 예정|

<br>

### 직접 구현한 자료구조

<br>

### 직접 구현한 정렬 알고리즘

<br>

### 사용하는 기술
| |종류|
|-|-|
|(1)|JavaFX|
|(2)||
|(3)||

<br>

### 실행 모습
