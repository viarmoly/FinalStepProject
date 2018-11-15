import React, {Component} from 'react';

class AddContact extends Component {
    constructor(props) {
        super(props);

        this.state = {
            name: '',
            age: 0
        };
        this.handleOnChange = this.handleOnChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleOnChange(event) {
        const inputName = event.target.name;
        this.setState({
            [inputName]: event.target.value
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        let status = this.state;

        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        headers.append('charset', 'UTF-8');

        fetch('/api/v1/contacts', {
            method: 'POST',
            headers: headers,
            body: JSON.stringify(status)
        }).then(data => console.log(data));
    }

    render() {
        return (
            <div>
                <h2>Add contact: </h2>
                <form method='post' onSubmit={this.handleSubmit}>
                    <input type='text' name='name' placeholder='Name' onChange={this.handleOnChange}/>
                    <input type='text' name='age' placeholder='Age'/>
                    <button type='submit'>Add Contact</button>
                </form>
            </div>
        );
    }
}

export default AddContact;