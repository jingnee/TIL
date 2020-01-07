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

shared Drive에서 디스크하나 연결해준다.



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

<<<<<<<<<<<<<npm install 화면>>>>>>>>>>>>>>>>>>>>>>>>>

#### 3.2 Dockerfile 만들기

이제 이걸 도커파일로 만들어 보려고 한다. code . 입력해서 visual code 켜준 다음 `Dockerfile`을 만든다. 파일을 만들기 전에 vscode에서 왼쪽 `Extension`에서 Docker를 다운로드 해준다.

```dockerfile
FROM node:alpine
WORKDIR /home/node
COPY ./package.json ./package.json
COPY ./index.js ./index.js
RUN npm install
CMD ["npm","start"]
```

WORKDIR은 현재 디렉토리를 변경해준다.

COPY는 윈도우에 있는 파일을 리눅스 컨테이너로 넣게 해준다.

FROM을 통해서 alpine(엄청작은 리눅스)이라는 베이스 이미지를 설치해주고

RUN으로 npm 설치를 해준 다음

CMD 에 들어가있는 인자값이 커맨드 명령어로 들어가게 한다.

#### 3.3 image 빌드 및 실행

Dockerfile을 통해 이미지를 만들었으니, 이제 빌드하고 실행해보자.

```shell
$  docker build -t jingnee/simpleweb:latest .
$ docker image ls			//설치된 이미지 보기
$ docker run -d -p 9000:8080 jingnee/simple:latest
```

run은 실행 명령어인데, 만약 설치되지않았으면 설치를 진행하고 실행한다.

-d 는 demon으로 백그라운드로 실행하게 해준다.

-p 옵션은 9000번이라는 포트로 연결하겠다는 옵션이다.

#### 3.3 웹 확인



### 4. 이미지 업로드 및 다운로드

hub.docker 사이트에 내가 만든 이미지를 업로드 하거나 나또는 남의 이미지를 원격에서 다운받아 올 수 있다.

```shell
$ docker push jingnee/simpleweb:latest
$ docker pull jingnee/simpleweb:latest
```

<<<<<<<<<<<<<docker hub 화면>>>>>>>>>>>>>>>>>>>>>>>>>



---

### docker 기본 명령어

```shell
$ docker ps [-a]
```

현재 작동중인 프로세스 보여줌. 옵션 [-a]가 붙으면 중지된 프로세스도 보여줌

```shell
$ docker stop myweb1
```

myweb1이라고 지정한 컨테이너 중지(myweb1대신에 ps에서 보여진 container ID입력해도 됨)

container ID를 `space`간격으로 여러개 입력해서 한번에 중지도 가능(rm 도 가능)

또는 container ID에서 고유넘버 앞 두자리만 입력해도 가능

```shell
$ docker rm myweb1
```

중지한 컨테이너 삭제 (rm전에 stop이 선행되어야 한다! 마찬가지로 container ID를 입력해도됨)

```shell
$ docker container prune
```

중지된 컨테이너가 많을때 중지된 프로세스 모두 삭제

```shell
$ docker stop c0ce705bc020 & docker rm c0ce705bc020
```

 중지와 삭제 동시에하는 명령어

근데 파워쉘에서는 에러로 안됨 다른곳에서는 가능!

```shell
$ docker stop $(docker ps -q)	
```

아이디 지정해서 중지하는것도 귀찮아

$ docker ps -q를 입력하면 현재 돌고있는 프로세스 아이디 가져오는 명령어 (rm에서는 qa)

```shell
$ 
```



```shell
$ 
```



```shell
$ 
```

 

```shell
$ 
```



