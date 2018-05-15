import React, {Component} from 'react';
import User from "./User";
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import {Grid} from "react-bootstrap";

export class UserList extends Component {
    render() {
        let counter = 0;
        const users = this.props.users.map(user =>
            new User(counter++, user.email, user.firstName, user.password));
        return (
            <div>
                <Grid>
                    <BootstrapTable data={users} version='4'>
                        <TableHeaderColumn hidden={true} isKey dataField='id'>Id</TableHeaderColumn>
                        <TableHeaderColumn dataField='email'>Email</TableHeaderColumn>
                        <TableHeaderColumn dataField='firstName'>First Name</TableHeaderColumn>
                        <TableHeaderColumn dataField='password'>Password</TableHeaderColumn>
                    </BootstrapTable>
                </Grid>
            </div>
        )
    }
}

export default UserList;

