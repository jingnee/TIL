# Regular Expression(정규표현식)

## 정규표현식은 문자열에서 특정 내용을 찾거나 대체 또는 발췌하는데 사용한다.

ex) 사용자 비밀번호가 유효한 비밀번호인지 체크할때..

  

정규표현식은 **`정규식 리터럴`** 과 __`RegExp 객체`__로 만들 수 있다.

### 정규식 리터럴 

```javascript
const regular = /pattern/;
```

### RegExp 객체

```javascript
new RegExp(pattern[, flags]);
```

  

### 메소드

```javascript
const str = 'My name is AMY';
const regexp = /am/ig;
```



#### - RegExp 객체의 메소드

**_1. regexObj.exec(str)_**

: __`exec()`__ 메소드는 어떤 문자열에서 정규표현식과 일치하는 문자열 검색을 수행한다. 배열을 리턴하거나 null을 반환

![image](https://user-images.githubusercontent.com/30755941/78573081-3edd3000-7863-11ea-84cc-71e5ec0ee3dc.png)

__*2. regexObj.test(str)*__

: __**test()**__ 메소드는 대상 문자열 속에 일치하는 문자열이 포함되어 있는지 검사하고 true 또는 false를 반환

![image](https://user-images.githubusercontent.com/30755941/78573208-6c29de00-7863-11ea-9428-69d8947d5f53.png)

  

#### - String 객체의 메소드

__*1. str.match(regexp)*__

: __**match()**__ 메서드는 문자열이 정규식과 매치되는 부분을 검색. 문자열이 정규식과 일치하면 일치하는 전체 문자열을 첫 번째 요소로 포함하는 배열을 반환. 일치하는 것이 없으면 null을 반환

![image](https://user-images.githubusercontent.com/30755941/78573565-d2166580-7863-11ea-8e5a-c2895109c1b5.png)

__*2. str.replace(regexp|substr, newSubstr|function)*__

: __**replace()**__ 메서드는 어떤 패턴에 일치하는 일부 또는 모든 부분이 교체된 새로운 문자열을 반환. pattern이 문자열인 경우, 첫번째 문자열만 치환되며 원래 문자열은 변경되지 않음

![image](https://user-images.githubusercontent.com/30755941/78573839-23bef000-7864-11ea-9517-cd99999889a9.png)

  __*3. str.search(regexp)*__

: __`search()`__ 메서드는 정규표현식과 이 string 객체간에 같은것을 찾기 위한 검색을 실행한다. 첫번째로 매치되는 인덱스를 반환한다. 찾지못할경우 -1 반환

![image](https://user-images.githubusercontent.com/30755941/78574065-6f719980-7864-11ea-9e4d-4226a0ccc467.png)

__*4. str.split([separator[, limit]])*__

: __`split()`__ 메서드는 string 객체를 지정한 구분자를 이용하여 여러개의 문자열로 나눈다. 주어진 문자열을 구분자마다 끊은 부분 문자열을 담은 배열을 반환

![image](https://user-images.githubusercontent.com/30755941/78574207-a0ea6500-7864-11ea-8bde-67f8029fc5fd.png)

  

### 플래그

| Flag | Meaning     | Description                               |
| ---- | ----------- | ----------------------------------------- |
| i    | Ignore Case | 대소문자를 구별하지 않고 검색             |
| g    | Global      | 문자열 내의 모든 패턴을 검색              |
| m    | Multi Line  | 문자열의 행이 바뀌더라도 검색을 계속한다. |

  

### 패턴

```
^x				문자열이 x로 시작
x$				문자열이 x로 끝남
.x				x가 마지막으로 끝나는 문자
x+				x가 1번이상 반복
x?				x가 존재하거나 존지하지 않음
x*				x가 0번이상 반복
x|y				x또는 y를 찾음
(x)				()안의 내용을 캡쳐하며, 그룹화함
(x)(y)			
(X)(?:y)
x{n}			x를 n번 반복한 문자를 찾음
x{n,}			x를 n번이상 반복한 문자를 찾음
x{n,m}			x를 n번이상 m번 이하 반복한 문자를 찾음
```

```
[xy]			x,y중 하나를 찾음
[^xy]			x,y를 제외하고 문자 하나를 찾음
[x-z]			x~z사이의 문자중 하나를 찾음
\^				^를 식에 문자 자체로 포함
\b				문자와 공백 사이의 문자를 찾음
\B				문자와 공백사이가 아닌 값을 찾음
\d				숫자를 찾음
\D				숫자가 아닌 값을 찾음
\s				공백문자를 찾음
\S				공백이 아닌 문자를 찾음
\t				Tab 문자를 찾음
\v				Vertical Tab문자를 찾음
\w				알파벳+숫자+_ 를 찾음
\W				알파벳+숫자+_ 를 제외한 모든 문자를 찾음
```

