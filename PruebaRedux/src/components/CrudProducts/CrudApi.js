import React, { useEffect, useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { readAllAction, noAction, createAction, updateAction, deleteAction } from "../../actions/crudActions";
import { helpHttp } from "../../helpers/helpHttp";

//COMPONENTS:
import CrudForm from "./CrudForm";
import CrudTable from "./CrudTable";
import Loader from "../Common/Loader";

const CrudApi = () => {
    const state = useSelector(state => state);
    const { products } = state.crud;
    const dispatch = useDispatch();
    const [loading, setLoading] = useState(true);
    const [dataToEdit, setDataToEdit] = useState(null);
    const [error, setError] = useState(null);
    let api = helpHttp();
    let url = "http://localhost:5001/products";

    useEffect(() => {
        api.get(url)
            .then((res) => {
                if (!res.err) {
                    dispatch(readAllAction(res));
                    setError(null);
                } else {
                    dispatch(noAction());
                    setError(res);
                }
                setLoading(false);
        });
    }, []);

    const createData = (data) => {
        data.id = Date.now();
        let options = {
            body: data,
            headers: { "content-type": "application/json" },
        };
        api.post(url, options)
            .then((res) => {
                if (!res.err) {
                    dispatch(createAction(res));
                } else {
                    setError(res);
                }
            });
    };

    const updateData = (data) => {
        let endpoint = `${url}/${data.id}`;
        let options = {
            body: data,
            headers: { "content-type": "application/json" },
        };
        api.put(endpoint, options)
            .then((res) => {
                if (!res.err) {
                    dispatch(updateAction(res));
                } else {
                    setError(res);
                }
            });
    };

    const deleteData = (id) => {
        let isDelete = window.confirm(
            `¿Estás seguro de eliminar el registro con el id '${id}'?`
        );
        if (isDelete) {
            let endpoint = `${url}/${id}`;
            let options = {
                headers: { "content-type": "application/json" },
            };
            api.del(endpoint, options).then((res) => {
                if (!res.err) {
                    dispatch(deleteAction(id));
                } else {
                    setError(res);
                }
            });
        } else {
            return;
        }
    };

    return (
        <div className="cuerpo-box">
            <article className="body-box">
                <CrudForm
                createData={createData}
                updateData={updateData}
                dataToEdit={dataToEdit}
                setDataToEdit={setDataToEdit}
                />
                { loading ? <Loader /> : 

                products && (
                <CrudTable
                data={products}
                setDataToEdit={setDataToEdit}
                deleteData={deleteData}
                />
                )}
            </article>
        </div>
    );
};

export default CrudApi;