import React from "react";
import CrudTableRow from "./CrudTableRow";

const CrudTable = ({ data, setDataToEdit, deleteData }) => {
    return (
        <div>
            <h3>All Products</h3>
            <table className="crud-table">
                <thead>
                    <tr className="crud-table-row1">
                        <th className="crud-table-col1">Name</th>
                        <th className="crud-table-col2">Price</th>
                        <th className="crud-table-col3"></th>
                    </tr>
                </thead>
                <tbody>
                    {data.length > 0 ? (
                        data.map((item) => (
                            <CrudTableRow
                                key={item.id}
                                el={item}
                                setDataToEdit={setDataToEdit}
                                deleteData={deleteData}
                            />
                        ))
                    ) : (
                        <tr>
                            <td colSpan="3">No data.</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    );
};

export default CrudTable;