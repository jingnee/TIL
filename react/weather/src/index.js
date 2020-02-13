import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';       //rdx가 react로 작업을 보낼때 한꺼번에 보내주는거? : applyMiddleware

import ReduxPromise from 'redux-promise';

import App from './App';

import reducers from './reducers';

// make a store 
const createStoreWithMiddleware = applyMiddleware(ReduxPromise)(createStore);

ReactDOM.render(
  <Provider store={createStoreWithMiddleware(reducers)}>
    <App />
  </Provider>
  , document.getElementById('root'));
