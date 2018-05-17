import axios from 'axios';

export const DELETE_USER = 'DELETE_USER';

export function deleteUser() {
    return {type: DELETE_USER};
}

export function deleteUserRequest(userId) {
    axios.delete(`/api/users/${userId}`)
        .then(response => {
            console.log(response)
        })
        .catch(response => {
            console.log(response)
        })
}
