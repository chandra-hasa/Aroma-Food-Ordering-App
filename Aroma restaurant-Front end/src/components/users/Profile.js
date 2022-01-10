import React,{useState,useEffect} from 'react'
import NavBar from './NavBar'
import UserService from '../../services/UserService';
import Cookies from 'js-cookie';
import {Link} from 'react-router-dom'


function Profile() {

    const [profile,setProfile]=useState([]);

    useEffect(()=>{

        init(Cookies.get('userId'));
    },[])

    const init=(userId)=>{
        UserService.getUser(userId)
        .then(response=>{
            console.log(response.data);
            setProfile(response.data);
        })
        .catch(error=>{
            console.log("Something error..",error);
        })
    }

    

    return (
        <div>
            <NavBar/>
            <div class="card">
                {
                    

                <ul key={profile.userId}class="list-group list-group-flush">
                    <li class="list-group-item"><b>First name:{" "} </b>{profile.fName}</li>
                    <li class="list-group-item"><b>Last name:{" "} </b>{profile.lName}</li>
                    <li class="list-group-item"><b>Email:{" "} </b>{profile.email}</li>
                    <li class="list-group-item"><b>Username:{" "} </b>{profile.username}</li>
                    <li class="list-group-item"><b>City:{" "} </b>{profile.location}</li>
                    <li class="list-group-item"><b>Mobile:{" "} </b>{profile.phone}</li>  

                </ul>
                }

                

                
                </div>
                <br/>
                <br/>
                <Link className='btn col-md-4 btn-warning' to={`/user/edit/${profile.userId}`}>Edit Profile</Link>


        </div>
    )
}

export default Profile
