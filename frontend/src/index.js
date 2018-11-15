import React from 'react';
import {Provider} from 'react-redux';
import App from './components/App/App';
import {store} from "./store/store";
import * as ReactDOM from "react-dom";


ReactDOM.render(
    <Provider store={store}>
        <App/>
    </Provider>,
    document.getElementById('root')
);

