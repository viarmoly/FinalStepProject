import React, {Component} from 'react';
import {connect} from "react-redux";

class Contact extends Component {

  render() {

    const contactsList = this.props.contacts;
    console.log(this.props);
    const contacts = contactsList.map((contact) => {

      return (
          <div>
            {contact.name}
          </div>
      )
    });

    return (
        <div className="container">
          <h1>Contacts list</h1>
          {contacts}
        </div>
    )
  }
}

function mapStateToProps(state) {
  return {
    contacts: state.contacts
  }
}

export default connect(mapStateToProps)(Contact);
