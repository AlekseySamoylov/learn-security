import {DELETE_USER} from "../actions/userActions";

export default function userReducer(state = {}, action) {
    switch (action.type) {
        // case 'REGISTRATION_ERROR': {
        //     return Object.assign({}, state, {
        //         registrationError: action.payload,
        //         loggedIn: false
        //     });
        // }
        //
        // case 'LOGIN_ERROR': {
        //     return Object.assign({}, state, {
        //         loginError: action.payload,
        //         loggedIn: false
        //     });
        // }
        //
        // case 'LOGIN_SUCCESS': {
        //     return Object.assign({}, state, {
        //         loggedIn: true
        //     });
        // }

        case DELETE_USER: {
            return {value: state.value + 1};
        }

        default:
            return state;
    }
}
