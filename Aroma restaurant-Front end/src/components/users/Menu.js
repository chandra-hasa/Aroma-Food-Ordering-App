import React from 'react'
import FoodItemService from '../../services/FoodItemService'
import NavBar from './NavBar'
import {useState,useEffect} from 'react';
import '../users/styling.css';
import {Link} from 'react-router-dom';
import Cookies from 'js-cookie';
import CartService from '../../services/CartService';


function Menu() {

    const [foodList,setFoodList]=useState([]);
    const [cart,setCart]=useState([]);
    const [updateCart,setUpdateCart]=useState(cart);
    const [total,setTotal]=useState(0);
    

    useEffect(()=>{
        getFoodItems();
    },[])

    const getFoodItems=()=>{
        FoodItemService.getFoodList()
        .then(response=>{
            setFoodList(response.data);
        })
        .catch(error=>{
            console.log("Something Went wrong..",error);
        })
    }

    
    const addToCart=(food)=>{         
         setCart([...cart,food]);
         setTotal(total+food.price);
         CartService.addToCart(Cookies.get('userId'),food.foodItemId)
         .then(response=>console.log("added into cart",response.data))
         .catch(error=>console.log("something is wrong",error))          
    }

    useEffect(() => {
        setCart(cart);
        setUpdateCart(cart);
        
    },[cart]);

    

    const removeHandler=(food)=>{
        
        setUpdateCart(cart.filter(item=> item.foodItemName!==food.foodItemName));
        setCart(cart.filter(item=>item.foodItemName!==food.foodItemName));
        setTotal(total-food.price);
        if(cart.length===0){
            setTotal(0);
        }
    };

    return (
        <div >
            <NavBar/>
            <br/>
            <div className="btn btn-outline-info ">
                           Items in Cart : {cart.length}
                        </div>
            <br/>
            
            <hr/>
            <h6>Cart</h6>
           
                <div class="row">
                        
                
                    {
                        
                        updateCart.map(food=>(
                            <div class="col-sm-3 card mb-3" style={{"max-width": "200px"}} key={food.foodItemId}>
                                
                                <div class="card-body">
                                    <div className='card-title'>
                                        <small>{food.foodItemName}</small>
                                    </div>
                                        <div class="card-text">
                                            <small>Rs.{food.price}</small>
                                        </div>
                                        <br/>
                                        <div>
                                        <button className='btn btn-sm btn-warning' onClick={()=>removeHandler(food)}>remove</button>
                                        </div>

                                        <div>
                                            
                                            </div>
                                    </div>
                                <div>
                                   
                                </div>
                            </div>
                        ))
                    }

                    

                </div>
                <p>Total Price:{total}</p>
            <hr/>
            <br/>      
            
                        

                        <div className='container'>
                        <div className='row'>

                        {
                            foodList.map(food=>(

                                
                                <div key={food.foodItemId} class="col-md-8 card mb-3" style={{"max-width": "900px"}}>
                                    <div className='row no-gutters'>
                                        <div className='col-md-3'>
                                            <img  class="card-img-top"  src={food.foodItemImage} alt="Card cap"/>
                                        </div>

                                        <div class="col-md-8">
                                            <div class="card-body">
            
                                                <h5 class="card-title">{food.foodItemName}</h5>
                                                <small class="card-text">{food.description}</small>
                                                <p class="card-text"><b>Rs.{food.price}</b></p>
                                                <button className='btn btn-sm btn-warning ' 
                                                    onClick={()=>addToCart(food)}>Add to Cart
                                                </button>
                                                <br/>
                                                
                                            </div>
                                            
                            
                                        </div>
                                        
                                    </div>
                                </div>
                            ))
                        }
                        </div>
                        </div>
                        <hr/>
                        
                        <Link to={`/confirm`} class="btn float-right btn-success">Place Order</Link>

            </div>
        
    )
}

export default Menu
