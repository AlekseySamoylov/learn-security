import React, {Component} from 'react';
import {connect} from 'react-redux';
import {updateUser} from '../../redux/actions/user-actions';
import {Button, FormControl, FormGroup, Grid} from "react-bootstrap";

export class Portal extends Component {

    constructor(props) {
        super(props);
        this.state = {
            name: ''
        };
        this.handleNameChange = this.handleNameChange.bind(this);
        this.onUpdateUser = this.onUpdateUser.bind(this);
        this.liveUpdateUser = this.liveUpdateUser.bind(this);
    }

    handleNameChange(e) {
        this.setState({
            name: e.target.value
        });

    };

    onUpdateUser() {
        this.props.onUpdateUser(this.state.name);
    }

    liveUpdateUser(event) {
        this.props.onUpdateUser(event.target.value);
    }

    render() {
        return (
            <div>
                <Grid>
                    <p>
                        Get started
                    </p>
                    <FormGroup>
                        <FormControl
                            type="text"
                            value={this.state.name}
                            onChange={this.handleNameChange}
                        />
                        <FormControl
                            type="text"
                            onChange={this.liveUpdateUser}
                        />
                    </FormGroup>
                    <Button onClick={this.onUpdateUser}>
                        Update User
                    </Button>
                    <p>{this.props.user}</p>
                </Grid>
            </div>
        )
    }
}

const mapStateToProps = state => ({
    products: state.products,
    user: state.user
});

const mapActionsToProps = {
    onUpdateUser: updateUser
};

export default connect(mapStateToProps, mapActionsToProps)(Portal);
