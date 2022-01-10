import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import AdminForm from './components/admin/AdminForm';
import {BrowserRouter as Router,Routes,Route} from 'react-router-dom';
import HomePage from './components/users/HomePage';
import UserRegistration from './components/users/UserRegistration';
import UserLogin from './components/users/UserLogin';
import Menu from './components/users/Menu';
import Cart from './components/users/Cart';
import Profile from './components/users/Profile';
import OrderConfirm from './components/users/OrderConfirm';



function App() {


  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path="/" element={<HomePage/>}/>
          <Route  path="/user/register" element={<UserRegistration/>}/>
          <Route  path="/user/edit/:userId" element={<UserRegistration/>}/>
          <Route  path="/admin/add" element={<AdminForm/>}/>
          <Route path="user/login" element={<UserLogin/>}/>
          <Route path="/menu" element={<Menu/>}/>
          <Route path="/cart" element={<Cart/>}/>
          <Route path="/confirm" element={<OrderConfirm/>}/>
          <Route path="/profile/:userId" element={<Profile/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
