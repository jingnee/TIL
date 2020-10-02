# Dictionary

### {key1: val1, ...}

키와 값을 쌍으로 가짐

![image](https://user-images.githubusercontent.com/30755941/94915162-57af6100-04e7-11eb-8b5d-937d0beca09a.png)

```python
>>> my_dict={}
>>> my_dict[0]='a'
>>> my_dict
{0: 'a'}

>>> my_dict['b']=2
>>> my_dict
{0: 'a', 'b': 2}

#출력은 key값이 나옴
>>> for i in my_dict:
	print(i)

	
0
b

#del 연산자 사용 가능
>>> del my_dict[0]
>>> my_dict
{'b': 2}
```



### dict.values()

값을 뽑아옴

```python
>>> for lan in my_dict.values():
	print(lan)

	
python
cpp
java
```



### dict.keys()

키를 뽑아옴

```python
>>> for lan in my_dict.keys():
	print(lan)

	
lan1
lan2
lan3

#key를 뽑아서 dict_keys 객체를 돌려줌
>>> my_dict.keys()
dict_keys(['lan1', 'lan2', 'lan4'])
```



### dict.items()

키와 밸류 둘다 가져옴

```python
>>> for key,val in my_dict.items():
	print(key,val)

	
lan1 python
lan2 cpp
lan3 java
>>> for lan in my_dict.items():
	print(lan)

	
('lan1', 'python')
('lan2', 'cpp')
('lan3', 'java')

#item들을 뽑아서 dict_items 객체를 돌려줌
>>> my_dict.items()
dict_items([('lan1', 'python'), ('lan2', 'cpp'), ('lan4', 'javascript')])
```



- 딕셔너리 쌍 추가

  ```python
  >>> my_dict['lan4']='javascript'
  >>> my_dict
  {'lan1': 'python', 'lan2': 'cpp', 'lan3': 'java', 'lan4': 'javascript'}
  ```

- 딕셔너리 요소 삭제

  ```python
  >>> del my_dict["lan3"]
  >>> my_dict
  {'lan1': 'python', 'lan2': 'cpp', 'lan4': 'javascript'}
  ```

- get

  ```python
  >>> my_dict.get('lan1')
  'python'
  # 인덱스로 접근할경우 없는 키면 오류가 뜨지만, get의 경우 오류안뜸
  >>> my_dict.get('lan3')
  >>> print(my_dict.get('lan3'))
  None
  
  # 해당하는 키가 없을경우 미리 정해둔 디폴트값을 출력하게 하고싶으면 인자 두개사용(당연히 키 있는경우 그 키에 해당하는 값이 출력)
  >>> my_dict.get('lan3','go')
  'go'
  ```

- in

  ```python
  # 해당하는 'key'가 딕셔너리 안에 있는지 조사
  >>> 'python' in my_dict
  False
  >>> 'lan1' in my_dict
  True
  ```

  

- 주의사항 

  - 중복된 key를 사용할 수 없다.

  - key는 리스트가 될 수 없다. (but, 튜플은 가능. 왜? immutable하니까)

    ```python
    >>> a={[1,2]:'hi'}
    Traceback (most recent call last):
      File "<pyshell#281>", line 1, in <module>
        a={[1,2]:'hi'}
    TypeError: unhashable type: 'list'
    >>> a={(1,2):'hi'}
    >>> a
    {(1, 2): 'hi'}
    ```

  - 