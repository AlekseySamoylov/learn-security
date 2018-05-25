import {GET_ALL_USERS} from "../actions/admin-actions";

export default function adminReducer(state = '', {type, payload}) {
    switch (type) {
        case GET_ALL_USERS:
            console.log('redux ' + payload.users[0].email);
            return payload.users;
        default:
            return state;
    }
}
