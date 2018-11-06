import {USERS_LOADED} from "./index";

export const loadUsers = () => dispatch => {
  fetch('http://localhost:9000/api/v1/users')
      .then(data => data.json())
      .then(data => dispatch({type:USERS_LOADED, payload: data}))
};