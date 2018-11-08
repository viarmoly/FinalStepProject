import combineReducers from "redux/src/combineReducers";
import { reducer as formReducer } from 'redux-form'
import usersReducer from "./usersReducer";
import userRolesReducer from "./userRolesReducer";
import productsReducer from "./productsReduces";

const allReducers = combineReducers({
  users: usersReducer,
  userRoles: userRolesReducer,
  products: productsReducer,
  form: formReducer
});

export default allReducers
