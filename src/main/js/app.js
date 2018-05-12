'use strict';

// tag::vars[]
import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import client from './client';
import UserList from './components/UserList.jsx';

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {users: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/users'}).done(response => {
            this.setState({users: response.entity._embedded.users});
        });
    }

    render() {
        return (
            <UserList users={this.state.users}/>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('react')
);
