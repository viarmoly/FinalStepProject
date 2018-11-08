import {STATUSES_LOADED} from "./actions";

export const loadStatuses= () => dispatch => {
  fetch('/api/v1/statuses')
      .then(data => data.json())
      .then(data => dispatch({type:STATUSES_LOADED, payload: data}))
};