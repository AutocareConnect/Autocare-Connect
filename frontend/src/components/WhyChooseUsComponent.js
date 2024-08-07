// src/components/WhyChooseUsComponent.js
import React from 'react';
import { Container, Row, Col, Card, CardImg, CardBody, CardTitle, CardText } from 'reactstrap';

const WhyChooseUsComponent = () => {
  return (
    <div className="whyautocare" style={{ padding: '40px 0', textAlign: 'center' }}>
      <h1>Why Choose Us</h1>
      <h3>We provide the best servicing in the market</h3>
      <Container>
        <Row>
          <Col md={4}>
            <Card>
              <CardImg top width="100%" src="assets/oilchange.jpg" alt="Oil/Lube/Filters" />
              <CardBody>
                <CardTitle tag="h2">Oil/Lube/Filters</CardTitle>
                <CardText>
                  AutoCare Connect proudly serves the Lube, Oil & Filter change needs of customers' vehicle performance while extending the life of your vehicle.
                </CardText>
              </CardBody>
            </Card>
          </Col>
          <Col md={4}>
            <Card>
              <CardImg top width="100%" src="assets/washing.jpg" alt="Washing" />
              <CardBody>
                <CardTitle tag="h2">Washing</CardTitle>
                <CardText>
                  The Two-Wheeler Washing Project promises to deliver high-quality, eco-friendly cleaning services to motorcycle and scooter owners. With a focus on customer satisfaction and sustainable practices.
                </CardText>
              </CardBody>
            </Card>
          </Col>
          <Col md={4}>
            <Card>
              <CardImg top width="100%" src="assets/tyre.jpg" alt="Brakes" />
              <CardBody>
                <CardTitle tag="h2">Brakes</CardTitle>
                <CardText>
                  The brake system consists of different parts that can be fixed individually. A detailed quote is given to you after we perform our systematic brake evaluation.
                </CardText>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default WhyChooseUsComponent;
