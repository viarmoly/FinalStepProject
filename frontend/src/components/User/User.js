import React, {Component} from 'react';
import {connect} from "react-redux";

class User extends Component {

  render() {

    const usersList = this.props.users;
    console.log(this.props);
    const users = usersList.map((user) => {

      return (
          <div>
            {user.userName}
          </div>
      )
    });

    return (
        <div className="container">
          <h1>Users list</h1>
          {users}
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
