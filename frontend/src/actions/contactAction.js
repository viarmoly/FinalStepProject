import {CONTACT_LOADED} from "./actions";

export const loadContact= () => dispatch => {
  fetch('/api/v1/contacts/:id')
      .then(data => data.json())
      .then(data => dispatch({type:CONTACT_LOADED, payload: data}))
};