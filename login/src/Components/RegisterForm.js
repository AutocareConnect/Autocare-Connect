// src/RegisterForm.js
import React, { useState } from 'react';
import './RegisterForm.css';

const RegisterForm = ({ onSwitchToLogin }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Basic registration logic
    if (password !== confirmPassword) {
      setError('Passwords do not match.');
      setSuccess('');
    } else {
      setSuccess('Registration successful!');
      setError('');
    }
  };

  return (
    <div className="register-container">
      <form className="register-form" onSubmit={handleSubmit}>
        <h2>Register</h2>
        {error && <div className="error-message">{error}</div>}
        {success && <div className="success-message">{success}</div>}
        <div className="input-group">
          <label htmlFor="register-email">Email</label>
          <input
            type="email"
            id="register-email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div className="input-group">
          <label htmlFor="register-password">Password</label>
          <input
            type="password"
            id="register-password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <div className="input-group">
          <label htmlFor="register-confirm-password">Confirm Password</label>
          <input
            type="password"
            id="register-confirm-password"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit">Register</button>
        <p className="switch-link">
          Already have an account? <a href="#" onClick={onSwitchToLogin}>Login</a>
        </p>
      </form>
    </div>
  );
};

export default RegisterForm;
