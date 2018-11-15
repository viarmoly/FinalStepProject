const initialState = [];

function productsReducer (state = initialState, action){
  switch(action.type) {
    case 'PRODUCTS_LOADED':
      return [...action.payload];
    default:
      return state;
  }
}

export default productsReducer;