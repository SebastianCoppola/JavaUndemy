//IMPORTS:
import { useSelector, useDispatch } from "react-redux";
import { useEffect, useState } from "react";
import { readAllProducts, addToCart, clearCart, deleteFromCart, noAction } from "../../actions/shoppingActions";
import { helpHttp } from "../../helpers/helpHttp";
//COMPONENTS:
import CartItem from "./CartItem";
import ProductItem from "./ProductItem";
import Loader from "../Common/Loader";

const ShoppingCart = () => {
    const state = useSelector (state => state);
    const {cart, products} = state.shopping;
    const dispatch = useDispatch();
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    
    let api = helpHttp();
    let url = "http://localhost:5001/products";

    useEffect(() => {
        setLoading(true);
        api.get(url)
            .then((res) => {
                if (!res.err) {
                    dispatch(readAllProducts(res));
                    setError(null);
                } else {
                    dispatch(noAction());
                    setError(res);
                }
                setLoading(false);
            });
    }, [dispatch]);

    return (
        <div className="cuerpo-box shop">
            <h3>Productos</h3>
            <article className="product-box">
                { loading ? <Loader /> :
                    products.map((product) => (
                        <ProductItem 
                        key={product.id} 
                        data={product} 
                        addToCart={()=> dispatch(addToCart(product.id))} 
                        />
                    ))
                }
            </article>
            <h3>Shopping Cart</h3>
            <button className="shop-buttom" onClick={()=>dispatch(clearCart())}>Clear Cart</button>
            <article className="cart-box">
                {
                    cart.map((item, index) => (
                        <CartItem 
                        key={index} 
                        data={item} 
                        deleteOneFromCart={()=>dispatch(deleteFromCart(item.id))} 
                        deleteAllFromCart={()=>dispatch(deleteFromCart(item.id,true))} 
                        />
                    ))
                }
            </article>
        </div>
    );
};

export default ShoppingCart;