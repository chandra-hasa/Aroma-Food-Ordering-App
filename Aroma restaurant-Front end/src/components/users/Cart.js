
import NavBar from './NavBar'

function Cart(props) {

    //const [hasa,setHasa]=useState([]);
    //setHasa([...hasa,props.cartItem]);

    // useEffect(()=>{
    //     setHasa(props.cartItem);

    // },[props])
    
    return (
        <div>
            
            <NavBar/>      
                <div class="card ">
                <div class="card-body">
                    <h3>Cart</h3>
                </div>
                <div>
                    {console.log(props.cartItem)}
                    { props.cartItem && (props.cartItem.map((food=>
                        <div key={food.foodItemId}>
                                  
                                    {food.foodItemName}
                                    {food.price}
                                    {food.quantity}
                                    <div class="card-body">
                                    <button class="btn btn-sm btn-warning">-</button>
                                        <small>{' '} Qty {' '}</small>
                                    <button class="btn btn-sm btn-warning">+</button>
                        </div>
                                    
                                
                  

                        </div>

                    )))
                }
                
                </div>
                
                {/* <ul class="list-group list-group-flush">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                </ul> */}
                <div class="card-body">
                    <button class="btn btn-sm btn-warning">-</button>
                    <small>{' '} Qty {' '}</small>
                    <button class="btn btn-sm btn-warning">+</button>
                </div>
                </div>
                <hr/>
                <button className='btn  btn-success float-right'>Proceed</button>
                <br/>
                <br/>
            </div>


              
    
    )
}

export default Cart
