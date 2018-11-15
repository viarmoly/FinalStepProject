import {USERROLES_LOADED} from "./actions";

export const loadUserRoles = () => dispatch => {
  fetch('/api/v1/userRoles')
      .then(data => data.json())
      .then(data => dispatch({type:USERROLES_LOADED, payload: data}))
};