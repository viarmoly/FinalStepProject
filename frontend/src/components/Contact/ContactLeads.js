import React, {Component} from 'react';
import {connect} from "react-redux";
import {loadContact} from "../../actions/contactAction";
import {contactLoading} from "../../actions/contactLoading";

class ContactLeads extends Component {
  componentDidMount() {
    if (this.props.contact.length === 0) {
      this.props.loadContact(+this.props.match.params.id);
    }
  }

  render() {
    if (contactLoading) {
      return (
          <div>
            Loading
          </div>
      )
    }

    const contact = this.props.contact;
    const leadsList = contact.leads;

    const contactLeads = leadsList.map((lead) => {
      return (
          <div>
            {lead.name}
          </div>
      )
    });

    return (
        <div className="container">
          <h1>Leads list</h1>
          {contactLeads}
        </div>
    )
  }
}

function mapStateToProps(state) {
  return {
    contact: state.contact,
    loading: state.contactLoading
  }
}

const mapDispatchToProps = dispatch => ({
  loadContact: () => dispatch(loadContact()),
  contactLoading: () => dispatch(contactLoading())
});

export default connect(mapStateToProps, mapDispatchToProps)(ContactLeads);
