import {USERS_LOADED} from "./actions";

export const loadUsers = () => dispatch => {
  fetch('/api/v1/users', {
    headers: {
      'Content-Type': 'application/json',
      'Charset': 'UTF-8'
    }
  },)
      .then(data => data.json())
      .then(data => dispatch({type: USERS_LOADED, payload: data}))
};