import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import configureStore from './reducer/store';
import {initialState} from "./reducer/stockPriceReducer";
import { Provider } from 'react-redux';

export const store = configureStore(initialState);

export let Index = props => (
    <Provider store={store}>
        <App />
    </Provider>
);

ReactDOM.render(<Index/>, document.getElementById('root'));