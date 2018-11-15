import {PRODUCTS_LOADED} from "./actions";

export const loadProducts = () => dispatch => {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('charset', 'UTF-8');

    fetch('/api/v1/products', {
        method: 'GET',
        headers: headers
    }).then(data => data.json())
        .then(data => dispatch({type: PRODUCTS_LOADED, payload: data}))
};