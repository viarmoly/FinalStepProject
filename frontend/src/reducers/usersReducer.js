const initialState = [];

function usersReducer (state = initialState, action){
  switch(action.type) {
    case 'USERS_LOADED':
      return [...action.payload];
    default:
      return state;
  }
}

export default usersReducer;