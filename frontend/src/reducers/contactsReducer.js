const initialState = [];

function contactsReducer (state = initialState, action){
  switch(action.type) {
    case 'CONTACTS_LOADED':
      return [...action.payload];
    default:
      return state;
  }
}

export default contactsReducer;