FrontEnd Framework/Library

: jQuery

: Reqct, Vuejs, Angular

: server side 연동할 때 ajax



기존 서버코드는 jsp를 사용해서 구현

기존의 서버코드(jsp)를 이용해서 클라이언드 js 를 vuejs나 react를 사용하고 싶어요 가능할까요? 안됨

왜?? Server는 클라이언트에게 data(json, xml)만 전달해야 한다.



third-party library/framework

: tomcat - web container

: log4j - logging, log level

: mybatis - ORM, db 연동

: jackson - json parser

: junit : 단위테스트 지원

: dbcp (database connection pooling) -  connection pooling



java

: jdbc, Servlet/JSP, jaxb

---

# 스프링부트 시작하기

![image](https://user-images.githubusercontent.com/30755941/79817502-92ea2780-83c0-11ea-9976-b403e316a256.png)

스프링 부트 프로젝트 생성방법

![image](https://user-images.githubusercontent.com/30755941/79824919-73f49100-83d2-11ea-9aa7-32f854df2dcd.png)

스프링부트 실행





#### :exclamation:유의할점:heavy_exclamation_mark:

1. base package(__src/main/java__) 외에 별도의 패키지 만들지 말것!

   이유 : base package가 componentScan을 시작하는 package 이므로

2. 테스트 코드는 반드시 __src/main/test__ 아래에 작성 

   이유 : boot test Dependency 설정에서 scope이 test로 범위가 정해져 있기 때문

   ```xml
   <scope>test</scope>
   ```

3. src/main/resources/__static__ : 정적 파일(순수 html, css, javascript)

4. src/main/resources/__templates__ : template엔진 (jsp, thymeleaf(타임리프파일은 html임))

5. __src/main/resources__ 아래에 `application.properties` 파일이 위치해야 함

6. __src/main/resources__ 하위에 sub 폴더를 생성한 후에는 반드시 config class에 설정해야함

#  

#### - Spring boot 배너 변경하기

src/main/resources 아래에 `banner.txt` 만들어서 원하는 내용 나오게 바꾸고 리스타트 해주면 콘솔창에 크게 SPRING 써있던 글자가 바뀐다.

```
===============================================================
My Spring Boot ${spring-boot.version} / ${application.version}
===============================================================
```

#### - 이벤트 리스너(Event Listener())

__ApplicationStartingEvent__ : 스프링 컨테이너가 생성되기 전에 생성되는 이벤트이기 때문에 이 이벤트를 처리하려면 SpringApplication 객체에 해당 리스너를 추가해야 함

​	1) Base package 아래에 listener package 생성

​	2)`ApplicationListener`class를 implements하는 클래스를 생성

​	3) `onApplicationEvent` 함수를 override 해주고 내용 입력	

```java
public class MyStartingEventListener implements ApplicationListener<ApplicationStartingEvent>{
	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("Spring Bean 컨테이너 생성전에 호출됨 ApplicationStarting Event " + new Date(event.getTimestamp()));
		
	}
}
```

​	4) Application.java 에 Listener 객체를 등록시켜준다.

```java
application.addListeners(new MyStartingEventListener());
```



__ApplicationStartedEvent__ : 스프링 컨테이너가 만들어진 이후에 생성되는 이벤트들은 스프링 Bean 등록을 통해 이벤트를 처리할 수 있다.

​	1) Base package 아래에 listener package 생성

​	2)`ApplicationListener`class를 implements하는 클래스를 생성

​	3) `onApplicationEvent` 함수를 override 해주고 내용 입력

```java
@Component
public class MyStartedEventListener implements ApplicationListener<ApplicationStartedEvent>{
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("Spring Bean 컨테이너가 생성된 후에 호출됨 " + new Date(event.getTimestamp()));
		
	}
}
```

__@Component__를 입력해 주어야하고, Application.java에 등록할 필요 없다.



출력 확인

![image](https://user-images.githubusercontent.com/30755941/79835243-54b52e00-83e9-11ea-8de0-ffa69bd7c7eb.png)

위에 빨간색 네모가 __StartingEventListener__의 내용 (배너 <<파란색 네모 전에  출력됨!)

아래 빨간색 네모가 __StartedEventListener__의 내용 (제일 마지막에 출력됨!)



#### - Application Runner

 : SpringApplication 실행된 후에 arguments 값을 받거나, 무엇인가를 실행하고 싶을 때 ApplicationRunner 인터페이스를 구현하는 Runner 클래스를 작성. 순서 지정 가능(@Order(1))

아규먼트 설정 방법! (Program arguments와 VM argumets 두개의 인자를 넣음)

Application : Application.java 또는 프로젝트 클릭

```
Application -> Run Configuration -> Program arguments 	-> --bar 를 추가한다.
								 -> VM arguments 		-> -Dfoo 를 추가한다.
```

```java
@Component
//Ruuner 클래스 중에서 실행 순서가 가장 먼저라는 의미
@Order(1)
public class MyRunner implements ApplicationRunner{
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("SourceArgs " + args.getOptionNames());
		System.out.println("Program Arguments " + args.containsOption("bar"));
		System.out.println("VM Arguments " + args.containsOption("foo"));
		
	}
}
```

<img src="https://user-images.githubusercontent.com/30755941/79837877-16ba0900-83ed-11ea-813e-83113ffb124e.png" alt="실행결과" />



#### - 외부설정 1

Properties 파일을 통한 설정 : properties의 값은 @Value 어노테이션을 통해 읽어올 수 있다.

`application.properties`에 다음과 같이 작성 (name,age,fullName값 아무거나 상관없음)

```
jineey.name=\uC2A4\uD504\uB9C1
jineey.age=${random.int(1,50)}
jineey.fullName=${jineey.name} \uBD80\uD2B8
```

`MyRunner.java`에 다음을 추가

```java
public class MyRunner implements ApplicationRunner{
	@Value("${jineey.name}")
	private String name;
	
	@Value("${jineey.age}")
	private int age;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println(">> Property Name " + name);
		System.out.println(">> Property Age " + age);
		
        ...	
	}
}
```

![image](https://user-images.githubusercontent.com/30755941/79843807-b380a480-83f5-11ea-8d48-b67eb8d1ef51.png)



#### -외부설정 2

@ConfigurationProperties 어노테이션을 통한 외부 설정값 주입.

장점 : 어노테이션을 통해 자동 주입하는 방법이 type-safe, 유지보수 측면에서 더 좋다.

1) property Class를 생성한다.

2) property class를 Bean으로 등록해서 다른 Bean에 주입







---

단축키

`ctr`+`shift`+`T` : class open

myspringboot-0.0.1-SNAPSHOT.jar