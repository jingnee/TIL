# 클래스

인스턴스 vs 객체

```
인스턴스는 클래스와 객체 사이의 관계를 얘기할때 쓰인다. 예를들어 Cookie라는 클래스가 있다고 하자. a = Cookie() 라는 코드에서 a는 '객체'이고, a는 'Cookie의 인스턴스' 이다.
```



### 사칙연산을 하는 클래스 'FoulCal()' 만들어보기

1. 두개의 숫자를 매개변수로 받는 `setData(int,int)` 만들기

   ```python
   class FourCal:
       def setData(self,first,second):
           self.first = first
           self.second = second
   ```

   class의 메서드는 필요한 매개변수 + 1 개의 매개변수를 받는다.

   제일 첫번째 매개변수 self는 객체 자기 자신을 가리킨다. (그래서 self라고 많이 씀)

   ```python
   a = FourCal()
   a.setData(4,2)
   ```

   마지막 문장에서 a가 `self`가 되고, 4가 `first`, 2가 `second`가 된다.

   이렇게 쓰면 파이썬에서는 C++에서 처럼 first, second 변수를 따로 생성하지 않아도 a객체는 first와 second 변수를 가지는 것이다.

   ```python
   >>> a.setData(4,2)
   >>> a.first
   4
   >>> a.second
   2
   
   #다음처럼도 사용 가능 -> 함수이름.메서드(객체,인자,..)
   >>> a = FourCal()
   >>> FourCal.setData(a,4,2)
   
   #이건 안돼!
   >>> a = FourCal()
   >>> a.setData(a,4,2)
   ```

   

   :dizzy_face: 만약 C++이었으면 다음과 같이 썼을거다!

   ```c++
   class FourCal{
       public:
       //FourCal클래스가 가지는 변수는 정의해야 사용가능
       int first, second;
       void setData(int first, int second){
           this->first = first;
           this->second = second;
       }
   }
   
   FouCal a;
   a.setData(4,2)
   ```

   setData의 첫번째 매개변수로 컴파일러가 묵시적으로 `FourCal* this`를 삽입하는데, python의 self가 이런 느낌 인 것 같다.



:slightly_smiling_face: 객체는 서로 독립적이다

```python
>>> a=FourCal()
>>> b=FourCal()

#id는 객체의 주소를 반환. a객체와 b객체의 주소값이 다른것으로 보아 서로 독립적임을 알 수 있다.
>>> id(a)
2497464866656
>>> id(b)
2497464867040
```



2. 더하기 기능을 가진 `add()` 함수 만들기

   ```shell
   def add(self):
           result = self.first+self.second
           return result
   ```

   아까 a, 즉 class 객체 자기자신(self)은 first와 second를 가진다고 했다. add함수는 setData(int,int)를 통해서 받은 두개의 변수를 더한 값을 반환한다. 그 두 변수는 객체 자기자신(self)에 저장되어 있다.

   __self 는 생략하면 안됨!! __ 

   생략할경우

   ![image](https://user-images.githubusercontent.com/30755941/97882965-998e2a00-1d67-11eb-80b0-a23ea3f10d97.png)

   이런 오류가 뜬다. add()는 0개의 매개변수를 가진다고 했는데 하나의 인자와 함께 호출되서 오류가 난다는것이다. 나는 add()를 호출했는데?

   컴파일러가 add()의 첫번째 매개변수로 항상! 객체자신을 넣기 때문이다.

3. 곱하기, 빼기, 나누기 함수 만들기 

   FourCal 전체 클래스

   ``` python
   class FourCal:
       def setData(self, first, second):
           self.first = first
           self.second = second
       def add(self):
           result = self.first+self.second
           return result
       def sub(self):
           result = self.first-self.second
           return result
       def mul(self):
           result = self.first*self.second
           return result
       def div(self):
           result = self.first/self.second
           return result
   ```

   클래스 사용

   ```python
   >>> a = FourCal()
   >>> a.setData(5,6)
   >>> a.add()
   11
   >>> a.mul()
   30
   >>> a.sub()
   -1
   >>> a.div()
   0.8333333333333334
   ```

   

   #### 생성자(Constructor)

   만약에 setData()를 통해 first와 second를 지정하지 않고도 더하기나 빼기등의 함수를 사용하고싶으면??

   지금 만든 클래스에서 setData() 하지않고 add() 함수를 실행하면 정해진 값이 없기 때문에 오류가 발생할 것이다.

   ![image](https://user-images.githubusercontent.com/30755941/97884392-6056b980-1d69-11eb-91c5-b426905d59a8.png)

   first가 없다고 오류가 났다.

   초깃값을 설정하기 위해 생성자를 만들어 보자!

   생성자의 함수이름은 `__init__` 으로 정해져있다.

   생성자 함수 __생성자도 예외없다. self는 생략할 수 없어!__

   ```python
    def __init__(self, first=3, second=4):
           self.first = first
           self.second = second
   ```

   나는 아예 값을 입력하지 않았을때 초깃값도 가지고 싶어서 3과 4로 할당해주었다. 만약 새로운 first와 second값이 들어온다면 그 값으로 설정될 것이고, 그렇지 않다면 3과 4로 정해진다.

   ```python
   >>> a=FourCal()
   >>> a.add()
   7
   >>> b=FourCal(5,6)
   >>> b.add()
   11
   ```

   

### 상속

파이썬에서 상속은 무지쉽다.. 그냥 새로운 클래스를 만들고 인자로 엄마 클래스 넣으면 됨

```python
>>> class MoreFourCal(FourCal):
    pass

# MoreFourCal 클래스를 호출할때는 FourCal 클래스의 객체를 넣어주지 않아도 됨(나중에 헷갈릴듯)
>>> c = MoreFourCal()
>>> c.add()
7
```

상속된 클래스에서 제곱을 반환하는 pow함수를 만들어보자

```python
class MoreFourCal(FourCal):
    def pow(self):
        result = self.first ** self.second
        return result
    
>>> c=MoreFourCal(4,2)
>>> c.pow()
16
```



### 메소드 오버라이딩

FourCal의 div함수는 0으로 나누려고 할때 오류를 발생시킨다.

![image](https://user-images.githubusercontent.com/30755941/97885883-47e79e80-1d6b-11eb-874d-906629b67f96.png)

FourCal클래스에 있는 div와 같은 이름의 함수를 MoreFourCal에서 재정의하려고한다. 재정의 된 div는 나누는 값이 0일때 0을 반환한다.

```python
class MoreFourCal(FourCal):
    def pow(self):
        result = self.first ** self.second
        return result
    #부모 클래스에 있는 메서드와 동일한 이름의 메소드를 만들었다. 이를 메서드 오버라이딩이라고 한다.
    def div(self):
        if self.second == 0:
            return 0
        else :
            return self.first/self.second

        
>>> d=MoreFourCal(4,0)
>>> d.div()
0
```



### 클래스 변수

```python
>>> class Family:
	lastname = "김"

	
>>> a = Family()
>>> a.lastname
'김'
>>> b=Family()
>>> b.lastname
'김'

# 이전까지 a.lastname, b.lastname, Family.lastname의 주소는 모두 같았는데, a.lastname에 새로운 값을 넣고 a.lastname의 주소만 달라졌다.
>>> a.lastname = "박"
>>> a.lastname
'박'
>>> b.lastname
'김'
>>> Family.lastname = "조"
>>> b.lastname
'조'
>>> a.lastname
'박'

>>> id(a.lastname)
2497465196016
>>> id(b.lastname)
2497465195216
>>> id(Family.lastname)
2497465195216

# lastname의 주소는 모두 같지만 (a가 다른 값을 가리키지 않았으면 주소 그대로야) 각 객체 or 클래스의 주소는 모두 다르다
>>> id(a)
2497465225904
>>> id(b)
2497465171200
>>> id(Family)
2497461028496
```

