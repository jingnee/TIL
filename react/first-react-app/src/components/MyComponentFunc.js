import React from 'react';
const MyComponentFunc = ({name,age}) => {
//function MyComponentFunc(props) {
    return (
        <div>
            부모로 부터 받는 상태변수 {name} / {age}
        </div>
    );
}

export default MyComponentFunc;