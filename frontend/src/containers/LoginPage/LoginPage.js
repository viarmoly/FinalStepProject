import React, {Component} from 'react';
import {FormGroup, FormControl, ControlLabel, Panel} from 'react-bootstrap';
import LoaderButton from '../../components/LoaderButton/LoaderButton';
import '../../scss/content/loginpage/_loginPage.scss';


class LoginPage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            isLoading: false,
            username: '',
            password: ''

        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }

    validateForm() {
        return this.state.username.length > 0 && this.state.password.length > 0;
    }

    handleChange = event => {
        this.setState({
            [event.target.id]: event.target.value
        });
    }

    handleSubmit = async event => {
        event.preventDefault();

        try {
            this.setState({isLoading: true});
            this.props.history.push("/users");
        } catch (e) {
            alert(e.message);
            this.setState({isLoading: false});
        }
    }

    render() {
        return (
            <div className="Login">
                <Panel>
                    <Panel.Heading>
                        <Panel.Title componentClass="h1">Авторизация</Panel.Title>
                    </Panel.Heading>
                    <form onSubmit={this.handleSubmit}>
                        <FormGroup controlId="username" bsSize="large">
                            <ControlLabel>Имя пользователя</ControlLabel>
                            <FormControl
                                autoFocus
                                type="username"
                                value={this.state.username}
                                onChange={this.handleChange}
                            />
                        </FormGroup>
                        <FormGroup controlId="password" bsSize="large">
                            <ControlLabel>Пароль</ControlLabel>
                            <FormControl
                                value={this.state.password}
                                onChange={this.handleChange}
                                type="password"
                            />
                        </FormGroup>
                        <LoaderButton
                            block
                            bsSize="large"
                            enabled={!this.validateForm()}
                            type="submit"
                            isLoading={this.state.isLoading}
                            text="Войти"
                            loadingText="Вход в систему…"
                        />
                    </form>
                </Panel>
            </div>
        );
    }
}

export default LoginPage;