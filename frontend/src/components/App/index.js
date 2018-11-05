import React from 'react';
import {Router, Route} from 'react-router-dom';
import {connect} from 'react-redux';

import {history} from '../../helpers/index';
import {alertActions} from '../../actions/index';
import {PrivateRoute} from '../../components';
import {HomePage} from '../HomePage/index';
import {LoginPage} from '../LoginPage/index';
import {RegisterPage} from '../RegisterPage/index';
// import {Header} from '../Header/index'
//
import './index.scss';


import User from '../User/User'
import Contact from '../Contact/Contact'
import Lead from '../Lead/Lead'
import Product from '../Product/Product'
import Status from '../Status/Status'
import UserRole from '../UserRole/UserRole'

class App extends React.Component {
    constructor(props) {
        super(props);

        const {dispatch} = this.props;
        history.listen((location, action) => {
            // clear alert on location change
            dispatch(alertActions.clear());
        });
    }

    render() {
        const {alert} = this.props;
        return (
            <div className="jumbotron">
                <div className="container">
                    <div className="col-sm-8 col-sm-offset-2">
                        {alert.message &&
                        <div className={`alert ${alert.type}`}>{alert.message}</div>
                        }
                        <Router history={history}>
                            <div>
                                <PrivateRoute exact path="/" component={HomePage}/>
                                <Route path="/login" component={LoginPage}/>
                                <Route path="/register" component={RegisterPage}/>
                                <Route path ="/users" component={User}/>
                                <Route path ="/contacts" component={Contact}/>
                                <Route path ="/leads" component={Lead}/>
                                <Route path ="/products" component={Product}/>
                                <Route path ="/statuses" component={Status}/>
                                <Route path ="/userRoles" component={UserRole}/>
                            </div>
                        </Router>
                    </div>
                </div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    const {alert} = state;
    return {
        alert
    };
}

const connectedApp = connect(mapStateToProps)(App);
export {connectedApp as App};