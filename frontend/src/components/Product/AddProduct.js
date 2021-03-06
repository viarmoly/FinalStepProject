import React, {Component} from 'react'

class AddStatus extends Component {
    constructor(props) {
        super(props);

        this.state = {
            name: ""
        };

        this.handleOnChange = this.handleOnChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleOnChange(event) {
        this.setState({
            name: event.target.value
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        let status = this.state;

        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        headers.append('charset', 'UTF-8');

        fetch('/api/v1/products', {
            method: 'POST',
            headers: headers,
            body: JSON.stringify(status)
        }).then(data => console.log(data));
    }

    render() {
        return (
            <div>
                <h2>Add product page</h2>
                <form method='post' onSubmit={this.handleSubmit}>
                    <input type="text" name="name" placeholder="Product name:" onChange={this.handleOnChange}/>
                    <button type='submit'>Add Product</button>
                </form>
            </div>
        )
    }
}

export default AddStatus;