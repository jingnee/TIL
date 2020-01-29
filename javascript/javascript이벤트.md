# 이벤트

window 객체의 onload 속성에 함수 자료형을 할당하는것을 '이벤트를 연결한다'고 한다.

이벤트 이름, 이벤트 속성, 이벤트 리스너 찾아보기

```html
<!DOCTYPE html>
<html>
    <head>
        <script>
            window.onload = function(){
                let clock = document.getElementById('clock');
                setInterval(function(){
                    clock.innerText = new Date().toString();            //innerText나 innerHTML둘다 상관없음
                },1000);

                clock.onclick = function(){
                    //alert('test');
                    clock.style = "color: blue;";
                    clock.style.backgroundColor = "red";
                };
            }
        </script>
    </head>
    <body>
        <h1 id='clock'></h1>
    </body>
</html>
```

1초단위로 시간가져와서 뿌려주기

```html
<!DOCTYPE html>
<html>
    <head>
        <script>
            window.onload = () => {
                let counter = document.getElementById("counter");
                let count=0;
                let plusBtn = document.getElementById("plus");
                plusBtn.onclick = function(){

                    counter.innerText=++count;
                }

                let minusBtn = document.getElementById("minus");
                minusBtn.onclick = function(){
                    counter.innerText=--count;
                }
            }
        </script>

    </head>
    <body>
        <h1 id="counter">0</h1>
        <button id="plus" onclick="plusCounter()">+</button>
        <button id="minus">-</button>
    </body>
</html>
```

숫자 up,down



