import {createStore, applyMiddleware} from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import thunk from 'redux-thunk';
import allReducers from '../reducers/index';

export const index = createStore(allReducers, composeWithDevTools(applyMiddleware(thunk)));