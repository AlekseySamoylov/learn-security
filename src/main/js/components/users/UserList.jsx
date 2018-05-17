import React, {Component} from 'react';
import User from "./User";
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import {Grid} from "react-bootstrap";
import {deleteUserRequest} from "../../redux/actions/userActions";
import Button from "react-bootstrap/es/Button";

function onRowSelect(row, isSelected, e) {
    let rowStr = '';
    for (const prop in row) {
        rowStr += prop + ': "' + row[prop] + '"';
    }
    console.log(e);
    alert(`is selected: ${isSelected}, ${rowStr}`);
}

function onSelectAll(isSelected, rows) {
    alert(`is select all: ${isSelected}`);
    if (isSelected) {
        alert('Current display and selected data: ');
    } else {
        alert('unselect rows: ');
    }
    for (let i = 0; i < rows.length; i++) {
        alert(rows[i].id);
    }
}

const selectRowProp = {
    mode: 'checkbox',
    clickToSelect: true,
    onSelect: onRowSelect,
    onSelectAll: onSelectAll
};


export class UserList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
        console.log('Hello' + this.state.users);
        deleteUserRequest(2);
    }

    render() {
        let counter = 0;
        const users = this.props.users.map(user =>
            new User(counter++, user.id, user.email, user.firstName, user.password));

        return (
            <div>
                <Grid>
                    <BootstrapTable data={users} selectRow={selectRowProp} version='4'>
                        <TableHeaderColumn hidden={true} isKey dataField='id'>Id</TableHeaderColumn>
                        <TableHeaderColumn dataField='email'>Email</TableHeaderColumn>
                        <TableHeaderColumn dataField='firstName'>First Name</TableHeaderColumn>
                        <TableHeaderColumn dataField='password'>Password</TableHeaderColumn>
                    </BootstrapTable>
                    <br/>
                    <Button onClick={deleteUserRequest(3)}>Delete selected</Button>
                </Grid>
            </div>
        )
    }
}

export default UserList;

