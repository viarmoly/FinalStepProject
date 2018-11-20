import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import {loadUsers} from "../../actions/usersAction";
import './index.scss';
import User from '../User/User';
import Contact from '../Contact/Contact';
import ContactLeads from '../Contact/ContactLeads';
import Product from '../Product/Product';
import Status from '../Status/Status';
import UserRole from '../UserRole/UserRole';
import {loadUserRoles} from "../../actions/userRoleAcrtion";
import {loadProducts} from "../../actions/productsAction";
import {loadContacts} from "../../actions/contactsAction";
import {loadStatuses} from "../../actions/statusesAction";
import LoginPage from "../../containers/LoginPage/LoginPage";
import HomePage from "../../containers/HomePage/HomePage";
import NotFound from "../404Handler/NotFound";
import connect from "react-redux/es/connect/connect";
import AddUserPage from "../User/AddUserPage";
import AddContact from "../Contact/AddContact";
import AddProduct from "../Product/AddProduct";


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
            <Switch>
              <Route path="/login" exact component={LoginPage}/>
              <Route path="/home" exact component={HomePage}/>
              <Route path="/users" exact component={User}/>
              <Route path="/users/add" exact component={AddUserPage}/>
              <Route path="/contacts" exact component={Contact}/>
              <Route path="/contacts/:id" exact component={ContactLeads}/>
              <Route path="/contacts/add" exact component={AddContact}/>
              <Route path="/products" exact component={Product}/>
              <Route path="/products/add" exact component={AddProduct}/>
              <Route path="/statuses" exact component={Status}/>
              <Route path="/userRoles" exact component={UserRole}/>
              <Route component={NotFound}/>
            </Switch>
          </BrowserRouter>
        </div>
    );
  }
}

const
    mapStateToProps = state => ({
      users: state.users,
      userRoles: state.userRoles,
      products: state.products,
      contacts: state.contacts,
      statuses: state.statuses
    });

const
    mapDispatchToProps = dispatch => ({
      loadUsers: () => dispatch(loadUsers()),
      loadUserRoles: () => dispatch(loadUserRoles()),
      loadProducts: () => dispatch(loadProducts()),
      loadContacts: () => dispatch(loadContacts()),
      loadStatuses: () => dispatch(loadStatuses())
    });

export default connect(mapStateToProps, mapDispatchToProps)(App)
