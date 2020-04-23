### 스프링 부트 프로파일

: 스프링부트에서는 프로파일(Profile)을 통해 스프링 부트 애플리케이션의 런타임 환경을 관리할 수 있다.

BaseConfiguration.java : 운영을 위한 런타임 환경

TestConfiguration.java : 테스트를 위한 런타임 환경

`BaseConfiguration.java` 와 `TestConfiguration.java` 클래스를 생성해서 다음과 같이 입력해준다.

```java
@Profile("prod")
@Configuration
public class ProductionConfig {
	@Bean
	public String hello() {
		return "운영환경 에서 사용되는 hello Bean";
	}
}
```

```java
@Profile("test")
@Configuration
public class TestConfig {
	@Bean
	public String hello() {
		return "테스트환경 에서 사용되는 hello Bean";
	}
}
```

그리고 `properties`파일에 다음을 추가해준다. 여기있는 'test'는 @Profile('test')안에 있는 test를 의미한다. 즉 테스트환경으로 런타임한다는 의미

```
spring.profiles.active=test
```

그리고 `Runner.java`에 다음과 같이 추가해준다.

```java
@Autowired
String hello;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println(">> Hello Bean : " + hello);
        ...
    }
```

![image](https://user-images.githubusercontent.com/30755941/79931098-1bca9700-8485-11ea-98ed-3715962a55c1.png)

이렇게 뜨는것을 볼 수 있다.

jar로 시작할때 

`java -jar myspringboot-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod`

로 입력하면 prod 즉 운영환경에서 런타임한다는것을 볼 수 있다.

### Spring-Boot-Devtools

: 클래스 패스에 있는 파일이 변경될 때마다 자동으로 재시작 해준다.

pom.xml에 다음 devtools dependency를 추가해준다.

```xml
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-devtools</artifactId>
</dependency>
```



### Logging

#### - 로깅 퍼사드 VS 로거

퍼사드 : 디자인패턴중에 퍼사드라는 패턴이 존재.(대문 이라는 뜻) 즉, 인터페이스를 의미

대표적인 로깅 퍼사드 : Common Loggin , SLF4j

로깅 퍼사드를 통해서 Logger를 사용하는 이유? 로깅 구현체들을 __교체__하기 쉽게 해줘















HikariCP