import React, {Component} from 'react';
import Grid from 'react-bootstrap/lib/Grid';
import FormGroup from 'react-bootstrap/lib/FormGroup';
import FormControl from 'react-bootstrap/lib/FormControl';
import ControlLabel from 'react-bootstrap/lib/ControlLabel';
import Button from 'react-bootstrap/lib/Button';


class LoginForm extends Component {
    render() {
        return (
            <div>
                <Grid>

                    <form action="/login" method="post">
                        <FormGroup>
                            <ControlLabel htmlFor="username">Username</ControlLabel>
                            <FormControl id="username" name="username" type="text"/>
                            <ControlLabel htmlFor="password">Password</ControlLabel>
                            <FormControl id="password" name="password" type="password"/>
                            <br/>
                            <Button type="submit">Login</Button>
                        </FormGroup>

                    </form>
                </Grid>
            </div>
        );
    }
}

export default LoginForm;
