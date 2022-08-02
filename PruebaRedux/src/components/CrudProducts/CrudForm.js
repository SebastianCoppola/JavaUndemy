import React, { useState, useEffect } from "react";

const initialForm = {
    name: "",
    price: "",
    id: null,
};

const CrudForm = ({ createData, updateData, dataToEdit, setDataToEdit }) => {
    const [form, setForm] = useState(initialForm);

    useEffect(() => {
        if (dataToEdit) {
            setForm(dataToEdit);
        } else {
            setForm(initialForm);
        }
    }, [dataToEdit]);

    const handleChange = (e) => {
        setForm({
            ...form,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!form.name || !form.price) {
            alert("You need to complete all the fields.");
            return;
        }
        if (form.id === null) {
            createData(form);
        } else {
            updateData(form);
        }
        handleReset();
    };

    const handleReset = (e) => {
        setForm(initialForm);
        setDataToEdit(null);
    };

    return (
        <div className="crud-form">
            <h3>{dataToEdit ? "Edit Product:" : "Add Product:"}</h3>
            <form onSubmit={handleSubmit}>
                <input
                    className="crud-form-input"
                    type="text"
                    name="name"
                    placeholder="Name"
                    onChange={handleChange}
                    value={form.name}
                />
                <input
                    className="crud-form-input"
                    type="text"
                    name="price"
                    placeholder="Price"
                    onChange={handleChange}
                    value={form.price}
                />
                <input className="crud-form-button" type="submit" value="Save" />
                <input className="crud-form-button" type="reset" value="Clear" onClick={handleReset} />
            </form>
        </div>
    );
};

export default CrudForm;