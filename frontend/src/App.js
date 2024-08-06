import React from 'react';
import './App.css';

import 'bootstrap/dist/css/bootstrap.min.css';
import NavbarComponent from './components/NavbarComponent';
import CarouselComponent from './components/CarouselComponent';
import FooterComponent from './components/FooterComponent';

import { Container } from 'reactstrap';
import WhyChooseUsComponent from './components/WhyChooseUsComponent';
import BannerComponent from './components/BannerComponent';

import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import AdminLoginForm from './components/AdminLoginForm';
import UserLoginForm from './components/UserLoginForm';
import ServiceCentreLoginForm from './components/ServiceCentreLoginForm';



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
    </Router>
     <CarouselComponent/>
     <Container/>
     <WhyChooseUsComponent/>
     <BannerComponent/>
     <FooterComponent/>
    </div>
  );
}

export default App;
