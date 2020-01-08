웹에 올라간 내용 바꾸고 싶어

1. index.js 수정 윈도우에서 해서 다시 build, run

2. container에서 바꾸기 (서버 재부팅)

3. index.js 수정 윈도우에서해서 반영 (이방법을 사용하기 위해서 윈도우에서 사용하고있는 폴더를 리눅스에서 사용하는 폴더를 연결해놔야함.volume mount)

   

   

## volume mount



볼륨마운트 : 윈도우에서 만든 폴더(데이터가 들어가있는)를 컨테이너에서 받아서 쓸때 그 shared된 폴더가 volume mount. 아마존의 S3.데이터 볼륨

```shell
$ -v/my/datadir:/var/lib/mysql
```

3-1. 매핑 방식 [hostfilepath] : [containerfilepath]

docker run -v C:\Users\HPE\docker\day01\simpleweb:/home/node -d -p 8080:8080
jingnee/simpleweb:modified

디렉토리를 직접 마운트하는 방법



3-2. 공유하고자 하는 폴더 자체도 container 화시켜

```shell
docker run -d --rm --name mysql `
-e "MYSQL_ALLOW_EMPTY_PASSWORD=yes" `
-e "MYSQL_DATABASE=volume_test" `
-e "MYSQL_USER=example" `
-e "MYSQL_PASSWORD=example" `
--volumes-from mysql-data `
mysql:5.7
```

docker exec -it mysql bash



 mysql -uroot -p volume_test

두번입력할거 한번에 입력할 수 있어

docker exec -it mysql mysql -uroot -p volume_test

volume 만들어->mysql접속->table생성->속성입력->컨테이너삭제(볼륨삭제)->다시만들어서 DB들어가보면 내용있어

(잘안됨 집에서해보기..)





### docker-compose (p.76)

도커 애플리케이션을 정의하고 실행하는 도구

tools for defining and running **multi-container** Docker applications

Docker 커맨드 또는 복잡한 설정을 쉽게 관리하기 위한 도구

YAML format 에 Docker 생성, 설정 관련 된 작업을 작성해 놓은 scripts파일

```yaml
version: '3.1'
services:
	servicename: # optional
		images: # optional
		command: # optional
		environment: # optional
		volumes # optional
		ports:
volumes: # optional
network: # optional
```

docker-compose 실행명령어

docker-compose up

docker-compose down	(stop됐을때 remove까지됨)

docker-compose up --biuld		--> docker파일을 다시 빌드

```yaml
version: '3'
services:
    my-mysql:
        image: mysql:5.7
        ports:
            - "3306:3306"
        environment:
            - MYSQL_ALLOW_EMPTY_PASSWORD=true
```

docker run -p 3306:3306 --name -e MYSQL_ALLOW_EMPTY_PASSWORD=true my-mysql mysql:5.7

명령어로하거나

compose파일로 하거나



 mysql-data:

​    build: .

(야물에서) 이러면 기존에 있는 ㅇ도커파일을 가지고 이미지생성하겠다는거야

.대신 jingnee/simpleweb사용해도돼(이미지이름)



image : templage(붕어빵 틀)

container : 실체화(붕어빵)

이미지생성하기위한 방법

1. 허브사이트에서 pull
2. local pc에 있는 이미지 build (이미지생성) 반드시 도커파일이 필요해!

docker create "이미지명" -> 얘는 start 명령어 필요

docker run "이미지명"

### docker-compose 파일로 mongoDB설치하기

1. mongodb를 Docker container로 실행

2. dockerfile 작성(mongodb 설치를 위한 이미지 생성)

3. dockerfile의 image build

   1. jingnee/mymongdb:latest

4. Mongodb container 생성 :arrow_right: 실행

5. Client에서 mongodb 테스트

   $ mongo -h <IP> -p <PORT>

   mongo> show dbs;

   mongo> use bookstore;

   mongo> db.books.save({'title':'Docker compose sample'});

   mongo> db.books.find();

## mongoDB복제하기

mongoDB 3대 설치 (Primary *1, Secontary *2)

1. Replica Set

   ex) mongod --replSet myapp --dbpath /폴더지정 --port 27017 --bind_ip_all













ip주소 아는 명령어

ifconfig
ip addr show
hostname -i