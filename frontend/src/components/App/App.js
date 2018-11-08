import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import {connect} from 'react-redux';
import './index.scss';


import User from '../User/User'
import Contact from '../Contact/Contact'
import ContactLeads from '../Contact/ContactLeads'
import Product from '../Product/Product'
import Status from '../Status/Status'
import UserRole from '../UserRole/UserRole'
import {loadUsers} from "../../actions/usersAction";
import {loadUserRoles} from "../../actions/userRoleAcrtion";
import {loadProducts} from "../../actions/productsAction";
import {loadContacts} from "../../actions/contactsAction";
import {loadLeads, loadStatuses} from "../../actions/statusesAction";

class App extends React.Component {

  componentDidMount() {
    if (this.props.users.length === 0) {
      this.props.loadUsers();
    }

    if (this.props.userRoles.length === 0) {
      this.props.loadUserRoles();
    }

    if (this.props.products.length === 0) {
      this.props.loadProducts();
    }

    if (this.props.contacts.length === 0) {
      this.props.loadContacts();
    }

    if (this.props.statuses.length === 0) {
      this.props.loadStatuses();
    }
  }

  render() {
    return (
        <div className="container">
          <BrowserRouter>
            <div>
              <Route path="/users" component={User}/>
              <Route path="/contacts" component={Contact}/>
              <Route path="/contacts/:id" component={ContactLeads}/>
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
  userRoles: state.userRoles,
  products: state.products,
  contacts: state.contacts,
  statuses: state.statuses
});

const mapDispatchToProps = dispatch => ({
  loadUsers: () => dispatch(loadUsers()),
  loadUserRoles: () => dispatch(loadUserRoles()),
  loadProducts: () => dispatch(loadProducts()),
  loadContacts: () => dispatch(loadContacts()),
  loadStatuses: () => dispatch(loadStatuses())
});

export default connect(mapStateToProps, mapDispatchToProps)(App);
