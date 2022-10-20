import httpClient from '../http-common';

const addFoodItem=(data)=>{
    return httpClient.post('/add/fooditem',data);
}


const updateFoodItem=(data)=>{
    return httpClient.put('/update/fooditem',data);
}

const getFoodList=()=>{
    return httpClient.get('/get/fooditems');
}

// eslint-disable-next-line import/no-anonymous-default-export
export default {addFoodItem,updateFoodItem,getFoodList};