import React, {Component} from 'react'

class AddUserRole extends Component {
    constructor(props) {
        super(props);

        this.state = {
            userRole: ''
        };

        this.handleOnChange = this.handleOnChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();

        fetch('api/v1/userRoles', {
            headers: {
                'Content-Type': 'application/json',
                'Charset': 'UTF-8'
            },
            method: 'post',
            body: JSON.stringify(this.state)
        }).then(this.setState({
            userRole:''
        }))
    }

    handleOnChange(event) {
        this.setState({
            userRole: event.target.value
        })
    }

    render() {
        return (
            <div>
                <form method='post' onSubmit={this.handleSubmit}>
                    <h2>Add new user role</h2>
                    <input type='text' name='userRole' placeholder='User Role' onChange={this.handleOnChange}/>
                    <button>Add user role</button>
                </form>
            </div>
        );
    }
}

export default AddUserRole;