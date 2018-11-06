import React, {Component} from 'react';
import {connect} from "react-redux";

class User extends Component {

  render() {

    const usersList = this.props.users;
    console.log(this.props);
    const users = usersList.map((user) => {

      return (
          <div>
            <div>
              <h3>
                {user.userName}
              </h3>
            </div>
          </div>
      )
    });

    return (
        <div>
          <div className="container">
            <div className="main-content">
              <h1>Users list</h1>
              {users}
            </div>
          </div>
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