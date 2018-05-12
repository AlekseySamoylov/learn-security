import React from 'react';
import {Route, Switch} from "react-router-dom";
import RegistrationFrom from '../components/registration/RegistrationForm';
import UserTable from '../components/users/UserTable';
import NoResult from '../components/NoResult';

const UIRouter = props => (
    <Switch>
        <Route exact path='/admin' component={UserTable}/>
        <Route exact path='/' component={RegistrationFrom}/>
        <Route component={NoResult}/>
    </Switch>
);

module.exports = UIRouter;
