import React, {Component} from 'react';
import Grid from 'react-bootstrap/lib/Grid';
import FormGroup from 'react-bootstrap/lib/FormGroup';
import FormControl from 'react-bootstrap/lib/FormControl';
import ControlLabel from 'react-bootstrap/lib/ControlLabel';
import Button from 'react-bootstrap/lib/Button';

export class RegistrationForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            user: {
                email: '',
                firstName: '',
                rawPassword: ''
            }
        };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleEmailChange = this.handleEmailChange.bind(this);
        this.handleNameChange = this.handleNameChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
    }

    handleEmailChange(e) {
        this.setState({
            user: {
                email: e.target.value,
                firstName: this.state.user.firstName,
                rawPassword: this.state.user.rawPassword
            }
        });
    };

    handleNameChange(e) {
        this.setState({
            user: {
                email: this.state.user.email,
                firstName: e.target.value,
                rawPassword: this.state.user.rawPassword
            }
        });

    };

    handlePasswordChange(e) {
        this.setState({
            user: {
                email: this.state.user.email,
                firstName: this.state.user.firstName,
                rawPassword: e.target.value
            }
        });
    };

    handleSubmit() {
        axios.post('/api/user', this.state.user)
            .then(response => {
                console.log(response);
            })
            .catch(error => {
                console.log(error)
            });
        // fetch('/api/user', {
        //     method: 'POST',
        //     headers: {
        //         'Accept': '*/*',
        //         'Content-Type': 'application/json'
        //     },
        //     credentials: 'same-origin',
        //     body: JSON.stringify(this.state.user)
        // }).then(() => {
        //     console.log('success');
        // }).catch(function (error) {
        //     console.log(error);
        // });

    }

    render() {
        return (
            <div>
                <Grid>
                    <form id="myForm">
                        <FormGroup>
                            <ControlLabel htmlFor="email">Enter Email</ControlLabel>
                            <FormControl id="email" name="email" type="email"
                                         value={this.state.email}
                                         onChange={this.handleEmailChange}
                            />
                            <ControlLabel htmlFor="name">Enter Name</ControlLabel>
                            <FormControl id="firstName" name="firstName" type="text"
                                         value={this.state.firstName}
                                         onChange={this.handleNameChange}
                            />
                            <ControlLabel htmlFor="password">Enter Password</ControlLabel>
                            <FormControl id="password" name="password" type="password"
                                         value={this.state.rawPassword}
                                         onChange={this.handlePasswordChange}
                            />
                            <br/>
                            <Button onClick={this.handleSubmit}>Registration!</Button>
                        </FormGroup>
                    </form>
                </Grid>
            </div>
        )
    }
}

export default RegistrationForm;
