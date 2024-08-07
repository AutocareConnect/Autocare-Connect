// src/LoginForm.js
import React, { useState } from 'react';
import './LoginForm.css';

const LoginForm = ({ onSwitchToRegister }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Basic login logic (replace with real authentication logic)
    if (email === 'user@example.com' && password === 'password') {
      setSuccess('Login successful!');
      setError('');
    } else {
      setError('Invalid email or password.');
      setSuccess('');
    }
  };

  return (
    <div className="login-container">
      <form className="login-form" onSubmit={handleSubmit}>
        <h2>Login</h2>
        {error && <div className="error-message">{error}</div>}
        {success && <div className="success-message">{success}</div>}
        <div className="input-group">
          <label htmlFor="login-email">Email</label>
          <input
            type="email"
            id="login-email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div className="input-group">
          <label htmlFor="login-password">Password</label>
          <input
            type="password"
            id="login-password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit">Login</button>
        <p className="switch-link">
          Don't have an account? <a href="#" onClick={onSwitchToRegister}>Register</a>
        </p>
      </form>
    </div>
  );
};

export default LoginForm;
