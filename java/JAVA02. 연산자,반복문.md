# JAVA 연산자 & 반복문

비교 연산자 : **instanceof**

ex) `a instanceof String` 반환 true:false

변수 a가 String타입인지 알아볼때 사용



간단한 문제 풀기

1) 약수구하기

```java
System.out.print("1. 약수구하기: ");
        int num1 = s.nextInt();

        for(int i=1;i<=num1;i++){
            if(num1==i) System.out.println(i);
            else if(num1%i==0)System.out.print(i+", ");
        }
```



2) 소수구하기

```java
System.out.print("2. 소수 구하기: \n");
            int lineNumber=1;        //개행을 위한 변수
            int count=0;
            for(int i=2;i <=107;i++){
                boolean isNotPrime = false;
                for(int j=2; j < i; j++){
                    if(i%j == 0) {
                        isNotPrime = true;
                        break;
                    }
                }
                if(!isNotPrime){
                    System.out.print(i+"\t");
                    count++;
                }

                if(count==lineNumber){
                    System.out.println();
                    lineNumber++;
                    count=0;
                }
            }
```



3) 피보나치 수열 구하기

```java
System.out.println("3. 피보나치 수열 구하기 (1000넘었을때의 N의 값은?)");
        int a=1;
        int b=1;
        int countNum = 2;
        while(true){
            int c= a+b;
            a=b;
            b=c;
            countNum++;

            //System.out.print(c+",");
            if(c>1000){
                System.out.println("정답은: "+c+","+countNum+"번째 숫자입니다.");
                break;
            }
        }
```



