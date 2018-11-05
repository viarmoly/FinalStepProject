import React, {Component} from 'react';
import {connect} from "react-redux";

class User extends Component {

  render() {

    const usersList = this.props.users;
    console.log(this.state);
    const users = usersList.map((user) => {

      return (
          <div className="main-content__movie">
            <img src={user.id} alt="" className="main-content__movie-img"/>
            <div className="main-content__movie-details">
              <h3 className="main-content__movie-details__title-native">
                {user.name}
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
import React, {Component} from 'react'

class User extends Component{
    render(){
        return <h2>Users page</h2>
    }
}

export default User
