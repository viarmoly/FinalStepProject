import React, {Component} from 'react';
import {connect} from "react-redux";

class UserRole extends Component {

  render() {
    const userRolesList = this.props.userRoles;

    const userRoles = userRolesList.map((userRole) => {
      return (
          <div>
            {userRole.role}
          </div>
      )
    });

    return (
        <div className="container">
          <h1>User roles list</h1>
          {userRoles}
        </div>
    )
  }
}

function mapStateToProps(state) {
  return {
    userRoles: state.userRoles
  }
}

export default connect(mapStateToProps)(UserRole);
