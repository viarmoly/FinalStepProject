const initialState = [];

function contactReducer (state = initialState, action){
  switch(action.type) {
    case 'CONTACT_LOADED':
      return [...action.payload];
    default:
      return state;
  }
}

export default contactReducer;