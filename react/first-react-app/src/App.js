import React, { Component } from 'react';
import MyComponent from './components/MyComponent';
import MyComponentFunc from './components/MyComponentFunc';

export default class App extends Component {
  render() {
    return (
      <React.Fragment>
      <MyComponent name="React" age={10}/>
      <MyComponent age={20}/>
      {/* <MyComponent name={300} /> */}
      <MyComponentFunc name="함수형컴포넌트" age={15} />
   </React.Fragment>
    )
  }
}
