import { READ_ALL_PRODUCTS, ADD_TO_CART, REMOVE_ALL_FROM_CART, REMOVE_ONE_FROM_CART, CLEAR_CART, NO_PRODUCTS } from "../types"

export const readAllProducts = (data) => ({ 
    type:READ_ALL_PRODUCTS, 
    payload: data 
});

export const addToCart = (id) => ({
    type: ADD_TO_CART,
    payload: id
})

export const deleteFromCart = (id, all = false) => 
    all 
    ? {type: REMOVE_ALL_FROM_CART, payload: id}
    : {type: REMOVE_ONE_FROM_CART, payload: id};
    
export const clearCart = () => ({type: CLEAR_CART});

export const noAction = (data) => ({ type:NO_PRODUCTS });
