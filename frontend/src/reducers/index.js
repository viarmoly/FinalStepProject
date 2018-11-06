import combineReducers from "redux/src/combineReducers";
import { reducer as formReducer } from 'redux-form'
import usersReducer from "./usersReducer";

const allReducers = combineReducers({
  users: usersReducer,
  form: formReducer
});

export default allReducers
