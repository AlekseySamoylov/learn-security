import thunk from 'redux-thunk';
import productsReducer from "../reducers/products-reducer";
import userReducer from "../reducers/user-reducer";
import adminReducer from "../reducers/admin-reducer";
import {applyMiddleware, combineReducers, compose, createStore} from "redux";

const allReducers = combineReducers({
    products: productsReducer,
    user: userReducer,
    admin: adminReducer
});


const allStoreEnhancers = compose(
    applyMiddleware(thunk),
    window.devToolsExtension && window.devToolsExtension()
);

// const store = createStore(allReducers, {}, applyMiddleware(thunkMiddleware));

const store = createStore(
    allReducers,
    {
        products: [{name: 'iPhone'}],
        user: 'Michael'
    },
    allStoreEnhancers
);

const updateUserAction = {
    type: 'updateUser',
    payload: {
        user: 'John',
        users: {
            name: 'Vasia'
        }
    }
};

store.dispatch(updateUserAction);


export default store;
