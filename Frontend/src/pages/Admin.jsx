import { Container, Row } from "reactstrap";
import Helmet from "../components/Helmet/Helmet";
import CommonSection from "../components/UI/CommonSection";
import "../styles/about.css";
import axios from "axios";
import { createUrl, log } from '../utils/utils';
import { toast } from 'react-toastify';
import { useEffect, useState } from "react";

const Admin = () => {
    const [showAddCarForm, setShowAddCarForm] = useState(false);
    const [imageFile, setImageFile] = useState(null);
    const [cars, setCars] = useState([]); 
    const [newCar, setNewCar] = useState({
        brandName: "",
        modelName: "",
        year: 0,
        price: 0,
        mileage: 0,
        fuelType: "",
        transmissionType: "",
        description: "",
        carSpec: {  // Initialize the carSpec object with default values
            color: "",
            engine: "",
            horsepower: 0,
            dimensions: 0
        }
    });

    useEffect(() => {
        loadCar();
    }, []);

    const loadCar = () => {
        const url = createUrl('/cars')
        axios.get(url)
            .then(function (response) {
                setCars(response.data);
                log(response);
            })
            .catch(function (error) {
                log(error);
            });
    }

    const deleteCar = (id) => {
        const url = createUrl(`/cars/${id}`)
        axios.delete(url)  
        .then(res => {  
          log(res);
          toast.error('Car Deleted Successfully!! id = '+ id)  
          loadCar();
        })  
        .catch(function (error) {
            log(error);
        });
    }

    const uploadImage = (carId) => {
        if (!imageFile) {
            toast.error('Please select an image to upload.');
            return;
        }
    
        const formData = new FormData();
        formData.append('imageFile', imageFile);
    
        const url = createUrl(`/cars/images/${carId}`);
        axios.post(url, formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        })
        .then(function (response) {
            toast.success('Image uploaded successfully!');
            setImageFile(null); // Reset the image file state
        })
        .catch(function (error) {
            log(error);
            toast.error('Error uploading image.');
        });
    };

    const addCar = (e) => {
        e.preventDefault();
    
        const url = createUrl('/cars');
        axios.post(url, newCar)
            .then(function (response) {
                toast.success('Car Added Successfully!');
                loadCar(); // Reload the list of cars
                setNewCar({
                    brandName: "",
                    modelName: "",
                    year: 0,
                    price: 0,
                    mileage: 0,
                    fuelType: "",
                    transmissionType: "",
                    description: "",
                    carSpec: {  // Initialize the carSpec object with default values
                        color: "",
                        engine: "",
                        horsepower: 0,
                        dimensions: 0
                    }
                }); // Clear the input fields
            })
            .catch(function (error) {
                log(error);
                toast.error('Error adding car.');
            });
    };

    return (
        <Helmet title="Admin">
            <CommonSection title="Admin" />
            <section className="about__page-section">
                <Container>
                    <Row>
                        <div className="col-md-10">
                            <table className="table" style={{ border: "1px solid black" }}>
                                <thead className="thead-dark">
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Model</th>
                                        <th scope="col">Year</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Mileage</th>
                                        <th scope="col">FuelType</th>
                                        <th scope="col">Transmission Type</th>
                                        <th scope="col">Description</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        cars.map((data) => {
                                            return (   
                                                <tr key={data.id}>
                                                    <td>{data.id}</td>
                                                    <td>{data.brandName}</td>
                                                    <td>{data.modelName}</td>
                                                    <td>{data.year}</td>
                                                    <td>{data.price}</td>
                                                    <td>{data.mileage}</td>
                                                    <td>{data.fuelType}</td>
                                                    <td>{data.transmissionType}</td>
                                                    <td>{data.description}</td>
                                                    <td>
                                                        <button className="btn btn-danger btn-sm" onClick={() => deleteCar(data.id)}>Delete</button>
                                                    </td>
                                                    <td>
                                                        <div className="input-group">
                                                            <div className="custom-file">
                                                                <input
                                                                    type="file"
                                                                    className="custom-file-input"
                                                                    id={`image-${data.id}`}
                                                                    accept="image/*"
                                                                    onChange={(e) => setImageFile(e.target.files[0])}
                                                                />
                                                               
                                                                
                                                            </div>
                                                            <div className="input-group-append">
                                                                <br/>
                                                                <button
                                                                    className="btn btn-success btn-sm"
                                                                    onClick={() => uploadImage(data.id)}
                                                                >
                                                                    Upload Image
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                            )
                                        })
                                    }
                                </tbody>
                            </table>
                            <button className="btn btn-primary mt-3" onClick={() => setShowAddCarForm(!showAddCarForm)}>
                                {showAddCarForm ? "Cancel Add Car" : "Add Car"}
                            </button>
                            {showAddCarForm && (
                                <div className="mt-4">
                                     <form onSubmit={addCar} className="add-car-form">
            <div className="form-group">
                <label htmlFor="brandName">Brand Name</label>
                <input
                    type="text"
                    className="form-control"
                    id="brandName"
                    value={newCar.brandName}
                    onChange={(e) => setNewCar({ ...newCar, brandName: e.target.value })}
                    required
                />
            </div>
            <div className="form-group">
                <label htmlFor="modelName">Model Name</label>
                <input
                    type="text"
                    className="form-control"
                    id="modelName"
                    value={newCar.modelName}
                    onChange={(e) => setNewCar({ ...newCar, modelName: e.target.value })}
                    required
                />
            </div>
            <div className="form-group">
                <label htmlFor="price">Year</label>
                <input
                    type="number"
                    className="form-control"
                    id="year"
                    value={newCar.year}
                    onChange={(e) => setNewCar({ ...newCar, year: e.target.value })}
                    required
                />
            </div>
            <div className="form-group">
                <label htmlFor="price">Price</label>
                <input
                    type="number"
                    className="form-control"
                    id="price"
                    value={newCar.price}
                    onChange={(e) => setNewCar({ ...newCar, price: e.target.value })}
                    required
                />
            </div>
            <div className="form-group">
                <label htmlFor="price">mileage</label>
                <input
                    type="number"
                    className="form-control"
                    id="mileage"
                    value={newCar.mileage}
                    onChange={(e) => setNewCar({ ...newCar, mileage: e.target.value })}
                    required
                />
            </div>
            <div className="form-group">
                <label htmlFor="fuelType">Fuel Type</label>
                <input
                    type="text"
                    className="form-control"
                    id="fuelType"
                    value={newCar.fuelType}
                    onChange={(e) => setNewCar({ ...newCar, fuelType: e.target.value })}
                    required
                />
            </div>
            <div className="form-group">
                <label htmlFor="fuelType">Transmission Type</label>
                <input
                    type="text"
                    className="form-control"
                    id="transmissionType"
                    value={newCar.transmissionType}
                    onChange={(e) => setNewCar({ ...newCar, transmissionType: e.target.value })}
                    required
                />
            </div>
            <div className="form-group">
                <label htmlFor="fuelType">Description</label>
                <input
                    type="text"
                    className="form-control"
                    id="description"
                    value={newCar.description}
                    onChange={(e) => setNewCar({ ...newCar, description: e.target.value })}
                    required
                />
            </div>
            <div className="form-group">
        <label htmlFor="color">Color</label>
        <input
            type="text"
            className="form-control"
            id="color"
            value={newCar.carSpec.color}
            onChange={(e) => setNewCar({ ...newCar, carSpec: { ...newCar.carSpec, color: e.target.value } })}
            required
        />
    </div>
    <div className="form-group">
        <label htmlFor="engine">Engine</label>
        <input
            type="text"
            className="form-control"
            id="engine"
            value={newCar.carSpec.engine}
            onChange={(e) => setNewCar({ ...newCar, carSpec: { ...newCar.carSpec, engine: e.target.value } })}
            required
        />
    </div>
    <div className="form-group">
        <label htmlFor="horsepower">Horsepower</label>
        <input
            type="number"
            className="form-control"
            id="horsepower"
            value={newCar.carSpec.horsepower}
            onChange={(e) => setNewCar({ ...newCar, carSpec: { ...newCar.carSpec, horsepower: e.target.value } })}
            required
        />
    </div>
    <div className="form-group">
        <label htmlFor="dimensions">Dimensions</label>
        <input
            type="number"
            className="form-control"
            id="dimensions"
            value={newCar.carSpec.dimensions}
            onChange={(e) => setNewCar({ ...newCar, carSpec: { ...newCar.carSpec, dimensions: e.target.value } })}
            required
        />
    </div>
            <button type="submit" className="btn btn-primary">Add Car</button>
            <button type="button" className="btn btn-secondary ml-2" onClick={() => setShowAddCarForm(false)}>Cancel</button>
        </form>
                                </div>
                            )}
                        </div>
                    </Row>
                </Container>
            </section>
        </Helmet>
    )
}

export default Admin;
