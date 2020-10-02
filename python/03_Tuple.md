# Tuple

### (val1, val2, ...) or va1, va2, ...

immutable (값을 변경할 수 없어. list와 가장 큰 차이)



- 변수 생성

```python
>>> my_tuple=()
>>> type(tuple)
<class 'tuple'>

>>> tuple1 = (1,2,3)
>>> tuple2 = 1,2,3
>>> tuple2
(1, 2, 3)

>>> type(tuple1)
<class 'tuple'>
>>> type(tuple2)
<class 'tuple'>
```



- __`Packing`__ : 여러개의 값을 한번에 묶음 , __`Unpacking`__ : 묶여있는 값을 품

![image](https://user-images.githubusercontent.com/30755941/94576642-87285880-02b0-11eb-9a86-a701e4752f9f.png)

첫번째 줄은 1,2,3을 my_tuple이라는 튜플 변수로 묶는것이기 때문에 __`Packing`__ 

두번째는 my_tuple에 들어있는 값들을 각각의 변수로 나눠주는 것이기 때문에 __`Unpacking`__

또 파이썬은 이런게 된다..

```python
>>> num1,num2 = num2, num1
>>> num1
2
>>> num2
1
```

num1과 num2의 값을 바꿔주고 싶을때 이렇게 쓰면 바뀜.. 놀라운 파이썬 문법

우측의 num2 와 num1을 패킹한 후 다시 num1과 num2에 언패킹 한것이다.



튜플은 값을 변경하거나 삭제할 수 없기 때문에 __`del`__함수나 인덱스를 통한 변경은 에러가 난다.

```python
>>> my_tuple[0]=111
Traceback (most recent call last):
  File "<pyshell#236>", line 1, in <module>
    my_tuple[0]=111
TypeError: 'tuple' object does not support item assignment
    
>>> del my_tuple[0]
Traceback (most recent call last):
  File "<pyshell#237>", line 1, in <module>
    del my_tuple[0]
TypeError: 'tuple' object doesn't support item deletion
```



그외 인덱싱, 슬라이싱([:]), 더하기(+), 곱하기(*), 길이(len) .. 등의 함수 모두 사용 가능

sort도 안돼 (정렬해서 튜플을 바꾸는 것이기 때문에)