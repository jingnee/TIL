Concat&Slice 사용하기

```
>const myArray = [1,2,3,4,5];
undefined

>let newArray = myArray.slice(0,2).concat(myArray.slice(3,5));
undefined
>newArray
[ 1, 2, 4, 5 ]
```

```
>newArray
[ 1, 2, 4, 5 ]
>myArray
[ 1, 2, 3, 4, 5 ]
[...myArray.slice(0,2), ...myArray.slice(3,5)]
[ 1, 2, 4, 5 ]
```



map&filter사용하기

```
myArray.map(v=>v**2);			//가지고있는 모든데이터 제곱하기
[ 1, 4, 9, 16, 25 ]
```

```
>myArray.map(v=>console.log('<div>' + v + '</div>'));
<div>1</div>
<div>2</div>
<div>3</div>
<div>4</div>
<div>5</div>
```

```
>myArray.filter(n => n===3);
[ 3 ]
>myArray.filter(n=> n!==3);
[ 1, 2, 4, 5 ]
```



수정하기 연습(3가지)

modifiedArray는 내용이 text만 가지게 바뀌어버림

modifiedArray2 : 전개연산자 사용

modifiedArray3 : 하나하나 설정

```
>const myTag = [
... {id:0, text:'Hello', tag:'a'},
... {id:1, text:'World', tag:'b'},
... {id:2, text:'Bye', tab:'c'}
... ];
undefined
> myTag
[
  { id: 0, text: 'Hello', tag: 'a' },
  { id: 1, text: 'World', tag: 'b' },
  { id: 2, text: 'Bye', tab: 'c' }
]

> const modifiedArray = myTag.map(v=>v.id === 1? ({text:'React'}):v);
undefined
> modifiedArray
[
  { id: 0, text: 'Hello', tag: 'a' },
  { text: 'React' },
  { id: 2, text: 'Bye', tab: 'c' }
]

> const modifiedArray2 = myTag.map(v=>v.id === 1? ({...v, text:'React'}):v);
undefined
> modifiedArray2
[
  { id: 0, text: 'Hello', tag: 'a' },
  { id: 1, text: 'React', tag: 'b' },
  { id: 2, text: 'Bye', tab: 'c' }
]

> const modifiedArray3 = myTag.map(v=>v.id === 1? ({id:v.id, text:'React', tag:v.tag}):v);
undefined
> modifiedArray3
[
  { id: 0, text: 'Hello', tag: 'a' },
  { id: 1, text: 'React', tag: 'b' },
  { id: 2, text: 'Bye', tab: 'c' }
]
```



---

오늘코드 마무리

**App.js**

```js
import React, {Component} from 'react';
import PhoneForm from './components/phone_form';
import PhoneList from './components/phone_list';

class App extends Component {
  id=3;
  state={
    contacts: [
      {
        id: 0,
        name: '관리자',
        phone: '010-1111-1111'
      },
      {
        id: 1,
        name: '홍길동',
        phone: '010-1234-5678'
      },
      {
        id: 2,
        name: '아메리카노',
        phone: '02-426-4242'
      }
    ]
  }

  handleCreate = (data) => {
    //data -> contacts 배열에 추가
    const{ contacts }=this.state;
    this.setState({
      contacts:contacts.concat({id:this.id++, ...data})
    })

  }

  handleRemove = (selected_id) => {
    // state의 contacts 에서 해당 ID값을 삭제
    console.log('App handleRemove=' + selected_id);
    const {contacts}=this.state;

    this.setState({
      contacts: contacts.filter(
        info => info.id !== selected_id
      )
    });
    //console.log(this.state.contacts);
  }

  handleModify = (selected_id, data)=>{
    const {contacts}=this.state;
    //this.state.contacts -> 반영(this.setState())
    this.setState({
      contacts: contacts.map(
        info=>info.id===selected_id ? {...info, ...data} : info
        //data를 전개연산자로 사용하지않으면 {id:#, name:이름, phone:010-1111, data} 이런식으로 그냥 옆에 요소로 하나 붙어버린다
      )
    });
  }

  render(){
    const{ contacts }=this.state;   //contacts는 이름 다른 이름 사용가능
    // console.log(this.state);
    // console.log(this.state.contacts);
    // console.log(contacts);
    return (
      <div>
        <PhoneForm
        onCreate={this.handleCreate}/>
        <PhoneList data={this.state.contacts}
        onRemove={this.handleRemove}
        onModify={this.handleModify}
        />
      </div>
    );
  }
}

export default App;

```

**phone_form.js**

```js
import React, {Component} from 'react';

class PhoneForm extends Component {
    state = {
        name : '',
        phone : ''
    };

    constructor(props){ //=>가 아닌 function으로 쓰고 싶을때
        super(props);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange = function(e){
        this.setState({
            //name : e.target.value
            [e.target.name]: e.target.value
        })
        //console.log(e.target.value);
    }

    handleSubmit=(e)=>{
        e.preventDefault();             //데이터 바로사라지는거 방지
        this.props.onCreate(this.state);
        this.setState({
            name: '',
            phone: ''
        });
    }

    render(){
        return (
            <form onSubmit={this.handleSubmit}>
                <input
                value={this.state.name}
                placeholder='이름을 입력하세요'
                onChange={this.handleChange}
                name='name'/>
                <input
                value={this.state.phone}
                placeholder='전화번호를 입력하세요'
                onChange={this.handleChange}
                name='phone'/>
                <button type='submit'>등록</button>
            </form>
        );
    }
}

export default PhoneForm;
```

**phone_list.js**

```js
import React, {Component} from 'react';
import PhoneItem from './phone_item';

class PhoneList extends Component {
    render(){
        //const data = this.props;        //contacts 쓰고싶으면 data.contacts로 써야함
        const {data, onRemove, onModify} = this.props;        //contacts 쓰고싶으면 data로 씀

        const list = data.map(value =>
            (
            <PhoneItem key={value.id}
            info={value}
            onRemove={onRemove}
            onModify={onModify}/>
            )
            );

        return (
            <div>
                {list}
            </div>
        )
    }
}

export default PhoneList;
```

**phone_item.js**

```js
import React, {Component}from 'react';

class PhoneItem extends Component {
    state={
        editable: false,            //현재 editable이 false일경우 수정, true일경우 수정된값 등록
        name: '',
        phone: ''
    }

    componentDidUpdate(preProps, preState){
        const{info, onModify}=this.props;
        console.log(info.name + '/' + info.phone);
        //console.log(onUpdate);
        console.log(preState.editable+'/'+this.state.editable);
        if(!preState.editable && this.state.editable){
            this.setState({
                name:info.name,
                phone:info.phone
            })
        }
        //update
        if(preState.editable && !this.state.editable){
            onModify(info.id, {
                name:this.state.name,
                phone: this.state.phone
            });
        }
    }
    handleRemove = ()=>{
        const {info, onRemove} = this.props;
        onRemove(info.id);
    }

    handleModify = ()=>{
        // const {info,onModify}=this.props;
        // onModify(info.id,);
        const {editable} = this.state;
        //const editable = this.state.editable;
        this.setState({
            editable: !editable    
        });
    }

    handleChange = (e)=>{
        const { name, value} = e.target;
        this.setState({
            [name]:value
        });
    }

    render(){
        const css={
            border:'1px solid black',
            padding:'8px',
            margin:'5px'
        };
        
        const {editable}=this.state;
        if(editable) {
            return (
                <div style={css}>
                    <div>
                        <input value={this.state.name}
                        name="name"
                        placeholder="이름을 입력하세요."
                        onChange={this.handleChange}/>
                    </div>
                    <div>
                        <input value={this.state.phone}
                        name="phone"
                        placeholder="연락처를 입력하세요."
                        onChange={this.handleChange}/>
                    </div>
                    <button onClick={this.handleRemove}>삭제</button>
                    <button onClick={this.handleModify}>적용</button>
                </div>
            )
        }
        else {
            
        }

        const {name, phone} = this.props.info;
        // console.log(id);
        // console.log(name);
        // console.log(phone);


        return (
            <div style={css}>
                <div><b>{name}</b></div>
                <div><b>{phone}</b></div>
                <button onClick={this.handleRemove}>삭제</button>
                <button onClick={this.handleModify}>수정</button>
            </div>
        );
    };
}

export default PhoneItem;
```



