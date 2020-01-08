# Docker 시작하기

시작하기전에.. 

---

**Docker란 ?** 한마디로 **컨테이너 기반의 오픈소스 가상화 플랫폼 **

기존에는 OS를 가상화하였는데 도커는 컨테이너를 가상화 하는것이다. 운영체제 가상화에 비해 컨테이너형 가상화는 구조적으로 오버헤드가 더 적고, 빠르게 시작 및 종료할 수 있다.

**Container란 ?** 격리된 공간에서 프로세스가 동작하는 기술이다. 

**Image란 ?** 컨테이너 실행에 필요한 파일과 설정값 등을 포함하는것이다.

---



[https://hub.docker.com/](도커허브사이트) 에서 회원가입하고 도커 다운로드

두번정도 재부팅되고 docker가 **running** 되는것을 확인

shared Drive에서 디스크하나 연결해준다. (왠만하면 C드라이브에 연결하는게 좋음)



### 1. docker server 실행하기

  파워쉘을 켜서 입력

```shell
$ docker image pull gihyodocker/echo:latest			//도커 이미지 다운로드
$ docker container run -p 9000:8080 gihyodocker/echo:latest
```

container에서 사용하는 8080 port번호는 윈도우에서 직접 사용할 수 없기 때문에 윈도우의 9000번 포트와 연결해서 사용해준다. **포트포워딩**

가끔 오류날때가 있는데 포트번호를 바꾸면 해결된다.(8080말고 9000번을 다른걸로 할당)



run 명령어는 이름을 지정해서 실행할 수도 있다. ('myweb1'이라는 이름으로 실행)

```shell
$ docker container run --name myweb1 -p 9000:8080 gihyodocker/echo:latest
```

백그라운드에서 기동될 수 있는 데몬으로 실행할 수도 있다.

```shell
$ docker container run -d -p 9000:8080 gihyodocker/echo:latest
```

### 2. 서버 접속하기

웹에서 접속하거나,

![](E:\TIL\docker\pic\docker시작.png)

powershell을 하나 더 띄워서 curl로 접속할 수도 있다.

```shell
$ curl http://localhost:9000/
```

![](E:\TIL\docker\pic\dockercurl.png)

만약에! curl : Internet Explorer 엔진을 사용할 수 없거나 Internet Explorer의 최초 실행 구성이 완전하지 않아 응답 콘텐츠를 구문
분석할 수 없습니다. UseBasicParsing 매개 변수를 지정하고 다시 시도하십시오.

![](E:\TIL\docker\pic\curl오류.png)

이런 오류가 뜬다면 그냥 Internet explorer를 한번 켜보고 다시 시도해보자

그러면 됨!



### 3. 간단한 웹 만들기

간단한 웹페이지를 만들건데 그전에 Node.js와 Visual Code가 깔려있어야 한다!

\C\docker\simpleweb 디렉토리를 만들고

(팁! 깊이있는 폴더를 한번에 만들고 싶을때 -p옵션을 사용해주면 된다.)

`simpleweb` 디렉토리로 이동해서 code . 하면 비쥬얼코드가 열린다.

#### 3.1 Node.js 파일 만들기

거기에 `package.json`과 `index.js`파일을 만들어 준다.

```javascript
{
    "dependencies": {
        "express": "*"
    },
    "scripts": {
        "start": "node index.js"
    }
}
```

```javascript
const express = require('express');
const app = express();

app.get('/', (req, res) => {
    res.send('Hi, there!');
});


app.listen(8080, () => {
    console.log('Listening on port 8080');
});
```

> 모든 HTTP 요청에 대해 'Hi, there!'이라는 응답을 보내고, 포트 8080으로 요청을 받는 서버 애플리케이션으로 동작한다.

저장한 다음 쉘에서 자바스크립트 패키지 매니저인 npm을 설치해주고, 서비스를 구동한다.

![](E:\TIL\docker\pic\npminstall.png)

npm install을 통해 npm을 설치해주고 start 명령어로 서비스를 구동하면 내가 설정했던 8080포트를 받고있다는 콘솔로그가 나온다.

![](E:\TIL\docker\pic\npm화면.png)

웹에서도 접속가능한것을 볼 수 있다.



### 4. Dockerfile 만들기

이제 이걸 도커파일로 만들어 보려고 한다. code . 입력해서 visual code 켜준 다음 `Dockerfile`을 만든다. 파일을 만들기 전에 vscode에서 왼쪽 `Extension`에서 Docker를 다운로드 해준다.

```dockerfile
FROM node:alpine
WORKDIR /home/node
COPY ./package.json ./package.json
COPY ./index.js ./index.js
RUN npm install
CMD ["npm","start"]
```

FROM을 통해서 alpine(엄청작은 리눅스)이라는 베이스 이미지를 hub.docker에서 받아온다.

WORKDIR은 현재 디렉토리를 변경해준다.

COPY는 윈도우에 있는 파일을 리눅스 컨테이너로 넣게 해준다.

RUN으로 npm 설치를 해준 다음

CMD 에 들어가있는 인자값이 커맨드 명령어로 들어가게 한다.



### 5. image 빌드 및 실행

Dockerfile을 통해 이미지를 만들었으니, 이제 빌드하고 실행해보자.

```shell
$ docker build -t jingnee/simpleweb:latest .
$ docker image ls			//설치된 이미지 보기
$ docker run -d -p 8000:8080 jingnee/simpleweb:latest
```

-t 옵션으로 이미지명을 지정한다. :뒤에는 태그명인데, 선택사항(default latest)

나는 push작업도 해볼것이기 때문에 내 계정이름이 들어간 이미지명으로 만들어주었다.(jingnee/simpleweb) 이미지명 없이 빌드할 수도 있지만 이미지 아이디를 해쉬값으로 구분해야 하기 때문에 번거로울 수 있다.

. 은 현재디렉토리에 있는 Dockerfile을 이용해 이미지를 만들겠다는 뜻이다.

run은 실행 명령어인데, 만약 설치되지않았으면 설치를 진행하고 실행한다.

-d 는 demon으로 백그라운드로 실행하게 해준다.

-p 옵션은 9000번이라는 포트로 연결하겠다는 옵션이다. (포트포워딩 하겠다는 뜻이야)

![](E:\TIL\docker\pic\build.png)

build를 하면 내가 dockerfile에 입력했던 명령어들에 각 스텝으로 실행되는것을 볼 수 있다.

이미지를 빌드하고나서 docker image ls 명령어 또는 docker images 명령어를 통해 현재 만들어진 이미지들을 볼 수 있다.

![](E:\TIL\docker\pic\image ls.png)

![](E:\TIL\docker\pic\images.png)

> image ls와 images는 같은 내용을 보여주는것을 볼 수 있다.



![](E:\TIL\docker\pic\dockerun.png)

-d (demon)으로 실행했기 때문에 powershell에서 서버가 동작하고 있는 모습이 보이지않고 바로 프롬프트가 나온다(사진에서는 잘림)

포트포워딩했던 8000번으로 접속가능한것을 볼 수 있다.



**도커파일 왜쓰는거야?** 도커에서 이미지를 생성하기 위해서는 꼭 도커파일을 사용해야 한다. 도커파일은 이미지파일을 만드는 파일이다!



### 6. 이미지 업로드 및 다운로드

hub.docker 사이트에 내가 만든 이미지를 업로드 하거나 나또는 남의 이미지를 원격에서 다운받아 올 수 있다.

```shell
$ docker push jingnee/simpleweb:latest
$ docker pull jingnee/simpleweb:latest
```

![](E:\TIL\docker\pic\dockerhubpush.png)

push 하고 허브사이트에 접속하면 내가 몇초전에 올린 `jingnee/simpleweb` image가 등록된것을 볼 수 있다.

pull을 통해 받아오는것도 가능하다. 당연히 내가아닌 다른 누구의 것이라도 받아올 수 있다. 처음에 gihyodocker/echo:latest를 받아왔었다.