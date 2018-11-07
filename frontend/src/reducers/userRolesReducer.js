const initialState = [];

function userRolesReducer (state = initialState, action){
  switch(action.type) {
    case 'USERROLES_LOADED':
      return [...action.payload];
    default:
      return state;
  }
}

export default userRolesReducer;