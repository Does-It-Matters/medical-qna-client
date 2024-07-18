# medical-qna-client

## 목적
(1) 의료 질의응답 시스템에 대한 JavaFX client Application (의료 질의응답 시스템, 운영 대시보드용 서버와 상호작용)
<br> (2) 디자인패턴 적용, 자료구조와 정렬 알고리즘 직접 구현 (컴퓨터 과학 지식 적용)

<br>

---


### 주요 기능
| |간단 설명|
| - | - |
|(1)|운영자의 resource & log 모니터링|
|(2)|일반 사용자의 의료 질의응답 서비스|
|(3)|본인의 증상과 유사한 질의응답 요청|

<br>

### 사용하는 기술
| |종류|
|-|-|
|(1)|JavaFX|
|(2)|WebSocket client|
|(3)|Java 비동기 병렬 프로그래밍|

<br>

### Layered Architecture
| |계층|역할|
|-|-|-|
|(1)|controllers|ui 입출력 전담|
|(2)|business logic|데이터 처리 로직, 핵심 비즈니스 로직 처리|
|(3)|out|데이터베이스, 파일, 네트워크 작업 처리|

<br>

### 적용된 디자인패턴 
| |패턴|적용 내용|
|-|-|-|
|(1)|Observer Pattern|카테고리 상태 관찰하여 질문 리스트 update|
|(2)|Static Factory Method|사용자(환자, 의사, 운영자)에 따라 메뉴 버튼 아이템 변경|
|(3)|Template Method Pattern|(2) 정적 팩토리 메소드 패턴과 함께 활용|
|(4)|Blocking Queue와 Producer-Consumer Pattern|로그를 전송받는 Thread와 로그를 처리하는 Thread로 분리하여 <br> 실시간 모니터링 향상 목표 예정|

<br>

### 직접 구현한 자료구조

<br>

### 직접 구현한 정렬 알고리즘

<br>

---

### 사용하는 방법

### 설치

### 실행
