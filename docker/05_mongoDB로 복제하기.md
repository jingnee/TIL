# mongodb로 replica 하기

## 1. mongodb container 3개 띄우기

primary 1개, secondary 2개

![](C:\Users\HPE\TIL\docker\pic\mongodb3개.png)

생성하고 컨테이너 접속

## 2. replica set 만들기

### 2.1 replica set 초기화

```shell
$ rs.intate
```

### 2.2 IP Binding

컨테이너 IP는 도커엔진이 임의로 할당. 그래서 컨테이너 IP 알기 위해서 컨테이너에 먼저 접속해야 알 수 있어

IP Bindning을 하기전에 IP를 알아야 한다. (셋중 하나만 사용)

```shell
- docker inspect [Container ID]		//컨테이너 세부내용 알 수 있어. 마지막부분에 IP address나와
- docker exec -it [Container ID] bash
> hostname -i
- docker exec -it [Container ID] hostname -i	//위에두줄을 한줄로 사용도 가능
```

ip address 아는 명령어는 hostname -i 외에 다음과 같이 있다. 가능한거 아무거나 사용(파워쉘에서는 hostname -i만 가능)

```shell
- ifconfig
- ip addr show
- hostname -i
```



```
최소리눅스라서 명령어가 너무없어 설치하고싶은데!
나는 `ping` 쓰고싶어
$ apt-get install -y iputils-ping
근데 이 패키지가 없대 그러면 apt-get을 업데이트 시켜주면 돼
$ apt-get update
```





레플리카 셋 초기화부터 바인딩까지 한파일로 자동화하게 하고싶어

컨테이너에서 하나하나 실행해도되지만 우리는 `setup.sh`을 통해서 한번에 자동화하게끔 할거야

셋업은 서버를 띄워야 가능

docker-compose 파일로 컨테이너실행까지 한큐에 할 수 있도록 해보자



NAT와 Bridge

`Dockerfile`	: mongo베이스이미지를 가지고 이미지생성. 디렉터리 만들고 위치변경. replicaSet이랑 setup 현재위치로 이동시켜주고 ./setup.sh 실행 (전에는 CMD ["mongod", "--replSet", "myapp"]로 입력했었어 mongod서버를 실행해주었음)

`setup.sh` : mongo1은 docker-compose.yml 에서 설정한 iP주소랑 연결시켜줄 이름. mongo를 통해 몽고들어가서 mongod(몽고서버접속)

setup.sh 지우고 dockerfile CMD에 setup.sh 내용넣어도됨

`replicaSet.js` : 레플리카셋을 만든다. mongo1,2,3의 IP주소를 이용해서 27017포트번호와 연결되는 몽고 컨테이너 세개 생성

`docker-compose.yml` : mongo1에서 포트포워딩이랑 볼륨마운트하고 네트워크는 mongo-networks라는 가상의 브릿지를 생성해서 만들거야(브릿지 같은네트워크로 매핑하게해주는거?) 전에 도커파일에 입력했던 mongod --replSet myapp 명령어를 실행.(볼륨생성임)



몽고 셋업이라는 컨테이너생성 이미지는 새로운 도커파일로 만든 이미지 이름(mongo_repl_setup)을 이용. depends_on은 mongo1이 선행된다음 한다는 듯 네트워크는 mongo-networks 이용할거야

네트워크에서 mongo-networks라는 이름의 역할은 브릿지다

rs.isMaster()

rs.status();

docker exec -it mongodb_mongo1_1 mongo mongodb://mongo1:27017

컨테이너들어가면서 몽고디비접속

PRIMARY> 

```
> show dbs;
> use bookstore;
> db.books.find();
> db.books.save({'title':'Docker compose files'}); db.books.save({'title':'Java programming'});
```

secondary에서 확인도 가능

세컨더리에서 확인할때 안되면 마스터도 슬레이브도 아니라서 그런오류뜸 그때 rs.slaveOk(); 해서 슬레이브로만들어주면돼

복제확인하고

프라이머리를 스탑해보자(컨테이너 중지)

세컨더리가 프라이머리로 승격되는지 확인



--no-cache





services:

1. docker-compose

   ​	container 목록/생성

2. docker swarm (기본패키지)

3. kubernetes (추가 설치 패키지)