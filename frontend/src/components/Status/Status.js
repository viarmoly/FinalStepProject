import React, {Component} from 'react';
import {connect} from "react-redux";

class Status extends Component {

  render() {

    const statusesList = this.props.statuses;
    const statuses = statusesList.map((status) => {

      return (
          <div>
            {status.name}
          </div>
      )
    });

    return (
        <div className="container">
          <h1>Statuses list</h1>
          {statuses}
        </div>
    )
  }
}

function mapStateToProps(state) {
  return {
    statuses: state.statuses
  }
}

export default connect(mapStateToProps)(Status);
