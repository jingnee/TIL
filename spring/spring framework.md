# Spring Framework

##  : 자바기반 엔터프라이즈 어플리케이션을 작성하기 위한 프로그램이나 설정 모델을 제공한다. (Configuration - XML)

핵심 요소 : __infrastructural support__ (기반이 되는 서비스) 

logging, 인증, 트랜잭션 관리 - non funtional

업무로직관련 - functional

spring은 `plumbing`(배관작업) 에 초점을 맞춘다. 즉, __`비기능적인 요소`__에 개발자들이 초점을 맞춘다.

비기능적(Non-Functional) 요구사항 (성능, 보안, 확장성, 안정성등)을 만족하는 구조와 구현된 기능을 안정적으로 실행하도록 제어해주는 잘 만들어진 구조의 라이브러리 덩어리  

#  

---

#### Features

- Core technologies : __DI(Dependency Injection)__ , AOP(관점 지향 프로그래밍)
- Testing : TextContext framework(TDD작성할 수 있게하는 프레임워크)
- Data Access : transactions, DAO(Data Access object), JDBC(Java DataBase Connectivity), ORM(Object Relational Mapping)-java DB와 RDB관계형 데이타베이스를 어떻게 매핑하는지(대표적으로 Mybatis, JPA(Java Persistence architecture)가 있음. 영속성관련)
- Spring MVC(Model View Controller)-웹 어플리케이션을 작성하는 프레임 워크.(MVC : 역할을 분리해서 코드를 짜는 아키텍쳐 패턴)
- Languages : Kotlin, Groovy, dynamic languages  



---

#  

#### Framework vs Library

제어권의 주도권을 누가 가지느냐의 차이!

Library의 경우 객체생성은 개발자가 직접 한다.

Framwork는 개발자가 class까지 만들면 framework가  제공하는 컨테이너가 싱글톤패턴을 적용해서 객체생성을 해줘. 개발자는 xml에다가 설정을 해놓으면 돼. 내가만든 클래스는 ~에 있어, 내가만든 클래스는 이런거야~ 라고. 그래서! XML을 configuration(설정)이라고 하는거야. 프레임워크는 XML을 파싱하는거야

xml은 개발자와 프레임워크간의 소통 수단이 된다.

| 특징            | 프레임워크                                | 라이브러리                   |
| --------------- | ----------------------------------------- | ---------------------------- |
| 유저코드의 작성 | 프레임워크 클래스를 서브 클래싱 해서 작성 | 독립적으로 작성              |
| 호출흐름        | 프레임워크 코드가 유저코드를 호출         | 유저코드가 라이브러리를 호출 |
| 실행흐름        | 프레임워크가 제어                         | 유저코드가 제어              |
| 객체의 연동     | 구조프레임워크가 정의                     | 독자적으로 정의              |

여기서 스프링의 특징중 하나인 IoC가 설명된다.

__IoC(Inversion of Control)__ : `제어의 역전` 즉, 인스턴스 생성부터 소멸까지 인스턴스 생명주기 관리를 개발자가 아닌 컨테이너가 대신 해준다는 뜻이다.

즉, 컨테이너 역할을 해주는 프레임 워크에게 제어하는 권한을 넘겨서 개발자의 코드가 신경 써야 할 것을 줄이는 전략이다.

Bean - 스프링이 관리 해주는 객체  



__IoC의 분류__ 

- DL (Dependency Lookup) 의존성 검색
- DI (Dependency Injection) 의존성 주입
  - Setter Injection
  - Constructor Injection
  - Method Injection 

---

#  

[tomcat 다운](http://tomcat.apache.org/download-80.cgi#8.5.53)

서버추가 : 

서버스탭에서 뉴>서버>Apache드롭다운>Tomcat v8.5 Server클릭 > 넥스트 > installation directory 탐캣설치된곳 지정 

서버탭 더블클릭 -> 포트변경 

HTTP 8080 -> 8087로 변경

서버 스타트까지 해보기  

##   

__web Project 생성__

1. dynamic web project 생성(web.xml설정 체크)
2. Maven project로 변경(Configure>convert to Maven projecet)후 pom.xml파일이 생성되었는지 확인하기
3. pom.xml에 다음추가

```xml
<dependencies>
<dependency>
https://mvnrepository.com/artifact/org.springframework/spring-context/4.3.26.RELEASE
	여기에서 Maven 에있는부분추가(spring Context)
</dependency>
</dependencies>
```

  3.1하고 Maven Dependencies 생겼는지 확인. 만약에 안생겼으면 update maven project

4. src아래에 spring bean configuration File 생성  

## 

**Spring Framework 전략**

Spring 삼각형(DI + AOP + PSA)

엔터프라이즈 개발의 복잡함을 상대하는 Spring의 전략

:arrow_forward: Portable Service Abstraction, DI, AOP, POJO

- Portable Service Abstraction(서비스 추상화)
- 객체지향과 DI(Dependency Injection)
- AOP(Aspect Oriented Programming)
- POJO(Plain Old Java Object)

###  

:fire: __중요__!(Spring DI 용어)

Bean : 스프링이 만들어 주는 객체

BeanFactory는 Spring Bean 컨테이너 역할을 한다.

BeanFactory의 getBean()메서드로 요청을 한다.

Application Context도 Spring Bean컨테이너 역할을 한다.

spring Bean Configuration File 설정 메타정보. IoC컨테이너에 의해 관리되는 Bean 객체를 생성하고 구성할 때 사용

```
Hello hello = new Hello(); (x)

BeanFactory factory = new GenericApplicationContext();
Hello hello = (Hello)factory.getBean("hello"); (O)
```





































---

##### 용어정리

DI (Dependency Injection) 의존성 주입

IoC (Inversion of Control) 제어의 역전

AOP (Aspect Oriented Programming) 관점지향 프로그래밍 -> 이해해야지 스프링에서 트랜잭션 처리를 어떻게하는지 이해할 수 있다.

JSP (java server page)

RESTful (Representational State Transfer) 웹에서 JSON, xml으로 데이터를 전달하는 방법

AJAX(Asynchronous javascript and XML React)

JPA (java persistence api)

OXM (Object Xml Mappling)

EJB (Enterprise Java Beans) 스프링 나오기전에 사용하던 기술. 근데 반드시 WAS가 있어야 사용할 수 있었어. WAS를 이용해서 deploy 해야하는데, 너무 불편해 그래서 Spring이 나타났는데, 이게 무시 sensational했다.

WAS(Web application server) 웹 애플리케이션과 서버 환경을 만들어 동작시키는 기능을 제공하는 소프트웨어 프레임워크 - WAS사용하는 제품들 : JEUS, web sphere, web logic

#  

spring 유지보수 하는 회사 : pivotal

<단축키>

코드 들여쓰는 단축키 : `ctrl`+`shift`+`f`

auto import : `ctrl`+`shift`+`o`

xml comment : `ctrl`+`shift`+`c`

java comment : `ctrl`+`/`

run : `ctrl`+`F11`

