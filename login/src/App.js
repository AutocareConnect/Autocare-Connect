import React, { useState } from 'react';
import './App.css';
import LoginForm from './Components/LoginForm';
import RegisterForm from './Components/RegisterForm';

function App() {
  const [showLogin, setShowLogin] = useState(true);

  const switchToRegister = () => setShowLogin(false);
  const switchToLogin = () => setShowLogin(true);

  return (
    <div className="App">
      {showLogin ? (
        <LoginForm onSwitchToRegister={switchToRegister} />
      ) : (
        <RegisterForm onSwitchToLogin={switchToLogin} />
      )}
    </div>
  );
}

export default App;