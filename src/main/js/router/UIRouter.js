import React from 'react';
import {Route, Switch} from "react-router-dom";
import RegistrationFrom from '../components/registration/RegistrationForm';
import UserTable from '../components/users/UserTable';
import NoResult from '../components/NoResult';
import MainHeader from "../components/header/MainHeader";

const UIRouter = props => (
    <div>
        <MainHeader/>
        <main>
            <Switch>
                <Route exact path='/admin' component={UserTable}/>
                <Route exact path='/registration' component={RegistrationFrom}/>
                <Route component={NoResult}/>
            </Switch>
        </main>
    </div>
);

module.exports = UIRouter;
