import combineReducers from "redux/src/combineReducers";
import { reducer as formReducer } from 'redux-form'
import usersReducer from "./usersReducer";
import userRolesReducer from "./userRolesReducer";

const allReducers = combineReducers({
  users: usersReducer,
  userRoles: userRolesReducer,
  form: formReducer
});

export default allReducers
