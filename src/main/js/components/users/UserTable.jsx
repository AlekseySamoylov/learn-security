import React, {Component} from 'react';
import UserList from './UserList';
import {connect} from 'react-redux';
import {getAllUsers} from '../../redux/actions/admin-actions';
import './style.css';

class UserTable extends Component {

    constructor(props) {
        super(props);
        this.state = {users: []};
    }

    // Default react method to do something when component is active
    // componentDidMount() {
    //     client({method: 'GET', path: '/api/users'}).done(response => {
    //         this.setState({users: response.entity._embedded.users});
    //     });
    // }

    // Default react method to do something when component is active
    componentDidMount() {

        this.props.onGetAllUsers();
        // client({method: 'GET', path: '/api/users'}).done(response => {
        //     this.setState({users: response.entity._embedded.users});
        // });
    }

    render() {
        return (
            <UserList users={this.state.users}/>
        )
    }
}

const mapStateToProps = state => ({
    users: state.users
});

const mapActionsToProps = {
    onGetAllUsers: getAllUsers
};

export default connect(mapStateToProps, mapActionsToProps)(UserTable);

