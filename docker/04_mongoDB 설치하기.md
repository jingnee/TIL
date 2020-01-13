# mongoDB 설치하기

mongoDB를 설치하기 위해(뒤에서 레플리카를 위해서 여러개의 몽고디비를 설치할거임) docker-compose를 사용할것인데 복습할겸 한번더 정리했다.

### docker-compose (p.76)

- 도커 애플리케이션을 정의하고 실행하는 도구

- tools for defining and running **multi-container** Docker applications

- Docker 커맨드 또는 복잡한 설정을 쉽게 관리하기 위한 도구

- YAML format 에 Docker 생성, 설정 관련 된 작업을 작성해 놓은 scripts파일

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

```shell
$ docker-compose up

$ docker-compose down 			//(stop됐을때 remove까지됨)

$ docker-compose up --biuld 	//docker파일을 다시 빌드
```



### Dockerfile로 몽고디비설치하기

dockerfile 작성

```dockerfile
FROM mongo
CMD ["mongod", "--replSet", "myapp"]
```

베이스이미지 검색은 도커허브에서 하면된다. mongodb를 치면 몽고디비를 이용할 수 있는 베이스이미지 mongo가 나온다.

```shell
$ docker build -t mongodb:latest .
$ docker run mongodb
```

이미지생성하고 컨테이너 실행

새로운 파워쉘을 켜서 몽고디비에 접속한다.

```shell
$ docker exec -it [mongodb containerID/name] sh
# mongo
> show dbs;
> use bookstore;
> db.books.save({'title':'Docker compose sample'});
> db.books.find();
```

mongodb client는 mongo로 접속한다.

mongodb는 noSQL문으로 속성값을 따로 설정해주는것이 없고 document형식으로 데이터를 삽입한다. (나중에 정리할 예정)