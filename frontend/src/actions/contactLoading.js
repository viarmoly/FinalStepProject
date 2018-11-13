import {CONTACT_LOADED, CONTACT_LOADING} from "./actions";

export const contactLoading = (dispatch) => () => {
  dispatch({type: CONTACT_LOADING, payload: true});

  return fetch('/api/v1/contact/')
      .then(data => data.json())
      .then(data => {
        dispatch({type: CONTACT_LOADED, payload: data})
            .then(dispatch({type: CONTACT_LOADING, payload: false}))
      })};