import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router} from "react-router-dom";
import UIRouter from './router/UIRouter';

const browserHistory = Router.browserHistory;


function loadApplication() {

    ReactDOM.hydrate(
        <Router history={browserHistory}>
            <UIRouter/>
        </Router>,
        document.getElementById('react'));

}

loadApplication();
