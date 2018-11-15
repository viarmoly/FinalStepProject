import React, {Component} from 'react';

class AddUserPage extends Component {
  handleSubmit (e) {
    e.preventDefault();

    fetch("/api/v1/users",
        {
          method: "POST",
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            userName: this.refs.userName.value,
            password: this.refs.password.value,
            userSalt: this.refs.salt.value
          })
        })
        .then(response => {
          debugger
          return response.json()
        })
        .then(body => console.log(body));
  }

  render() {
    return (
        <form onSubmit={this.handleSubmit.bind(this)}>
          <input type="text"
                 id="userName"
                 name="userName"
                 ref="userName"
                 placeholder="User name"/>
          <input type="text"
                 id="password"
                 name="password"
                 ref="password"
                 placeholder="password"/>
          <input type="text"
                 id="salt"
                 name="salt"
                 ref="salt"
                 placeholder="Salt"/>
          <input type="submit" value="Add new user"/>
        </form>
    )
  }
}

export default AddUserPage;
