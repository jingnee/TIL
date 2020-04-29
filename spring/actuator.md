http://www.regexlib.com/Search.aspx?k=credit&AspxAutoDetectCookieSupport=1

이사이트에서 정규식 연습해볼 수 있음

---

### Actuator

(p.110)

: 운영환경에서 필요한 유용한 기능.

**의존성 추가**

```xml
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

![image](https://user-images.githubusercontent.com/30755941/80436297-c76a6000-8939-11ea-97df-0f3e2e0e8b9c.png)

브라우저에서 내용확인

정보알려면 어떻게 접속해야하는지 알려주는거야 이런게 `헤이토스`임

다른것들은 비공개 되어있어

--> **공개 옵션 조정**

`application.properties`에 다음과 같이 입력

```
#actuator
management.endpoints.web.exposure.include=*
```

더많은 정보가 보임

등록된 bean에 대한 정보나, 로그 레벨 등등을 볼 수 있어. 그런데 문자로 되어있어서 보기가 불편해

--> **spring-boot Admin**을 통해 UI화면으로 볼 수 있다.

https://github.com/codecentric/spring-boot-admin 

:exclamation: 어제 새로만들었던:exclamation:(포트 3000번으로 했던, `SecondBootProject`)에 **의존성** 추가

어제만든 프로젝트가 서버역할을 하게 될거야

```xml
<dependency>
<groupId>de.codecentric</groupId>
<artifactId>spring-boot-admin-starter-server</artifactId>
<version>2.1.4</version>
</dependency>
```

그리고 port번호 3000에서 8090으로 변경(server.port = 8090)

`SecondBootProjectApplication.java` 상단에 annotation 추가

```java
@EnableAdminServer
```



기존의 **springboot** 프로젝트로 돌아와서 `UserRestController.java` 제일 위에 써놨던 `@CrossOrigin` annotation 막아놔

```java
//@CrossOrigin(origins = "http://localhost:3000")
```

![image](https://user-images.githubusercontent.com/30755941/80437522-bff88600-893c-11ea-91e0-e09717621c9c.png)

브라우저에서 UI뜨는지 확인 (SecondBootProject 실행시켜야해)



기존 **springboot** 프로젝트에 **의존성추가** (하기전에 myspringboot 중지!)

```xml
<dependency>
<groupId>de.codecentric</groupId>
<artifactId>spring-boot-admin-client</artifactId>
<version>2.1.4</version>
</dependency>
```

`application.properties`에 다음 추가

```
spring.boot.admin.client.url=http://localhost:8090
```

myspringboot 재실행

![image](https://user-images.githubusercontent.com/30755941/80437795-955afd00-893d-11ea-95f0-0d7aa6b0b168.png)

프로젝트 추가된거 확인! 그리고 프로젝트 눌러서 이동하면 우리가 만들었던거 나와

![image](https://user-images.githubusercontent.com/30755941/80437872-bfacba80-893d-11ea-933a-f3f045e9c666.png)

이런거 추가되어있는데 이 회색글자 클릭

들어가서 내프로젝트 정보 확인 가능

---

### 개인별로 Project 만들어보기~

## < Spring Boot를 활용한 web Application Project 생성하기>

1. Spring Boot 프로젝트

1) https://start.spring.io/ 

boot 버전 2.1, java, maven

groupid, artifactid 는 소문자로 작성

>  의존성은 web dependency 만 추가 or 필요한 dependency 검색해서 추가해도 됨

zip 파일 생성 -> unzip 한 후 -> `File` -> `Open Project`

2) Eclipse 프로젝트 안에서 생성해도 됨



devtools 의존성 추가하세요

> dependency 필요함

: dependency를 추가하는 경우는 cold start가 필요함



2. DB 연결

   : maria DB, h2 memory DB		:arrow_forward: DB 선택

: DatabaseRunner 클래스에서 현재 연결된 DB확인

- DataSource 사용, connection url, username

: spring boot jdbc 의존성 추가되어야 함



3. ORM (강사님 깃헙에서 받은 프로젝트에 두가지종류로 한거 다있으니 참고)

   : JPA, MyBatis			:arrow_forward: ORM 선택

3-1) JPA선택

> spring boot data jpa 의존성 필요함

​	: Entity Class 작성 (Table 1개와 매핑되도록)

​	: @Entity

​	: @Id, @GeneratedValue, @Column

​	: unique 컬럼 1개 추가 되도록 (컬럼은 많으면 복잡하니까 세개정도만?)

3-2) jpa 관련 설정

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

​	설정 이후에 Table 생성여부와 구조 확인

3-3) Repository Interface

: findById()는 자동생성됨

: PK이외의 칼럼에 대한 finder method를 생성할 수 있다.

findByUsername / findByEmail(String email)

3-4) TestCase 클래스 작성

: 등록/조회



4. REST 서비스 작성

4-1) RestController 클래스 작성

: 등록/수정/삭제/조회(1개, 전체)

: 기본 json format

(추가옵션) : xml format으로 조회구현도 해보기

>  jackson dependency 추가로 필요함

PostMan 툴을 사용한 테스트 

4-2) Controller 클래스 작성

: 등록/수정/삭제/조회(1개, 전체)

: static/index.html 작성

: templates/*.html (타임리프)작성

> Thymeleaf dependency 추가

4-3) Exception 처리

: System Error, custom exception