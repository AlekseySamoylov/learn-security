import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router} from "react-router-dom";
import UIRouter from './router/UIRouter';
import {combineReducers, createStore} from 'redux';
import {Provider} from 'react-redux';
import productsReducer from './redux/reducers/products-reducer'
import userReducer from './redux/reducers/user-reducer'

const browserHistory = Router.browserHistory;

const allReducers = combineReducers({
    products: productsReducer,
    user: userReducer
});

const store = createStore(
    allReducers,
    {
        products: [{name: 'iPhone'}],
        user: 'Michael'
    },
    window.devToolsExtension && window.devToolsExtension()
);

console.log(store.getState());

const updateUserAction = {
    type: 'updateUser',
    payload: {
        user: 'John'
    }
};

store.dispatch(updateUserAction);


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
