# DI(Dependency Injection)



### Setter Injection , Constructor Injection

<bean>을 만나는 순간 기본생성자를 생성하고 세팅을 이행해

setter injection인 경우 property를 보고 기본생성자를 생성하고 setter를 만들어

constructor injection인 경우 constructor-arg태그를 보고 인자가 있는 생성자를 만들어줘(오버로딩 생성자)  

  #  

### Collection 타입의 값 주입

#### List와 Set 타입

```java
public class Hello{
    List<String> names;
    
    public void setNames(List<String> list){
        this.names = list;
    }
}
```

__beans.xml__

```xml
<bean id="helloC" class="Myspring.di.xml.Hello">
<property name="names"> <!-- setNames(List<String>) -->
	<list>
		<value>Java</value>
		<value>Kotlin</value>
		<value>Scalar</value>
		<value>Java</value>
	</list>
	</property>
</bean>    
```

__test.java__

```java
List<String> names = hello.getNames();
		for (String name : names) {
			System.out.println(name);
		}
```

#  

#### Map 타입

```java
public class Hello{
    Map<String, Integer> ages;
    
    public void setAges(Map<String,Ingeger> ages){
        this.ages = ages;
    }
}
```

__beans.xml__

```xml
<bean id="hello" class="Myspring.di.xml.Hello"/>	
<property name="ages"> <!-- setAges(Map<String,Integer> -->
		<map>
		<entry key="java" value="10"/>
		<entry key="js" value="20"/>
		<entry key="react" value="30"/>
		<entry key="java" value="50"/>
	</map>
```

__test.java__

```java
Map<String, Integer> ages = hello.getAges();
//1. Map의 keySet() 사용
//ages.keySet() => Set<String>
	for (String key : ages.keySet()) {
		System.out.println(key + " : " + ages.get(key));
	}
		
//2. Map의 entrySet() 사용
//ages.entrySet9) => Map.Entry<String,Integer>
	for (Map.Entry<String, Integer> entry : ages.entrySet()) {
		System.out.println(entry.getKey() + " : " + entry.getValue());
	}
```

#  

### DI 구현하는 방식

#### 1. XML Based

 : bean 등록 __`<bean id="" class=""/>`__

 : setter injection 

​	__`<property value=""/>`__

​	__`<property ref=""/>`__

 : constructor injection

​	__`<constructor-arg value=""/>`__

​	__`<constructor-arg ref=""/>`__

#### 2. Annotation Based : component-scan설정을 위해서 xml 부분적으로 사용

 : bean 등록 __`@Component`__

 : setter injection - 어노테이션을 변수 위에, setter 메서드 위에 선언

​	__`@Value`__

​	__`@Autowired`__, __`@Qualifier`__

 : constructor injection - 어노테이션을 변수 옆에, 생성자 위에 선언

​	__`@Value`__, __`@Qualifier`__는 생성자의 변수 옆에

​	__`@Autowired`__는 생성자의 위에

#### 3. Annotation Based : xml을 전혀 사용하지 않음

 : Java로 Configuration 클래스를 작성한다.

__`@Configuration`__ 

 : __`@Bean`__ annotation으로 선언하지 않는 클래스를 Bean으로 등록

 : __`@ComponentScan`__ @Component annotation으로 선언됨 Bean을 찾을때









지금까지 한 방법은 __모든 Bean을 명시적으로 XML에 등록하는 방법__이다.

여러개발자가 같은 설정파일을 공유해서 개발하다보면 설정파일을 동시에 수정하다가 충돌이 일어나는 경우도 적지 않다.

생성되는 모든 Bean을 XML에서 확인할 수 있다는 장점이 있으나 Bean의 개수가 많아지면 XML 파일을 관리하기 번거로울 수 있다.

:exclamation: 그래서 __어노테이션과 XML 설정을 혼용해서 사용__ 해보자

<bean> :arrow_forward: @Component

<property value=""/> :arrow_forward: @Value

<property ref=""/> :arrow_forward: @Autowired

 : 타입(type)으로 해당되는 Bean을 찾아서 주입해주는 annotation

 @Resource

 : Bean의 이름(id)으로 해당되는 Bean을 찾아서 주입해주는 annotation

@Qualifier

 : 동일한 타입이 여러개가 있을 때 특정 Bean을 지정하는 annotation(단독으로 쓰이는 경우가 없고, 항상 Autowired와 함께 쓰임)

 : Bean의 ~~

##  

annotation만 쓴다고 beans.xml이 알아 볼 수 있는건 아니야. 

```xml
<context:component-scan base-package="Myspring.di.annot"/>
```

을 꼭 써주어야 한다.  

#  

![image](https://user-images.githubusercontent.com/30755941/78962020-4421cf80-7b2e-11ea-8621-78e25335987d.png)



















---

__단축키__

`alt`+`shift`+`l` :  왼쪽에 타입 자동 생성

---

**annotation**

`@Test` : test method

`@Before` : test method 전에 호출  

`@RunWith` : Test Runner를 확장할때

`@ContextConfiguration` : Spring Bean xml 파일의 정보를 설정할때  

`@Component`,`@Repository`,`@Service`,`@Controller` : Spring Bean 등록(생성)

`@Value` : Spring Bean의 의존성 주입, 값을 주입 (setter injection에 value값 줄때)

`@Autowired` / `@Resource` (javax.annotation): Spring Bean의 의존성 주입(Container가 의존하는 Bean을 찾아서 주입 해준다.), reference를 주입

`@Qualifier` : @Autowired와 같이 사용되며, 특정 Bean의 id를 지정한다.

#  

Spring Bean Configuration xml 를 사용하는 경우 
: GenericXmlApplicationContext - Spring Bean 컨테이너
Spring Bean Configuration 클래스(no xml) 를 사용하는  경우
: AnnotationConfigApplicationContext - Spring Bean 컨테이너