// src/components/BannerComponent.js
import React from 'react';
import { Container, Row, Col } from 'reactstrap';

const BannerComponent = () => {
  return (
    <a href="#0" className="banner" aria-label="Shop now" style={{ textDecoration: 'none', display: 'block', width: '100%' }}>
      <Container fluid style={{ padding: '0', margin: '0' }}>
        <Row noGutters>
          <Col xs={12} md={6} style={{ padding: '0' }}>
            <figure
              style={{
                backgroundImage: 'url(https://t3.ftcdn.net/jpg/05/45/76/50/360_F_545765097_ISjpxB4vvs3FY1K2KgOotIcaZsdHYJPn.jpg)',
                backgroundSize: 'cover',
                backgroundPosition: 'center',
                height: '300px', // Adjust height as needed
                width: '100%',
                margin: '0',
              }}
            />
          </Col>
          <Col xs={12} md={6} style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', padding: '20px', color: '#fff', backgroundColor: '#00000080' }}>
            <h2>Service Centers</h2>
            <p>More service centers are available in AutoCare Connect. Check out our service centers.</p>
            <p className="banner__link-wrapper" style={{ marginTop: '20px' }}>
              <span
                className="banner__link"
                style={{
                  display: 'inline-block',
                  padding: '10px 20px',
                  backgroundColor: '#BA6573', // Adjust background color as needed
                  color: '#fff',
                  borderRadius: '5px',
                  textDecoration: 'none',
                }}
              >
                <i>Check Out</i>
              </span>
            </p>
          </Col>
        </Row>
      </Container>
    </a>
  );
};

export default BannerComponent;
