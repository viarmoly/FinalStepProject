import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import {connect} from 'react-redux';
import './index.scss';


import User from '../User/User'
import Contact from '../Contact/Contact'
import Lead from '../Lead/Lead'
import Product from '../Product/Product'
import Status from '../Status/Status'
import UserRole from '../UserRole/UserRole'
import {loadUsers} from "../../actions/usersAction";
import {loadUserRoles} from "../../actions/userRoleAcrtion";

class App extends React.Component {

  componentDidMount() {
    if (this.props.users.length === 0) {
      this.props.loadUsers();
    }

    if (this.props.userRoles.length === 0) {
      this.props.loadUserRoles();
    }
  }

  render() {
    return (
        <div className="container">
          <BrowserRouter>
            <div>
              <Route path="/users" component={User}/>
              <Route path="/contacts" component={Contact}/>
              <Route path="/leads" component={Lead}/>
              <Route path="/products" component={Product}/>
              <Route path="/statuses" component={Status}/>
              <Route path="/userRoles" component={UserRole}/>
            </div>
          </BrowserRouter>

        </div>
    );
  }
}

const mapStateToProps = state => ({
  users: state.users,
  userRoles: state.userRoles
});

const mapDispatchToProps = dispatch => ({
  loadUsers: () => dispatch(loadUsers()),
  loadUserRoles: () => dispatch(loadUserRoles())
});

export default connect(mapStateToProps, mapDispatchToProps)(App);
