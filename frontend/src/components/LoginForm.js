import React, { useState } from 'react';
import { Button, Form, FormGroup, Label, Input, Container, Alert, Card, CardBody, CardTitle } from 'reactstrap';

const LoginForm = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  const validateForm = () => {
    if (!email || !password) {
      setError('All fields are required.');
      return false;
    }
    if (!/\S+@\S+\.\S+/.test(email)) {
      setError('Please enter a valid email.');
      return false;
    }
    return true;
  };

  const handleLogin = (e) => {
    e.preventDefault();
    if (!validateForm()) {
      return;
    }

    // Mock authentication logic
    if (email === 'user@example.com' && password === 'password123') {
      setSuccess('Login successful!');
      setError('');
      // Handle successful login here (e.g., redirect, store auth token, etc.)
    } else {
      setError('Invalid email or password.');
      setSuccess('');
    }
  };

  return (
    <Container className="mt-5 d-flex justify-content-center">
      <Card style={{ width: '400px' }}>
        <CardBody>
          <CardTitle tag="h2" className="text-center">Login</CardTitle>
          {error && <Alert color="danger">{error}</Alert>}
          {success && <Alert color="success">{success}</Alert>}
          <Form onSubmit={handleLogin}>
            <FormGroup>
              <Label for="email">Email</Label>
              <Input
                type="email"
                name="email"
                id="email"
                placeholder="Enter your email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </FormGroup>
            <FormGroup>
              <Label for="password">Password</Label>
              <Input
                type="password"
                name="password"
                id="password"
                placeholder="Enter your password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </FormGroup>
            <Button type="submit" color="primary" block>Login</Button>
          </Form>
        </CardBody>
      </Card>
    </Container>
  );
};

export default LoginForm;
