# Docker 시작하기

[https://hub.docker.com/](도커허브사이트) 에서 회원가입하고 도커 다운로드

두번정도 재부팅되고 docker가 running 되는것을 확인

shared Drive에서 윈도우즈 \C 와 연결하고 시작



- docker server 실행하기

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

- 서버 접속하기

powershell을 하나 더 띄워서

```shell
$ curl http://localhost:9000/
```

httr://localhost:9000/ 은 웹에서도 접속이 가능하다.



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



