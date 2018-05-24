import React from 'react';
import {Route, Switch} from 'react-router-dom';
import RegistrationFrom from '../components/registration/RegistrationForm';
import Portal from '../components/portal/Portal';
import UserTable from '../components/users/UserTable';
import NoResult from '../components/NoResult';
import MainHeader from '../components/header/MainHeader';
import LoginForm from '../components/login/LoginForm';

const UIRouter = props => (
    <div>
        <MainHeader/>
        <main>
            <Switch>
                <Route exact path='/portal' component={Portal}/>
                <Route exact path='/admin' component={UserTable}/>
                <Route exact path='/registration' component={RegistrationFrom}/>
                <Route exact path='/login' component={LoginForm}/>
                <Route component={NoResult}/>
            </Switch>
        </main>
    </div>
);

module.exports = UIRouter;
