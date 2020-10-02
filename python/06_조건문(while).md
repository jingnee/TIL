# 조건문(while)

### while 조건:

### 		실행할 명령



```python
>>> count = 0
>>> while count<3:
	print('횟수:',count)
	count+=1

	
횟수: 0
횟수: 1
횟수: 2
```



#### continue, break

```python
count = 0

while count < 10:
    count+=1
    if count < 4:
        continue
    print('횟수:', count)
    if count == 8:
        break
    
    
횟수: 4
횟수: 5
횟수: 6
횟수: 7
횟수: 8
```

count가 10보다 작을때까지 반복하는데, 4미만인경우 continue를 만나서 아래를 실행하지않고 다음 반복문을 돈다. 그리고 8을 만나면 탈출하기 때문에 4부터 8까지만 출력된다.



