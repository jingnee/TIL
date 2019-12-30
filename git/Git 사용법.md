# Git 사용법



### 1. git과 연동하고 싶은 폴더를 만들고 이동한다.

```shell
$ ~					//home directory로 이동
$ mkdir TIL			//TIL이라는 폴더를 만듦
$ cd TIL			//TIL 폴더로 이동
```



### 2. git 시작하기

git에 관한 명령어는 앞에 `git`을 붙인다.

```shell
$ git init			// .git 파일을 만든다.
$ rm -r .git/		// .git 파일 제거 -> 이 파일이랑 git 연동 안할래
```



### 3. git commit 하기

git은 코드 버전관리 도구이다. 내 코드를 여러개의 버전으로 저장할 수 있는데 이것을 `스냅샷`이라고 한다. `스냅샷`을 찍기 위해서는 `add`명령어를 통해서 `스냅샷`을 찍을 수 있는 테이블(index..)로 올린 다음 commit 명령어(메시지와 함께)로 저장하면 된다.

```shell
$ git add README.md				//README.md라는 파일을 올린다.
$ git commit					// vi 편집기가 열리고 커밋 메시지 작성 가능
$ git commit -m "first commit"	// 메시지 내용과 함께 커밋 가능
$ git log						// commmit된 내용들을 볼 수 있다.
$ git log --oneline				// commit 내용을 한줄씩 깔끔하게 볼 수 있다.
$ git status					// add된 파일이 있는지, 커밋할게 있는지 등을 보여줌
```



## 4. git push 하기

```shell
$ git remote add [원격저장소 이름] [원격저장소 주소]	//이제부터 이 이름으로 원격저장소에 저장할거야
$ git remote -v		//원격 저장소 주소 알려줌(자세하게 보기)
$ git push [원격저장소 이름] [브랜치이름]		//origin master
										   //명령어 입력하면 로그인창이 뜬다.
```



### 5. git 가져오기

```shell
$ git clone [원격저장소 주소]				//원격에있는 git 가져오기(처음 다 가져올 때)
$ git pull [원격저장소 이름] [브랜치 이름]	// 새로 추가된 일부를 가져오기
```



### 5.git command

```shell
$ git diff --staged				//최근에 무엇이 바뀌었는지 보여준다.
$ git checkout abc123			//abc123(log 번호) 상태로 돌아간다. (복원이 아니라 시점만 변경)
$ git checkout master			//다시 원래대로 돌아옴
```



### git으로 협업하기

대표자가 github에서 repository를 만든다. 대표자는 github.com 에서 `contributor` 눌러서 팀원을 추가해준다.

팀원은 `$ git git clone [github 주소]` 을 통해 처음에 내용을 받아오고 그 이후로 수정하고 add -> commit -> push 해준다.