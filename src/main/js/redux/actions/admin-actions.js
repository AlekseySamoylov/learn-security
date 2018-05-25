import client from "../../client";

export const GET_ALL_USERS = 'admin:getAllUsers';


export function showAllUsers(users) {
    return {
        type: GET_ALL_USERS,
        payload: {
            users: users
        }
    }
}

export function getAllUsers() {
    return dispatch => {
        client({method: 'GET', path: '/api/users'}).done(response => {
            console.log(response.entity._embedded.users);
            dispatch(showAllUsers(response.entity._embedded.users));
        });
    }
}
