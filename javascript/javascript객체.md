# 객체

#### 배열 선언 []

```html
<script>
	var array = ['사과', '바나나', '망고', '딸기'];    
</script>
```

#### 객체 선언 {}

```html
<script>
    var product = {
        제품명: '7D 건조 망고',
        유형: '당절임',
        성분: '망고, 설탕, 메타중아황산나트륨, 치자황색소',
        원산지: '필리핀'
    };
</script>
```

객체안의 **[key]:[value]**형태를 **연관배열**이라고 부른다. (java나 c++의 경우 map)



#### 객체의 사용

- product['제품명']	:arrow_right:  '7D 건조 망고'
- product.제품명       :arrow_right:  '7D 건조 망고'



#### this

javascript에서는 같은 객체 내부에서 속성에 접근할때, 'this'를 생략할 수 없다. (C++에서 클래스내에서 설정한 변수 클래스내에 있는 함수에서 접근할때 this없이 접근 가능) 

```html
<script>
    var person = {
        name: '윤인성',
        eat: function(food){
            alert(this.name+ '이(가)' + food + '을(를) 먹습니다.');
        }
    };
    
    person.eat('밥');
</script>
```

#### 객체 속성 동적으로 추가

```html
<script>
    let student = {};

    student.name = '학생1';
    student.kor = 100;
    student.mat = 90;
    student.eng = 80;

   // let sum = student.kor+student.mat+student.eng;       //총점
   // let avg = sum/3;       //평균

    let sum = 0;
    let avg = 0;
    with(student){
    sum = kor+mat+eng;
    avg = sum/3;
    }
    console.log('총점은: ' + sum +', 평균은: '+ avg);
</script>
```

주석처리한 부분과 with(){} 내용은 같다. with는 인자로 '객체'를 받는다. with키워드로 객체의 속성을 사용하기 쉽게 만들 수 있다.



```html
<script>
	let student = [];
	student.push({이름: 'AAA', 국어: 42, 수학: 94, 영어: 100});
	student.push({이름: 'BBB', 국어: 99, 수학: 84, 영어: 73});
	student.push({이름: 'CCC', 국어: 34, 수학: 42, 영어: 63});
	student.push({이름: 'DDD', 국어: 95, 수학: 100, 영어: 61});
	student.push({이름: 'EEE', 국어: 85, 수학: 62, 영어: 80});
	
    let sum=0;
    let avg=0;
    for(let i in student){
        console.log(student[i].이름);
        //학생별 총점/평균, 전체 평균
        student[i].sum = student[i].국어+student[i].수학+student[i].영어;
        student[i].avg = student[i].sum/3;
    }

    for(let i in student){
    //console.log("학생"+ i +"의 총점: " + student[i].sum + ", 평균값: " + student[i].avg);
    with(student[i]){
       console.log("학생"+ i +"의 총점: " + sum + ", 평균값: " + avg)
       }
    }       
</script>
```

학생별 총점/평균을 변수가아닌 함수로 표현할 수도 있다.

```js
for(let i in student){
  console.log(student[i].이름);

  student[i].sum=function(){
  return this.국어+this.수학+this.영어;
  };
  student[i].avg=function(){
  return student[i].sum()/3;
  }
}

for(let i in student){
	with(student[i]){
    console.log("학생"+ i +"의 총점: " + sum() + ", 평균값: " + avg())
    }
}
```