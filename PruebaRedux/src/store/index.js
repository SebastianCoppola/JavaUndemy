import { applyMiddleware, createStore } from "redux";
import reducers from '../reducers/index';
import thunk from 'redux-thunk';

const store = createStore(reducers,applyMiddleware(thunk));

store.subscribe( () => console.log(store) ); //cada vez que se actualice un ESTADO, se ejecutara esta funcion.

export default store;