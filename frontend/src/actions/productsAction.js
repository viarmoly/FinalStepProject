import {PRODUCTS_LOADED} from "./actions";

export const loadProducts = () => dispatch => {
  fetch('/api/v1/products')
      .then(data => data.json())
      .then(data => dispatch({type:PRODUCTS_LOADED, payload: data}))
};