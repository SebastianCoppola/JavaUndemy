import { combineReducers } from "redux";
import contadorReducer from "./contadorReducer";
import { crudReducer } from "./crudReducer";
import { shoppingReducer } from "./shoppingReducer";


const reducers = combineReducers({
    contador:contadorReducer,
    shopping:shoppingReducer,
    crud: crudReducer
});

export default reducers;