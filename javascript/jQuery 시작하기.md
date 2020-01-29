# jQuery 시작하기

jquery는 다운받아서 사용하거나, 인터넷을 통해 사용하는 방법이 있다.

jquery-min : 사실상 2줄로 이루어져 있는데, 네트워크를 통해서 전달될때 최대한 사이즈를 줄여서 보내게 하기 위해서다. 내용 알아보기 힘듦

jquery : 개발용도

### 방법1) <script src="../jquery/jquery.js"></script>

: 로컬에서 파일 가져오는 방법 (jquery/jquery.js 안에 내용 넣어놔야함)

### 방법2) <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

: CDN방법. 네트워크를 통해 가져옴. 더빨라

```html
<!DOCTYPE html>
<html>
    <head>
        <!--<script src="../jquery/jquery.js"></script>     로컬에서 파일 가져오는 방법. 방법1-->          
        <!--아래는 CDN방법. 더빠름 방법2-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            //$(document).ready(function(){
                //alert("JQuery start");
                // let h1 = document.getElementById("myH1");            //기존방법
                // h1.style.color="red";
                //$("#myH1").css('color', 'red');                         //jQuery방법

            //     let btnRed = document.getElementById("btnRed");      //기존방법
            //     btnRed.onclick=function(){

            //     }
            // });
            $(document).ready(function(){
                $("#btnRed").on('click',function(){                     //아래와 같지만 가능하면 이방법으로 사용
                    $("#myH1").css('color', 'red');
                })
                $("#btnBlue").on('click',function(){
                    $("#myH1").css('color', 'blue');
                })
            })
               
        </script>
    </head>
    <body>
        <h1 id="myH1"> Hello, jQuery </h1>
        <button id="btnRed" >RED</button>
        <button id="btnBlue" >BLUE</button>
    </body>
</html>
```

