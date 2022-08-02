import React from 'react'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

import TeoriaRedux from "../components/TeoriaRedux/TeoriaRedux";
import Contador from "../components/Contador/Contador";
import ShoppingCart from '../components/ShoppingCart/ShoppingCart';
import CrudApi from '../components/CrudProducts/CrudApi';


const AppRoutes = () => {
    return (
        <Router>
                <h1>Redux</h1>
                <nav className="nav-links">
                    <Link to="/">Teoria Redux</Link>
                    <Link to="/contador">Contador</Link>
                    <Link to="/shoppingcart">Shopping Cart</Link>
                    <Link to="/crud">Manage Products</Link>
                </nav>
                <hr />
                <Routes>
                    <Route path="/" element={<TeoriaRedux />}/>
                    <Route path="/contador" element={<Contador />} />
                    <Route path="/shoppingcart" element={<ShoppingCart />} />
                    <Route path="/crud" element={<CrudApi />} />
                </Routes>
            
        </Router>
    )
}   
export default AppRoutes;