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
                            <ControlLabel htmlFor="phrase">Enter phrase in Russian</ControlLabel>
                            <FormControl id="phrase" name="phrase" type="text"
                                         value={this.state.phrase}
                                         onChange={this.handlePhraseChange}
                            />
                            <ControlLabel htmlFor="translation">Enter translation in English</ControlLabel>
                            <FormControl id="translation" name="translation" type="text"
                                         value={this.state.translation}
                                         onChange={this.handleTranslationChange}
                            />
                            <Button onClick={this.handleSubmit}>Send data!</Button>
                        </FormGroup>

                    </form>
                </Grid>
            </div>
        )
    }
}

export default RegistrationForm;
