import React, { Component } from 'react';
import PropTypes from 'prop-types';

class MyComponent extends Component {
    static defaultProps = {
        name:'리액트default',
    }
    static propTypes = {
        name:PropTypes.string,
        age:PropTypes.number.isRequired
    }
    //state variable
    state = {
        number : 0,
        message : "",
        messages: ['Angular', 'React', 'Vue', 'Ember']
    }
    //number값을 감소시키는 함수
    handleDecrease = (e) => {
        console.log(e.target.value)
        this.setState({
            number : this.state.number-1
        });
    };
    handleChange = (e) => {
        this.setState({
            message : e.target.value
        });
    };
    handleInsert = () => {
        const {message, messages} = this.state;
        this.setState({
            messages: messages.concat(message),
            message :''
        });
    };
    handleEnter = (e) => {
        //onKeyPress이벤트로 사용
        // if(e.key === 'Enter'){
        //     this.handleInsert();
        // }
        //onKeyDown 이베트로 사용
        //console.log(e);
        if(e.keyCode === 13){
            this.handleInsert();
        }
    }
    handleRemove = (index) => {
        const {messages} = this.state;
        this.setState({
            messages: messages.filter((item,i) => (i !== index))
        });
    }

    render() {
        const {name,age} = this.props;
        const {number, message, messages} = this.state;
        const {handleDecrease, handleChange, handleInsert, handleEnter, handleRemove} = this;
        const msgList = messages.map((msg,idx)=> (
            <li key={idx} onDoubleClick={() => handleRemove(idx)}>{msg}</li>
        ));

        return (
            <div>
                Hello {name} / {age}
                <p>Number 값은 : {number}</p>
                <button onClick={()=>(this.setState({
                    number: number + 1
                }))}>증가</button>
                <button onClick={handleDecrease} value="decrease">감소</button><br/>
                <button onClick={
                    () => (this.mymessage.focus())
                }>포커스 주기</button><br/>

                <input type="text" value={message} onChange={handleChange} ref={(ref) => this.mymessage=ref} onKeyDown={handleEnter}/><br/>
                <button onClick={handleInsert}>추가</button>

                <button onClick={() =>(this.setState({
                    message:''
                }))}>초기화</button>
                <ul>
                    {msgList}
                </ul>
            </div>
        );
    }
}//class
// MyComponent.defaultProps = {
//     name:'리액트'
// };
// MyComponent.propTypes = {
//     name:PropTypes.string
// };
export default MyComponent;