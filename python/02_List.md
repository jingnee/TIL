# List

### [val1, val2, ...]

mutable(값을 변경할 수 있다. :exclamation:앞에서 배운 string은 immutable,즉 값을 바꿀 수 없다. )



- 변수 생성

```
>>> my_list=[]
>>> my_list
[]

>>> type(my_list)
<class 'list'>

>>> my_list=[1,2,3]
>>> my_list
[1, 2, 3]
```



- 값 추가하기

  ### append()

  ```pyth
  #모두 같은 타입을 가질 필요 없어(c/c++ 등의 array랑 차이)
  >>> my_list.append('hihi')
  >>> my_list
  [1, 2, 3, 'hihi']
  
  #존재하지 않은 리스트에대해서는 추가할 수 없어
  >>> new_list.append('list')
  Traceback (most recent call last):
    File "<pyshell#118>", line 1, in <module>
      new_list.append('list')
  NameError: name 'new_list' is not defined
  ```

  

  +  중첩 리스트

    주어진 리스트에서 'life'뽑아내기

  ```python
  >>> a=[1,2,['a','b',['life','is']]]
  
  >>> a[2]
  ['a', 'b', ['life', 'is']]
  >>> a[2][2]
  ['life', 'is']
  
  >>> a[2][2][0]
  'life'
  ```

  ​		주어진 리스트에서 ['a','b'] 뽑아내기

  ```python
  >>> b=[1,2,3,['a','b','c'],4,5]
  >>> b[3]
  ['a', 'b', 'c']
  
  >>> b[3][0:2]
  ['a', 'b']
  >>> b[3][:2]
  ['a', 'b']
  ```



- 리스트 연산하기

  ```python
  >>> a+b
  [1, 2, ['a', 'b', ['life', 'is']], 1, 2, 3, ['a', 'b', 'c'], 4, 5]
  ```

- 리스트 반복하기

  ```python
  >>> c=[1,2,3]
  # c리스트가 변경되지 않아
  >>> c*3
  [1, 2, 3, 1, 2, 3, 1, 2, 3]
  ```

- 리스트 길이 구하기

  ```
  >>> len(c)
  3
  >>> len(a+b)
  9
  ```

- 리스트 값 수정 및 삭제

  ```python
  >>> d=a+b
  >>> d
  [1, 2, ['a', 'b', ['life', 'is']], 1, 2, 3, ['a', 'b', 'c'], 4, 5]
  >>> d[1]=3
  >>> d
  [1, 3, ['a', 'b', ['life', 'is']], 1, 2, 3, ['a', 'b', 'c'], 4, 5]
  >>> del d[2]
  >>> d
  [1, 3, 1, 2, 3, ['a', 'b', 'c'], 4, 5]
  ```

  삭제함수는 __`del`__ 이다. 위에 빨간색으로 쓴 글씨가 인덱스이고 d[2]의 경우 ['a','b',['life','is']]를 의미한다. 따라서 그부분 뺀 나머지가 출력 됨

  ![image](https://user-images.githubusercontent.com/30755941/94571143-9d331a80-02aa-11eb-8e98-fe980b3c3644.png)



그외 list 메소드들...

:apple: __`sort`__ : 리스트 정렬 (요소가 모두 같은 타입일 경우만 가능, 아닌경우 < overriding)

:apple: __`reverse`__ : 리스트 뒤집기

:apple: __`index`__ : 위치 반환 (해당하는 값의 가장 첫번째 인덱스 반환)

```python
>>> d
[1, 3, 1, 2, 3, ['a', 'b', 'c'], 4, 5]
>>> d.index(1)
0
>>> d.index(['a','b','c'])
5
```

:apple: __`insert`__ : 리스트에 요소 삽입 (두개의 매개변수로 위치와 값을 받음)

```python
>>> e=[1,2,3]
>>> e.insert(0,-1)
>>> e
[-1, 1, 2, 3]
#위치로 마지막 인덱스보다 큰 값을 넣으면 오류발생하지 않고 제일 뒤에 추가
>>> e.insert(10,4)
[-1, 1, 2, 3, 4]
# 반대도 마찬가지
>>> e.insert(-10,-2)
[-2, -1, 1, 2, 3, 4]
```

:apple: __`pop`__ : 리스트 마지막 요소 돌려주고 그 요소는 삭제

```python
>>> e
[-1, 1, 2, 3]
>>> e.pop()
3
>>> e
[-1, 1, 2]
```

:apple: __`count`__ : 리스트에 포함된 요소 개수 세기

```python
>>> d
[1, 3, 1, 2, 3, ['a', 'b', 'c'], 4, 5]
>>> d.count(1)
2
>>> d.count(0)
0
>>> d.count(4)
1
```

:apple: __`extend`__ : 리스트 확장 (매개변수로 리스트를 넣어줌. 더하기 연산으로 추가 가능)

```python
>>> e
[-2, -1, 1, 2, 3, 4]

>>> e.extend([5,6])
>>> e
[-2, -1, 1, 2, 3, 4, 5, 6]
>>> f=["12","13"]
>>> e.extend(f)
>>> e
[-2, -1, 1, 2, 3, 4, 5, 6, '12', '13']
>>> e += ["리스트","추가"]
>>> e
[-2, -1, 1, 2, 3, 4, 5, 6, '12', '13', '리스트', '추가']
```



