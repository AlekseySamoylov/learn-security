import {applyMiddleware, combineReducers, createStore} from 'redux';
import thunkMiddleware from 'redux-thunk';
import userReducer from '../reducers/UserReducer';

const combinedReducer = combineReducers({
    user: userReducer,
    dashboards: dashboardsReducer
});

const store = createStore(combinedReducer, {}, applyMiddleware(thunkMiddleware));

export default store;
