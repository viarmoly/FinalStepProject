import React from 'react';
import {Router, Route, Link,Switch} from 'react-router-dom';
import {connect} from 'react-redux';

import User from '../User/User'
import Contact from '../Contact/Contact'
import Lead from '../Lead/Lead'
import Product from '../Product/Product'
import Status from '../Status/Status'
import UserRole from '../UserRole/UserRole'

class Header extends React.Component {
    render(){
        return(
            <div>
               <Switch>
                   <Route path ="/users" component={User}/>
                   <Route path ="/contacts" component={Contact}/>
                   <Route path ="/leads" component={Lead}/>
                   <Route path ="/products" component={Product}/>
                   <Route path ="/statuses" component={Status}/>
                   <Route path ="/userRoles" component={UserRole}/>
               </Switch>
            </div>

        )

    }
}

export default Header




