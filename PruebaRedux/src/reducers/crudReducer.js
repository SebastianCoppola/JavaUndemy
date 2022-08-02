import { READ_ALL_DATA, CREATE_DATA, DELETE_DATA, UPDATE_DATA, NO_DATA } from "../types";

export const initialState = { products: [] };

export function crudReducer(state = initialState, action) {
    switch (action.type) {
        case READ_ALL_DATA: {
            return { ...state, products: action.payload.map((data) => data) };
        }
        case CREATE_DATA: {
            return { ...state, products: [...state.products, action.payload] };
        }
        case UPDATE_DATA: {
            let newData = state.products.map((el) =>
                el.id === action.payload.id ? action.payload : el
            );
            return { ...state, products: newData };
        }
        case DELETE_DATA: {
            let newData = state.products.filter((el) => el.id !== action.payload);
            return { ...state, products: newData };
        }
        case NO_DATA:
            return initialState;
        default:
            return state;
    }
}