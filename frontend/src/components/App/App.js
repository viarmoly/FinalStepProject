import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import './index.scss';


import User from '../User/User'
import Contact from '../Contact/Contact'
import ContactLeads from '../Contact/ContactLeads'
import Product from '../Product/Product'
import Status from '../Status/Status'
import UserRole from '../UserRole/UserRole'
import {loadUsers} from "../../actions/usersAction";
import {connect} from "react-redux";
import {loadUserRoles} from "../../actions/userRoleAcrtion";
import {loadProducts} from "../../actions/productsAction";
import {loadContacts} from "../../actions/contactsAction";
import {loadStatuses} from "../../actions/statusesAction";
import LoginPage from "../../containers/LoginPage/LoginPage";
import HomePage from "../../containers/HomePage/HomePage";
import NotFound from "../404Handler/NotFound";


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
                        <Route path="/contacts" exact component={Contact}/>
                        <Route path="/contacts/:id" exact component={ContactLeads}/>
                        <Route path="/products" exact component={Product}/>
                        <Route path="/statuses" exact component={Status}/>
                        <Route path="/userRoles" exact component={UserRole}/>
                        <Route component={NotFound}/>
                    </Switch>
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
