import React from "react";

const CrudTableRow = ({ el, setDataToEdit, deleteData }) => {
    let { name, price, id } = el;

    return (
        <tr>
            <td>{name}</td>
            <td>{price}</td>
        <td>
            <button className="crud-table-button" onClick={() => setDataToEdit(el)}>Editar</button>
            <button className="crud-table-button" onClick={() => deleteData(id)}>Eliminar</button>
        </td>
        </tr>
    );
};

export default CrudTableRow;