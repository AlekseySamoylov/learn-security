import React, {Component} from 'react';
import User from "./User";

export class UserList extends Component {
    render() {
        const users = this.props.users.map(user =>
            <User key={user._links.self.href} user={user}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>Email</th>
                    <th>Name</th>
                    <th>Password</th>
                </tr>
                {users}
                </tbody>
            </table>
        )
    }
}

export default UserList;

