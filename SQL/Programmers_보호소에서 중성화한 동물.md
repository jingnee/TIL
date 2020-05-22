# Programmers 보호소에서 중성화한 동물

[문제링크](https://programmers.co.kr/learn/courses/30/lessons/59045)



먼저 문제를 읽고!

정리하자면, 보호소에 들어왔을때 중성화를 하지 않았던 (`Intact`가 포함되어 있는) 동물이 입양갔을때 중성화를 한(`Spayed`나 `Neutered`가 포함되어있는) 동물의 `ID`, `TYPE`, `NAME`을 찾는 쿼리문을 작성하는 문제이다.



```sql
SELECT ANIMAL_INS.ANIMAL_ID, ANIMAL_INS.ANIMAL_TYPE, ANIMAL_INS.NAME
FROM ANIMAL_INS
JOIN ANIMAL_OUTS
ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
AND (SUBSTRING_INDEX(ANIMAL_OUTS.SEX_UPON_OUTCOME,' ',1) = 'Spayed' || SUBSTRING_INDEX(ANIMAL_OUTS.SEX_UPON_OUTCOME,' ',1) = 'Neutered')
WHERE SUBSTRING_INDEX(ANIMAL_INS.SEX_UPON_INTAKE,' ',1) = 'Intact'
```

1: 먼저 알아야 할 내용은 ID, TYPE, NAME으로 SELECT로 선택해주고

2: ANIMAL_INS 테이블과

3: ANIMAL_OUTS 테이블을 조인시켜준다.

4: 조건으로 일단 두 아이디가 같아야 비교할 수 있으므로 아이디가 같아야 하고

5: SUBSTRING을 이용하여 ANIMAL_OUTS 테이블에 있는 동물들이 중성화를 거친, 입양한 동물들 중에서 Spayed나 Neutered가 포함된 동물들을 찾는다.

6: 어디서? 보호소에 들어왔을때 중성화를 거치지않은 (Intact)동물들 중에서!



문제를 풀면서 sql 문자열에 대해서 처음 알았다.

#### mysql 문자열 자르기

##### 1. 왼쪽에서 문자열 자르기

ex) __*SELECT left ("This is MYSQL", 6)*__ 

```sql
This i
```

left의 첫번째 인자는 `문자열`, 두번째 인자는 왼쪽에서 부터 `잘라낼 문자열의 길이`를 의미한다.

##### 2. 중간에서 문자열 자르기

ex) __*SELECT substring("This is MYSQL",6,6)*__

```
is MYS
```

substring의 첫번째 인자는 `문자열`, 두번째 인자는 `시작 위치`(1부터 시작), 마지막 인자는 `잘라낼 문자열의 길이`를 의미한다.

##### 3. 오른쪽에서 문자열 자르기

ex) __*SELECT right("This is MYSQL",8)*__

```
is MYSQL
```

right의 첫번째 인자는 `문자열`, 두번째 인자는 오른쪽에서 부터 `잘라낼 문자열의 길이`를 의미한다.

##### 4. 구분자(delimiter)가 count만큼 나오기 전까지의 문자열을 반환

ex) __*SELECT SUBSTRING_INDEX("This is MYSQL",' ',2)*__

```
This is
```

첫번째 인자는 문자열, 두번째 인자로 구분자로 받고, 마지막 인자가 구분자의 갯수이다.

즉 ' '(공백)이 두개 나올때 왼쪽의 문자열을 반환한다.

ex) __*SELECT SUBSTRING_INDEX("This is MYSQL",' ',-2)*__

```
is MYSQL
```

마지막 인자가 음수인 경우 오른쪽에서부터 센다. 즉 오른쪽에서부터 공백이 두개 나왔을때 오른쪽 문자열을 반환



그래서 위에서 썼던

```sql
SUBSTRING_INDEX(ANIMAL_OUTS.SEX_UPON_OUTCOME,' ',1) = 'Spayed'
```

을 다시보면 ANIMAL_OUTS.SEX_UPON_OUTCOME의 값 예를들어 __`Spayed Female`__ 의 데이터가 들어있다고 하면, 공백이 하나 나올때 왼쪽 문자열을 반환하므로 `Spayed`를 반환하게 된다.

문자열이 __`Intact Female`__ 인경우 첫번째 공백으로부터 왼쪽에 있는 문자열은 `Intact`이므로 위의 조건에는 성립하지않아 선택되지 않는다.