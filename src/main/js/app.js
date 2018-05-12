import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import UserTable from './components/users/UserTable';

class App extends Component {
    render() {
        return (
            <UserTable/>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('react')
);
