const initialState = [];

function contactLoadingReducer (state = initialState, action){
  switch(action.type) {
    case 'CONTACT_LOADING':
      return [...action.payload];
    default:
      return state;
  }
}

export default contactLoadingReducer;