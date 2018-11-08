import {CONTACTS_LOADED} from "./actions";

export const loadContacts= () => dispatch => {
  fetch('/api/v1/contacts')
      .then(data => data.json())
      .then(data => dispatch({type:CONTACTS_LOADED, payload: data}))
};