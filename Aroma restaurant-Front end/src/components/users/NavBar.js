import React from 'react';
import Logo from "../users/images/Logo.png";
import '../users/styling.css'
import {Link} from 'react-router-dom';
import {useNavigate} from 'react-router-dom';

import Cookies from 'js-cookie';
// import UserService from '../../services/UserService';
function NavBar() {

    const navigate=useNavigate();

    const profileHandler=(userId)=>{
                navigate(`/profile/${userId}`);
            }
    

    const logoutHandler=(e)=>{
        Cookies.remove('username');
        Cookies.remove('userId');
        navigate('/');
        alert("Logged out..!");

    }
    return (
        <div>
            <nav id="navbar" class="navbar navbar-expand-lg navbar-light">         
            <img src={Logo} height="120px" alt=""/>

            <button class="navbar-toggler"
                     type="button" data-toggle="collapse" 
                     data-target="#navbarSupportedContent" 
                     aria-controls="navbarSupportedContent" 
                     aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">

                    
                <li className='nav-item'>
                       <p class="nav-link">Hello! {Cookies.get('username')}</p> 
                    </li>
                    <li class="nav-item active">
                        <Link to='/menu' class=" btn btn-sm btn-warning" >Home <span class="sr-only">(current)</span></Link>
                    </li>

                    <li class="nav-item">
                        <button class="btn btn-sm btn-warning " onClick={()=>profileHandler(`${Cookies.get('username')}`)}>Profile</button>
                    </li>


                    

                    


                    <li class="nav-item">
                        <button class="btn btn-sm btn-warning" onClick={(e)=> logoutHandler(e)}>Log out</button>
                    </li>
                </ul>
                
              </div>
            </nav>
        </div>
    )
}
export default NavBar
