const CartItem = ({ data, deleteOneFromCart, deleteAllFromCart }) => {
    let { id, name, price, quantity } = data;

    return (
        <div className="cart-item">
            <h4>{name}</h4>
            <h5>${price}.00 x {quantity} = ${price * quantity}.00</h5>
            <div>
                <button onClick={() => deleteOneFromCart(id)}>Eliminar Uno</button>
                <button onClick={() => deleteAllFromCart(id, true)}>Eliminar Todos</button>
            </div>
        </div>
    );
};

export default CartItem;