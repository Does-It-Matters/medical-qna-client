# medical-qna-client
의료 질의응답 시스템의 운영자를 위한 JavaFX 클라이언트
<br> 본 프로젝트는 학습용으로 개발 중인 프로젝트로, 실제 의료 목적으로 사용될 수 없습니다 

### 목적
1. 실시간 시스템 자원, 로그 모니터링 - 중단 
2. 부하 테스트 진행 후 결과 보고서 작성 (처리량, 응답시간, 자원 사용률) - 중단  
3. 질의응답 서비스 이용

### 사용 시 주의 사항!!!
- 부하테스트 주의: 클라우드 사용 등 트래픽에 따른 비용이 과금될 수 있으니 주의하시기 바랍니다 

### 학습 목표
1. 객체지향 설계, 디자인패턴 적용, 병렬 프로그래밍
2. 스프링 부트를 결합한 JavaFX로 DI, IoC 활용하여 결합도 줄이기
3. RSocket으로 비동기 데이터 스트림 전송  

## Architecture
### v8: 응집도를 위해 멀티 모듈 구조 도입
- client
- domain-application
- domain-log
- domain-resource
- domain-test
- page-core
- utils

### v7: 여러 도메인으로 확장
소소할 줄 알았지만 많은 변화
<br> 가장 큰 변화 - 응집성 있는 구성 
<br> 이전의 목표 - 결합도 줄이기 
- application page (기존)
- log page (추가)
- resource page (추가)
- test page (추가)
```
com.example.medicalqnaclient
├── domain 
│   ├── application
│   ├── log
│   ├── resource
│   └── test
├── page.core                화면 전환 역할 정의 모듈 
├── utils
├── HelloApplication.java    JavaFX, Spring 애플리케이션 
```
```
├── domain(application, log, resource, test) 구성 
│   ├── page                 페이지 표현
│   ├── network              서버와의 통신 
│   └── mediator             page와 network 간의 중재자
```
```
├── page
│   ├── event(a)             화면 전환 event, publisher, listener 정의  
│   ├── navigator(b)         발생한 event에 해당하는 페이지 표현  
│   ├── pages(c)             각 페이지 구성 정의(page, strategy, controller)
과정 a -> b -> c -> a
(a) event -> listener 
(b) -> navigator 
(c) -> page -> strategy -> controller 
(a) -> publisher -> event
```
```
├── application.mediator            application.mediator 특화 구성 - 상태 패턴  
│   ├── state                       Doctor, Patient 등 상태 패턴 적용 
│   │   ├── core                    사용자 상태, 타입 정의
│   │   ├── exception               권한에 따른 예외 발생 
│   │   ├── factory                 Admin, All, Doctor, Patient, UserFactory
│   ├── ReadUserMediator.java       페이지 계층의 전략을 선택하는 데 활용  
│   └── ReadWriteUserMediator.java  페이지 계층의 컨트롤러 계층과 네트워크 계층의 상호작용 중재 
```

### v6: 이벤트 기반 아키텍처로 순환 참조 제거 
배경: 기존의 컨트롤러 객체와 중재자 객체 간의 상호 참조로 복잡한 설계를 간소화하기 위해 
- 스프링의 ApplicationEvent 활용 
- 전략 패턴과 템플릿 메서드 패턴 활용하여 동적 화면 적용

### v5: Fxml 대신 동적 화면으로 전환 
배경: Spring로 객체를 생성하는 것과 Fxml로 생성하는 것의 차이에 대한 어려움으로 동적 화면 구성 계획
- UI 관련 클래스 관계 재설정 
- UI와 중재자 간의 관계 재설정
- 전략 패턴 적용하여 동적 화면 구성  

### v3, 4: Spring, RSocket 적용
배경: DI, IoC를 적용하여 객체간의 결합도 줄이기, 비동기 데이터 스트림 다루기  

### v2: 객체들의 관계 정리 
배경: v1의 결합도가 강하고 계층 분리가 명확하게 되지 않아 유지보수와 확장에 어려움을 느낌
|v1 개선! 객체들 간의 결합도를 낮추기 위한 객체들의 상호작용|
|-|
|<details><summary>1. Controller 계층과의 결합도 줄이기 - Mediator 패턴 (UserContainer)</summary><br>- controller 계층은 화면 입출력 역할에 집중<br>- controller 계층은 오직 UserContainer 객체와 상호작용 <br>- UserContainer가 controller 계층과 비즈니스 로직 클래스들의 상호작용을 중재 </details> &nbsp;&nbsp;&nbsp;&rarr;&nbsp; v1의 controller 계층이 가진 복잡한 의존도 문제를 완화|
|<details><summary>2. 환자, 의사, 운영자 구분 - State 패턴 (User)</summary><br>- 각 상태들(환자, 의사, 운영자)은 User 인터페이스 구현<br>- UserContainer가 상태 관리 </details> &nbsp;&nbsp;&nbsp;&rarr; v1의 상태를 직접 확인하여 경우의 수를 처리하는 문제 완화|
|<details><summary>3. 서버 통신 관련 여러 객체들의 상호작용 - Facade 패턴 (Server)</summary><br>- Server는 단일 인터페이스로, 복잡한 클래스들의 관계를 하나의 서브 시스템으로 추상화 </details> &nbsp;&nbsp;&nbsp;&rarr; v1의 복잡한 클래스 관계들을 정리하여 간단한 하나의 인터페이스로 접근|

#### v1: Layered Architecture
| |계층|역할|
|-|-|-|
|(1)|controllers|ui 입출력 전담|
|(2)|business logic|데이터 처리 로직, 핵심 비즈니스 로직 처리|
|(3)|out|데이터베이스, 파일, 네트워크 작업 처리|
