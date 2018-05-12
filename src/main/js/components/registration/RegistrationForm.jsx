import React, {Component} from 'react';
import Grid from 'react-bootstrap/lib/Grid';
import FormGroup from 'react-bootstrap/lib/FormGroup';
import FormControl from 'react-bootstrap/lib/FormControl';
import ControlLabel from 'react-bootstrap/lib/ControlLabel';
import Button from 'react-bootstrap/lib/Button';

export class RegistrationForm extends Component {
    render() {
        return (
            <div>
                <Grid>
                    <form id="myForm">
                        <FormGroup>
                            <ControlLabel htmlFor="email">Enter Email</ControlLabel>
                            <FormControl id="email" name="email" type="email"
                                         value={this.state.email}
                                         onChange={this.handlePhraseChange}
                            />
                            <ControlLabel htmlFor="name">Enter Name</ControlLabel>
                            <FormControl id="name" name="name" type="name"
                                         value={this.state.name}
                                         onChange={this.handleTranslationChange}
                            />
                            <ControlLabel htmlFor="password">Enter Password</ControlLabel>
                            <FormControl id="password" name="password" type="password"
                                         value={this.state.password}
                                         onChange={this.handleTranslationChange}
                            />
                            <Button onClick={this.handleSubmit}>Registration!</Button>
                        </FormGroup>

                    </form>
                </Grid>
            </div>
        )
    }
}

export default RegistrationForm;
