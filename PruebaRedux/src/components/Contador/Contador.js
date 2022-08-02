import React from 'react'
import { useSelector, useDispatch } from 'react-redux';
import{sumar5, restar5, sumar, restar, reset} from '../../actions/contadorActions';

const Contador = () => {
    const state = useSelector(state => state);
    const dispatch = useDispatch();

    
    return (
        <div className='cuerpo-box contador'>
            <h3>Contador REDUX</h3>
            <nav>
                <button onClick={()=>dispatch(sumar5())}>+5</button>
                <button onClick={()=>dispatch(restar5())}>-5</button>
                <button onClick={()=>dispatch(sumar())}>+1</button>
                <button onClick={()=>dispatch(restar())}>-1</button>
                <button onClick={()=>dispatch(reset())}>RESET</button>
            </nav>
            <h3>{state.contador}</h3>
        </div>
    )
}

export default Contador