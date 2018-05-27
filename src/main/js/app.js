import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router} from "react-router-dom";
import UIRouter from './router/UIRouter';
import {Provider} from 'react-redux';
import store from "./redux/store/store";

const browserHistory = Router.browserHistory;

function loadApplication() {

    ReactDOM.hydrate(
        <Provider store={store}>
            <Router history={browserHistory}>
                <UIRouter/>
            </Router>
        </Provider>,
        document.getElementById('react'));

}

loadApplication();
