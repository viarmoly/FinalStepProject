import combineReducers from "redux/src/combineReducers";
import { reducer as formReducer } from 'redux-form'
import usersReducer from "./usersReducer";
import userRolesReducer from "./userRolesReducer";
import productsReducer from "./productsReduces";
import contactsReducer from "./contactsReducer";

const allReducers = combineReducers({
  users: usersReducer,
  userRoles: userRolesReducer,
  products: productsReducer,
  contacts: contactsReducer,
  form: formReducer
});

export default allReducers
