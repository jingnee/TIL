# JDBC 이용하기

### 4.

 : 등록,갱신,삭제

 int cnt = stmt.executeUpdate

### 5. 사용했던 자원들(Resources)을 반납

 : ResultSet, Statement, Connection의 close()

### ORM(Object Relational Mapping)

 : MyBatis, JPA

 : 매핑 Rule

| java      | <=>  | db          |
| --------- | ---- | ----------- |
| Class(VO) |      | Table       |
| Object    |      | Row(Record) |
| Variable  |      | Column      |





__`StringBuilder`__ : StringBuffer랑 똑같지만 5.0이후에 나옴. 성능 더 좋아

statement를 사용하고, stringBuilder를 사용한 불편한 방법

```java
//String sql = "update users set name='길동홍', gender='여', city='부산' where userid='gildong';"
String name = "마우스";
String gender = "여";
String city = "여수";
StringBuilder builder = new StringBuilder();
builder.append("update users set name='" + name + "', gender=" + gender + "', city='" + city + "' where userid='gildong';")
```

하나하나 concat하기가 너무 귀찮아

그래서 prepare statement를 사용한다.

statement의 경우 실행할때(excuteQuery할때 인자로 넣는다.)

preparedstatement는 sql문을 미리 컴파일해놓는다. 가변적인부분을 `?`로 해서! (얘는 excuteQuery하기전에 이미 sql문 전달했어)

preparedstatement를 사용한 방법

```java
String sql = "update users set name=?, gender=?, city=? where userid=?";
...
stmt = con.prepareStatement(sql);
stmt.setString(1,"마이바이티스");
stmt.setString(2, "여");
stmt.setString(3, "경기");
stmt.setString(4,"gildong");
			
int cnt = stmt.executeUpdate();
...
```

|      | Statement                                                    | PreparedStatement                                            |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 장점 | 원하는 Query를 직접 넣어주기 때문에 직관적이고 사용하기 쉽다. | 같은 Query를 반복 수행해야 하는 경우 성능이 좋다. (loop 이용이 용이) |
| 단점 | 실행시마다 SQL문을 해석해서 오버헤드가 크다.                 | 코드가 길어질 수 있다.                                       |

Statement가 상위 클래스임. 그래서 객체 생성할때 Statement로 생성해도 상관은 없음(polymorph)







---

`alt`+`shift`+`L` : 리턴타입맞게 변수 생성

블록지정 >> `Surround With` >> `Try/catch` : 블록된 코드를 감싸는 try/catch문 생성

`Package Explorer`에서 파일명 누른상태에서 `F2` : rename