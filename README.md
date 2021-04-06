# spring-core
## 스터디 목표
- 객체지향적인 설계 개념 습득
- 역할과 구현을 나누어서 설계
  - 역할: 인터페이스 / 구현: 구현객체
  - 악덕 기획자의 요구사항 변경에도 당황하지않게 
## 환경구성
- 환경설정을 편하게 하기 위해 스프링 부트를 사용했지만 스프링의 내용없이 순수한 자바만을 사용해서 우선적으로 프로젝트를 진행해 보고 스프링의 기능을 비교해 알아본다
  - 코드의 문제점: 다른저장소로 변경시 OCP원칙 준수 안됨, DIP 준수 안됨(의존관계 인터페이스뿐만아니라 구현까지 모두 의존하는 문제점이 있음)
    - OCP원칙(Open-Closed principle 개방폐쇄 원칙)/ DIP (Dependency Inversion principle 의존관계 역전 원칙)    
    - DIP원칙을 지키기 위해 AppConfig 클래스에서 의존성을 주입할 수 있게 구성을한다=> 구현클래스에서는 인터페이스를 필드로 선언하고 생성자를 통해 의존성을 주입받을 수 있게 구현한다
    - 즉, 어떤 의존성을 받게 될지는 구현클래스는 알 수 없으며 이 결정을 하는 것은 AppConfig에서 결정할 수 있게 한 것이다. 
    - 실행클래스에서는 appConfig를 new연산자로 선언후 인터페이스에 appConfig의 의존성을 받을 수 있게 한다
    - 다시 정리하면 AppConfig에 어떤 의존성을 넣을 수 있을지를 구성하고 실행클래스에서는 appconfig를 통해 의존성을 받아 인터페이스를 생성해준 뒤, 구현객체에서는 이것을 받아 실행하게 된다.
    - AppConfig를 구성할때 클래스 다이어그램이 한눈에 보일 수 있게 세분화해서 클래스를 구성해준다.
  - 이러한 AppConfig를 DI컨테이너라고 부르며, Spring을 통해서 사용할때는 ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); 형식으로 쓴다.
  - 단순하게 생각하면 코드가 더 복잡해지는데 Spring의 장점이 무엇인지 생각해보자

## Bean조회방법
- bean조회 방법을 공부하면서 Spring의 Bean생성 개념을 이해하고, Bean을 설계할 경우 사용하는 방법을 습득한다.

## InteliJ tip
- settings gradle -> inteliJ
- settings keymap 단축키검색
  - alt+ ins generate  
  - ctrl+shift+enter 자동생성 ;
  - psvm 메인메소드 자동생성 
  - soutv system out println 
  - F2 오류부분 이동
  - test자동생성 ctrl+shift+T
  - Ctrl+E 히스토리보기
  - Ctrl+Alt+M : extract method
  - iter 향상된 for문 자동생성
## 테스트 tip
- Assertions (org.assertj.core.api) 검증
- 
## 회원 도메인 설계
- 회원 도메인 요구사항
  - 회원을 가입하고 조회할 수 있다
  - 회원은 일반과 VIP 두 가지 등급이 있다.
  - 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.(미확정)
- 회원 도메인 협력관계 (기능과 협력관계를 표시)
- 회원 클래스 다이어그램 (각 클래스들과의 의존/협력관계와 역할과 구현을 명시)
- 회원 객체 다이어그램 (런타임 환경에서의 메모리 참조(객체 관계)를 표현)


## Test
- 단위테스트를 해야 테스트 시간을 줄일 수 있다.
- 테스트의 기본적인 개념은 //given //when //then 이다.
- @DisplayName("한글표시가능") /Junit5부터 적용
- 실패 테스트도 항상 해야 한다
