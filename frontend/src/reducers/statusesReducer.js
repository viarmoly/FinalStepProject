const initialState = [];

function statusesReducer (state = initialState, action){
  switch(action.type) {
    case 'STATUSES_LOADED':
      return [...action.payload];
    default:
      return state;
  }
}

export default statusesReducer;