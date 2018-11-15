import React, {Component} from 'react';
import {connect} from "react-redux";

class User extends Component {

  render() {

    const usersList = this.props.users;
    const users = usersList.map((user) => {

      return (
          <div key={user.userId}>
            {user.userName}
          </div>
      )
    });

    return (
        <div className="container">
          <h1>Users list</h1>
          {users}
          <a href="/users/add" className="add-user-button">Add user</a>
        </div>
    )
  }
}

function mapStateToProps(state) {
  return {
    users: state.users
  }
}

export default connect(mapStateToProps)(User);
