import React from 'react';
import {useState} from 'react';
import {useNavigate} from 'react-router-dom';
import FoodItemService from '../../services/FoodItemService';



function AdminForm() {
    
    const [foodItemName,setFoodItemName]=useState();
    const [description,setDescription]=useState();
    const [quantity,setQuantity]=useState();
    const [price,setPrice]=useState();
    const [foodItemImage,setFoodItemImage]=useState();
    const navigate=useNavigate();

    // const uploadImage=()=>{
    //     const formData = new FormData();
    // formData.append("file",foodItemImage)
    // formData.append("upload_preset","dood-items")
    // formData.append("cloud_name,","cloudabc")
    // fetch("https://api.cloudinary.com/v1_1/cloudabc/image/upload",{
    //     method:"post",
    //     body:formData,
    // })
    // .then((response)=>{
    //     console.log(response.json());
    // })
    // .then((formData)=>{
    //     console.log(formData.url);
    // })
    // .catch(error=>{
    //     console.log(error);
    // })
    // }
    

    const addFood=(e)=>{
        e.preventDefault();

        const foodItem={foodItemName,description,quantity,price,foodItemImage};

            FoodItemService.addFoodItem(foodItem)
            .then(response=>{
                console.log("Updated succesfully!!",response.data);
                navigate('/');
            })
            .catch(error=>{
                console.log("Something went wrong",error);
            })

    }
    return (
        <div className='container'>

            <h4>Add Food Items</h4>
            <hr/>
            <form >
                <div className='form-group col-4'>
                    <input 
                        className='form-control' 
                        type='text' 
                        id='foodItemName' 
                        value={foodItemName}
                        onChange={(e)=>setFoodItemName(e.target.value)}
                        placeholder='Enter food item name'>
                    </input>
                </div>
                <div className='form-group col-4'>
                    <input
                        className='form-control'
                        type='text'
                        id='description'
                        value={description}
                        onChange={(e)=>setDescription(e.target.value)}
                        placeholder='Enter the description'>
                    </input>
                </div>
                <div className='form-group col-4'>
                    <input
                        className='form-control'
                        type='number'
                        id='quantity'
                        value={quantity}
                        onChange={(e)=>setQuantity(e.target.value)}
                        placeholder='Enter the quantity'>
                    </input>
                </div>
                <div className='form-group col-4'>
                    <input
                        className='form-control'
                        type='number'
                        id='price'
                        value={price}
                        onChange={(e)=>setPrice(e.target.value)}
                        placeholder='Enter the price'>
                    </input>
                </div>
                <div className="form-group col-4"> 
                    <input 
                        type="text" 
                        className="form-control" 
                        onChange={(e)=>setFoodItemImage(e.target.value)}
                        id="foodItemImage"
                        value={foodItemImage}
                        placeholder='Enter Image URL'/>
                </div>
                <div className='form-group'>
                        <button className='btn btn-info' onClick={(e)=>addFood(e)}>Add</button>
                </div>   
            </form>
        </div>
    )
}
export default AdminForm
