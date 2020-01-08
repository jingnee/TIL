# Docker에 Mysql 설치하기

```shell
$ docker run -d -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=true --name mysql mysql:5.7
```

mysql이 없기 때문에 run 명령을 실행하면 mysql을 찾아와서 생성하고 실행해준다.

![](E:\TIL\docker\pic\mysql설치.png)

-e MYSQL_ALLOW_EMPTY_PASSWORD=true 옵션은 비밀번호를 설정하지 않는다는 뜻이다.

이 옵션말고 

-e MYSQL_ROOT_PASSWORD=password 옵션으로 root계정의 비밀번호를 설정해 놓아도 된다.

설정안하려면 위와같은 옵션을 꼭 써주어야 함



docker images 를 통해 잘 설치되었는지 확인하고 mysql에 접속해보자.

```shell
> docker exec -it mysql bash
# mysql -uroot -p
```

![](E:\TIL\docker\pic\mysql접속.png)

비밀번호는 설정하지 않았으니 그냥 `Enter`를 누르면 mysql>로 프롬프트가 변경된것을 볼 수 있다.

mysql client 접속 성공!

