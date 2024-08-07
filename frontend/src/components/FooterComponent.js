// src/components/FooterComponent.js
import React from 'react';
import { Container, Row, Col } from 'reactstrap';

const FooterComponent = () => {
  return (
    <footer className="bg-dark text-white text-center py-3">
      <Container>
        <Row>
          <Col>
            <p>&copy; 2024 2-Wheeler Servicing. All rights reserved.</p>
          </Col>
        </Row>
      </Container>
    </footer>
  );
};

export default FooterComponent;
