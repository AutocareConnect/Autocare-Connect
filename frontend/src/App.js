import React from 'react';
import './App.css';

import 'bootstrap/dist/css/bootstrap.min.css';
import NavbarComponent from './components/NavbarComponent';


import { Container } from 'reactstrap';


import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import AdminLoginForm from './components/AdminLoginForm';
import UserLoginForm from './components/UserLoginForm';
import ServiceCentreLoginForm from './components/ServiceCentreLoginForm';
import LandingPage from './components/LandingPage';



function App() {
  return (
    <div className="App">
     <Router>
      <NavbarComponent />
      <Routes>
      <Route path="/login/admin" element={<AdminLoginForm />} />
        <Route path="/login/user" element={<UserLoginForm />} />
        <Route path="/login/service-centre" element={<ServiceCentreLoginForm />} />
      </Routes>
    <LandingPage/>
     </Router>
    </div>
  );
}

export default App;
