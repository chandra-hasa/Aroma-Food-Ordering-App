import httpClient from '../http-common';

const addUser=(data)=>{
    return httpClient.post('/add/user',data);
}


const updateUser=(data)=>{
    return httpClient.put('/update/user',data);
}

// eslint-disable-next-line import/no-anonymous-default-export
export default {addUser,updateUser};