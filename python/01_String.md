# String

문자열 변수

```python
my_str1 = "스트링"
my_str2 = '스트링'

#개행문자와 함께 문자열을 저장할 수 있다.
my_str3="""스타벅스
할리스
이디야
"""
```

"""사이에 문자열을 개행문자와 함께 쓰면 개행문자와 함께 문자열을 저장할 수 있다. '''로 해도 가능

![image](https://user-images.githubusercontent.com/30755941/94547583-68af6680-028a-11eb-8f41-14c1381fef96.png)

- Formatting

  포맷형식을 이용할 수 있다. (C언어처럼)

  :grey_exclamation: "string __`%s`__" __`% 'format'`__

  ```python
  #%s는 문자열 대입(문자열 외 아무거나 해도 대입됨)
  >>> my_str = 'My name is %s' %'Jingnee'
  >>> my_str
  'My name is Jingnee'
  
  #%d는 정수 대입
  >>> "%d %d" % (1,2)
  '1 2'
  
  #%f는 실수 대입
  >>> '%f' % 3.14
  '3.140000'
  
# 정렬과 공백(전체길이가 10개인 문자열 공간에서 오른쪽 정렬)
  >>> "%10s" % "hi"
'        hi'
  # 전체길이가 10개인 문자열에서 왼쪽 정렬(hi다음에 8칸)
>>> "%-10sjane." % "hi"
  'hi        jane.'

  # 소숫점 4자리까지 출력
>>> "%0.4f" % 3.42134234
  '3.4213'
  # 소숫점 4자리까지만 표시하고 전체 길이가 10개인 문자열 공간에서 오른쪽 정렬
  >>> "%10.4f" % 3.42134234
  '    3.4213'
  ```
  
  :grey_exclamation: __`'{}'.format()`__
  
  위에서 %s(%d나 %f포함) --> {}
  
  % --> format()
  
  로 바뀐다고 보면 된다.
  
  ```python
  >>> "My name is {}".format('jingnee')
  'My name is jingnee'
  
  #여러개를 대입할 수 있다.
  >>> '{} X {} = {}'.format(2,3,2*3)
  '2 X 3 = 6'
  
  # {}안에 format안에 들어가는 내용의 인덱스를 넣어서 순서도 정할 수 있다.
  >>> '{1} X {0} = {2}'.format(2,3,2*3)
  '3 X 2 = 6'
  ```



- 정렬

  ```python
  # :<10은 치환되는 문자열을 왼쪽으로 정렬하고 문자열의 총 자릿수를 10으로 맞춤
  >>> "{:<10}".format("hi")
  'hi        '
  
  # 오른쪽 정럴
  >>> "{0:>10}".format("hi")
  '        hi'
  
  # 가운데 정렬
  >>> "{:^10}".format("hi")
  ```

- 공백 채우기

  ```python
  >>> "{:=^10}".format("hi")
  '====hi===='
  
  >>> "{0:!<10}".format("hi")
  'hi!!!!!!!!'
  ```



- f문자열 (파이썬 3.6 이상의 버전만 가능)

  ```python
  >>> name = "홍길동"
  >>> age=30
  >>> f"나의 이름은 {name}입니다. 나이는 {age}입니다."
  '나의 이름은 홍길동입니다. 나이는 30입니다.'
  
  # 정렬
  >>> f"{name:^10}"
  '   홍길동    '
  ```

  

- Indexing

  문자열중 하나를 뽑음

  ```python
  >>> my_str = 'My name is {}'.format("jingnee")
  >>> my_str
  'My name is jingnee'
  
  >>> my_str[5]
  'm'
  
  #음수의 경우 뒤에서부터 인덱스를 셈(마지막 문자는-1)
  >>> my_str[-5]
  'n'
  # -0은 0이랑 같음
  >>> my_str[-0]
  'M'
  >>> my_str[-1]
  'e'
  ```

  

- Slicing

  문자열 여러개를 뽑음

  ```python
  my_str = 'My name is jingnee'
  # 1번 인덱스부터 4번인덱스 전까지 (1<= <4)
  >>> my_str[1:4]
  'y n'
  
  #앞의 숫자나 뒤의 숫자를 생략할 수 있다. 생략된 숫자는 제일 끝쪽을 의미
  >>> my_str[1:]
  'y name is jingnee'
  >>> my_str[:4]
  'My n'
  >>> my_str[:]
  'My name is jingnee'
  
  #시작 인덱스값이 더 크다고 오류가 나지는 않는다
  >>> my_str[5:3]
  ''
  # -인덱스도 당연히 된다. my_str[-10]은 is에서 i임
  >>> my_str[1:-10]
  'y name '
  ```

  

- string.split()

  문자열 을 공백(default)으로 쪼개서 리스트를 반환

  ```python
  >>> fruit = '거봉 수박 포도 사과 귤 오렌지 딸기 망고'
  >>> fruits = fruit.split()
  >>> fruits
  ['거봉', '수박', '포도', '사과', '귤', '오렌지', '딸기', '망고']
  
  #()안에 넣은 문자열로 쪼갤 수 있음
  >>> fruit.split('사')
  ['거봉 수박 포도 ', '과 귤 오렌지 딸기 망고']
  >>> fruit.split('사과')
  ['거봉 수박 포도 ', ' 귤 오렌지 딸기 망고']
  ```



- string.count() 

  문자열 갯수 세기

  ```python
  >>> a="hobby"
  >>> a.count('b')
  2
  ```



- string.find()

  위치 알려주기

  ```python
  >>> a.find('b')
  2
  # 문자열이 존재하지 않는경우 -1 리턴
  >>> a.find('e')
  -1
  ```

- string.index()

  ```python
  >>> a.index('b')
  2
  # 문자열이 존재하지 않는경우 에러 발생
  >>> a.index('e')
  Traceback (most recent call last):
    File "<pyshell#424>", line 1, in <module>
      a.index('e')
  ValueError: substring not found
  ```



- join()

  문자열 삽입(리스트, 튜플 입력으로도 사용 가능)

  각 문자열 사이에 삽입한다.

  ```python
  >>> ",".join(a)
  'h,o,b,b,y'
  >>> ",".join('abcd')
  'a,b,c,d'
  
  # 리스트의 경우에 ,로 합친 문자열이 됨
  >>> ",".join(['a','b','c','d'])
  'a,b,c,d'
  ```



- upper()

  소문자->대문자

  ```python
  >>> a = "hi"
  >>> a.upper()
  'HI'
  ```

- lower()

  대문자->소문자

  ```python
  >>> a = "HI"
  >>> a.lower()
  'hi'
  ```



- lstrip()

  왼쪽 공백 지우기

  ```python
  >>> a = " hi "
  >>> a.lstrip()
  'hi '
  ```

- rstrip()

  오른쪽 공백 지우기

  ```python
  >>> a= " hi "
  >>> a.rstrip()
  ' hi'
  ```

- strip()

  ```python
  >>> a = " hi "
  >>> a.strip()
  'hi'
  ```



- replace

  문자열 바꾸기

  ```python
  >>> a="Life is too short"
  >>> a.replace("Life","Your leg")
  'Your leg is too short'
  
  #인덱스로 바꾸는건 안돼
  >>> a[0]="i"
  Traceback (most recent call last):
    File "<pyshell#438>", line 1, in <module>
      a[0]="i"
  TypeError: 'str' object does not support item assignment
  ```

  

- Docstring

  코드의 __`문서화`__를 위해서 사용. 모듈, 함수, 클래스 또는 메소드 정의의 첫 번째 명령문으로 발생하는 문자열 리터럴이다. 여러줄의 주석처럼 사용도 가능

  

__`print(' ', end=' ')`__ : end를 이용해 마지막 출력값을 지정할 수 있음(default  : \n)

```python
>>> print('hello')
hello
>>> print('hello',end='.')
hello.
```







---

함수 > 메소드

split()은 함수이다.

split()은 string의 메소드이다.