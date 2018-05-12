import React, {Component, PropTypes} from 'react';

class User extends Component {
    constructor(props) {
        super(props);

        this.state = {
            email: this.props.user.email,
            name: this.props.user.name,
            password: this.props.user.password
        };
    }

    render() {
        return (
            <tr>
                <td>{this.state.email}</td>
                <td>{this.state.name}</td>
                <td>{this.state.password}</td>
            </tr>
        )
    }
}

export default User;
