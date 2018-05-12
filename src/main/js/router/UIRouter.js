import React from 'react';
import {Route, Switch} from "react-router-dom";
import ImpactDashboard from '../ui/dashboards/impact/ImpactDashboard';
import EmployeeProfile from '../ui/profile/EmployeeProfile';
import NoResult from '../ui/NoResult';

const UIRouter = props => (
    <Switch>
        <Route exact path='/dashboards/impact' component={ImpactDashboard}/>
        <Route exact path='/dashboards/impact/2016' component={ImpactDashboard}/>
        <Route exact path='/dashboards/impact/2017' component={ImpactDashboard}/>
        <Route exact path='/:name' component={EmployeeProfile}/>
        <Route component={NoResult}/>
    </Switch>
);

module.exports = UIRouter;