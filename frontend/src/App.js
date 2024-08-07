// src/App.js
import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import NavbarComponent from './components/NavbarComponent';
import CarouselComponent from './components/CarouselComponent';
import FooterComponent from './components/FooterComponent';
import WhyChooseUsComponent from './components/WhyChooseUsComponent';
import BannerComponent from './components/BannerComponent';

import LoginForm from './components/LoginForm';
import UserRegistrationForm from './components/UserRegistrationForm';
import ServiceCentreRegistrationForm from './components/ServiceCentreRegistrationForm';

const HomeLayout = ({ children }) => (
  <>
    <NavbarComponent />
    <CarouselComponent />
    <WhyChooseUsComponent />
    <BannerComponent />
    {children}
    <FooterComponent />
  </>
);

const FormLayout = ({ children }) => (
  <>
    <NavbarComponent />
    {children}
  </>
);

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/login" element={<FormLayout><LoginForm /></FormLayout>} />
          <Route path="/register/user" element={<FormLayout><UserRegistrationForm /></FormLayout>} />
          <Route path="/register/service-centre" element={<FormLayout><ServiceCentreRegistrationForm/></FormLayout>}/>
          <Route path="/" element={<HomeLayout />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
