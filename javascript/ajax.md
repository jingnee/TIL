# ajax

: jQuery에서 비동기 통신을 하기위해서 사용

사용하기위해서 두가지 방법이 있다.

1)

```js
$.ajax({
url:'./data.html',
success:function(data){},
error:function(){}
});
```

2)

```js
$.ajax('./data.html',{
success:function(data){},
error:function(){}
});
```



`https://api.openweathermap.org/data/2.5/forecast?q=Seoul&APPID=[api key]&units=metric`



ajax1.html

: 로컬에 저장되어있는 'forecast.json'를 이용해서 사용 -> 일반크롬은 불가능하다.

ajax 이용해서 로컬에있는 json파일 받아올때 크롬에서 보안 오류가 뜬다.

새로운 크롬 복붙해서 속성>>대상에

 `chrome.exe" --disable-web-security --user-data-dir=C:\Users\HPE\Work\javascript` 

을 붙여준다.

```html
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(document).ready(function(){
                //방법 두가지
                $.ajax({
                    url:'./forecast.json',
                    success:function(data){
                    let parsed=JSON.parse(data);

                    $.each(parsed.list,function(index,item){
                let _image=document.createElement('img');
                _image.src="http://openweathermap.org/img/wn/"+item.weather[0].icon+"@2x.png";
                let _divhtml = item.dt_txt;
                _divhtml += ',기온:' + item.main.temp;
                _divhtml += '<span style="color:blue;">'+ item.main.temp_min + '</span>';
                _divhtml += '/</span stype="color:red;">' + item.main.temp_max; + '</span>';
                _divhtml += ', '+ item.weather[0].description;

                let imageSpan = document.createElement("span");
                imageSpan.appendChild(_image);
                let infoSpan = document.createElement("span");
                infoSpan.innerHTML = _divhtml;

                let div = document.createElement("div");
                div.appendChild(imageSpan);
                div.appendChild(infoSpan);

                $('#contents').append(div);
                
                })
                    // console.log(parsed.city.name);
                    // console.log(parsed.city.country);
                    // console.log("SUCCESS");
                    // console.log(data);
                    }
                    // error:function(err){
                    // console.log("ERROR");
                    // console.log("err");
                    //}
                });

                // $.ajax('./data.html',{
                //     success:function(data){},
                //     error:function(){}
                // });
            });
        </script>

    </head>
    <body>
        <div id='contents'></div>
    </body>
</html>
```



ajax2.html

: 인터넷 url으로 실시간 데이터를 받아옴

local에 있는 json을 크롬에 올리는것이 아니라서 일반 크롬 사용가능

```html
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(document).ready(function(){
                //방법 두가지
                $.ajax({
                    url:'https://api.openweathermap.org/data/2.5/forecast',
                    method : 'GET',
                    data: {
                        q :'seoul',
                        appid : 'a1e94706c17587fbc21a8119288d2fb2',
                        units : 'metric'
                    },
                    success: function(data){
                        //console.log(data);
                        console.log("SUCCESS");
                $.each(data.list,function(index,item){
                let _image=document.createElement('img');
                _image.src="http://openweathermap.org/img/wn/"+item.weather[0].icon+"@2x.png";
                let _divhtml = item.dt_txt;
                _divhtml += ',기온:' + item.main.temp;
                _divhtml += '<span style="color:blue;">'+ item.main.temp_min + '</span>';
                _divhtml += '/</span stype="color:red;">' + item.main.temp_max; + '</span>';
                _divhtml += ', '+ item.weather[0].description;

                let imageSpan = document.createElement("span");
                imageSpan.appendChild(_image);
                let infoSpan = document.createElement("span");
                infoSpan.innerHTML = _divhtml;

                let div = document.createElement("div");
                div.appendChild(imageSpan);
                div.appendChild(infoSpan);

                $('#contents').append(div);
                
                })
                    },
                    error: function(err){
                        console.log('ERROR'+err);     
                    }
                });
            });
        </script>

    </head>
    <body>
        <div id='contents'></div>
    </body>
</html>
```



forecast.html

: json내용을 복사해서 forecast 변수에 넣어준다. 그 변수로 json 파일 사용

```html
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            let forecast = `
            [웹사이트에서 받은 json 내용을 복사해서 넣어줌]
            `;
        
        $(document).ready(function(){
            //1. PARSING -> string -> object
            let parsedForecast = JSON.parse(forecast);
            //console.log(parsedForecast.list.length);

            $.each(parsedForecast.list,function(index,item){
                //console.log(item.dt_txt+'='+item.main.temp+','+item.weather[0].icon);

                           
            //2. 필요한 날씨 데이터 추출(list or main....)
            //3. each()함수로 날씨 데이터 생성(format -> weather.html 참고)
                let _image=document.createElement('img');
                _image.src="http://openweathermap.org/img/wn/"+item.weather[0].icon+"@2x.png";
                let _divhtml = item.dt_txt;
                _divhtml += ',기온:' + item.main.temp;
                _divhtml += '<span style="color:blue;">'+ item.main.temp_min + '</span>';
                _divhtml += '/</span stype="color:red;">' + item.main.temp_max; + '</span>';
                _divhtml += ', '+ item.weather[0].description;

                let imageSpan = document.createElement("span");
                imageSpan.appendChild(_image);
                let infoSpan = document.createElement("span");
                infoSpan.innerHTML = _divhtml;

                let div = document.createElement("div");
                div.appendChild(imageSpan);
                div.appendChild(infoSpan);

                $('#contents').append(div);
                
            })

 
        });
        </script>

    </head>
    <body>
        <!-- 시간, 기온, 날씨, 아이콘, 이미지, 풍속 ... -->
        <div id='contents'>

        </div>
    </body>
</html>
```

