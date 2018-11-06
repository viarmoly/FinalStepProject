import React from 'react';
import {Provider} from 'react-redux';
import {App} from './components/App';
import {index} from "./store/index";
import * as ReactDOM from "react-dom";


ReactDOM.render(
    <Provider store={index}>
        <App/>
    </Provider>,
    document.getElementById('root')
);

