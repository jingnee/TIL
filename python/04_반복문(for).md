# 반복문(for)

### for 변수 in 컨테이너:

### 		실행할 명령1



반복되는 내용들의 앞 공백은 같아야해 (띄어쓰기 4칸 권장)

```python
>>> list=[1,2,3]
>>> for l in list:
    print(l)
    
1
2
3

>>> for str in "python":
    print(str)
    
p
y
t
h
o
n
```



### range([start],stop,[step])

최소 한개의 매개변수를 가지고 start부터 stop까지 step만큼의 범위로 반복

![image](https://user-images.githubusercontent.com/30755941/94899201-d4cddc80-04cd-11eb-957b-be1149082758.png)

ex) range(5) : 0부터 4까지(5 미만)

ex) range(1,5) : 1부터 4까지

ex) range(1,10,3) : 1,4,7 의미

```python
>>> for n in [0,1,2]:
	print(n)

	
0
1
2

>>> for n in range(0,3):
	print(n)

	
0
1
2

# 5개의 요소를 가지는 list가 있을때 list를 모두 순회하고 싶으면 
>>> for i in list:
    print(i)
>>> for i in range(len(list)):
    print(list[i])
```

두개는 같은 표현

- 구구단 만들기 (중첩 for문)

  ```python
  for i in range(1,10):
      for j in range(1,10):
          print('{}x{}={}'.format(i,j,i*j))
  ```

  

### Comprehension

#### [표현식 for 항목 in 반복가능객체 if 조건문]

중첩for문도 사용 가능

iterble한 오브젝트를 생성하기 위한 방법중 하나. 크게 네 가지 종류의 comprehension이 있다.

		- List Comprehension
		- Set Comprehension
		- Dict Comprehension
		- Generator Expression

문제 1) 1부터 10을 가지는 list에서 홀수만 가지는 배열을 만들어 보자

```
# for 문으로 만들기
>>> odd_numbers = []
>>> for num in numbers:
	if num%2:
		odd_numbers.append(num)
		
>>> odd_numbers
[1, 3, 5, 7, 9]

# List Comprehension
>>> [num for num in numbers if num%2==1]
[1, 3, 5, 7, 9]
```

문제 2) 구구단을 list comprehension으로 표현해보자

```python
>>> [i*j for i in range(1,10)
	 for j in range(1,10)]
[1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 4, 6, 8, 10, 12, 14, 16, 18, 3, 6, 9, 12, 15, 18, 21, 24, 27, 4, 8, 12, 16, 20, 24, 28, 32, 36, 5, 10, 15, 20, 25, 30, 35, 40, 45, 6, 12, 18, 24, 30, 36, 42, 48, 54, 7, 14, 21, 28, 35, 42, 49, 56, 63, 8, 16, 24, 32, 40, 48, 56, 64, 72, 9, 18, 27, 36, 45, 54, 63, 72, 81]
```



### enumerate 함수

iterable(순서를 셀 수 있는)한 객체와 시작값(default = 0, 생략가능)두개의 매개변수를 가지고 `enumerate`객체를 반환한다.

enumerate는 인덱스와 값을 포함

:grey_exclamation: (0, seq[0]), (1,seq[1]), (2,seq[2])...

![image](https://user-images.githubusercontent.com/30755941/94942074-bf2dd680-0510-11eb-92f5-dffb4b302cf7.png)



다음과 같이 사용할 수 있다.

```python
# i가 시작위치가 되고, i는 0부터 시작하고, name은 names의 첫번째 요소부터 순차적으로 가리키게 된다.
>>> names=["철수","영희","영수"]
>>> for i, name in enumerate(names):
	print('{}번: {}'.format(i+1,name))

	
1번: 철수
2번: 영희
3번: 영수
    
>>> for i,name in enumerate(names):
	print(i,name)

	
0 철수
1 영희
2 영수

# start값으로 3을 넣었는데 세 요소가 모두 출력된걸 보면 name은 names[i]가 아니라 그냥 순서대로의 값이 들어가고 i와는 별개인것 같다.
>>> for i,name in enumerate(names,3):
	print(i,name)

	
3 철수
4 영희
5 영수
```

