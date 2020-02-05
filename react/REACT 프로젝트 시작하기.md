# REACT 프로젝트 시작하기

- 프로젝트 생성

  - npx create-react-app contact-app
  - cd contact-app
  - yarn start (or npm start) : 개발자모드 실행

  

npx이 npm보다 효율적인 공간 관리를 해줌

react만으로 서버사이드 내용을 다 만들 수는 없어. node.js나 java,python과 연결해주어야함

<설치되는 것들>

- react

- react-dom : Document Object Model (웹브라우저에 보이는 내용을 모델로 보여주는것)

- virtual-dom 변경된것만 갱신해주는 방법(dom은 놔둔 상태로 메모리에 가상의 돔을 만들어. 비교해서 변경된부분만 바뀐다)-> 화면을 효율적으로 관리

- react-scripts

- cra-template

.gitignore : 내가 올리고 싶지 않은 내용을 명시할 수 있어(설정파일등을 넣으면 됨 ex)node_modules) 캐쉬지우고 반영

coverage : 내가만든 함수, class들이 몇번실행되었는지, 어느것이 실행되는지 %로 알려줌. 이 파일을 통해서 필요없는 함수가 무엇인지 알 수 있어

package.json : node.js의 설정파일. 프로그램이 시작할때 제일먼저 검사한다. 

- script: 프로그램실행할때 참고할만한 명령어
- dependencies
- version

node_modules : 라이브러리 모두 존재한다. 용량 매우큼



react의 시작은 `src`폴더 안에있는 `App.js` (App이름. 변경가능)

JSX문법을 react가 렌더링해서 html문서로 변경해준다.



