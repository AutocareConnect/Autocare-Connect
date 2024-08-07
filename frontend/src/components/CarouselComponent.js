// src/components/CarouselComponent.js
import React from 'react';
import { Carousel, CarouselItem, CarouselControl, CarouselIndicators, CarouselCaption } from 'reactstrap';

// Array of items for the carousel
const items = [
  {
    src: 'assets/slide3.jpg',
    altText: 'Service 1',
    caption: 'Service 1 Description'
  },
  {
    src: 'assets/slide1.jpg',
    altText: 'Service 2',
    caption: 'Service 2 Description'
  },
  {
    src: 'assets/slide2.jpg',
    altText: 'Service 3',
    caption: 'Service 3 Description'
  }
];

const CarouselComponent = () => {
  const [activeIndex, setActiveIndex] = React.useState(0);
  const next = () => setActiveIndex((prevIndex) => (prevIndex + 1) % items.length);
  const prev = () => setActiveIndex((prevIndex) => (prevIndex - 1 + items.length) % items.length);
  const goToIndex = (newIndex) => setActiveIndex(newIndex);

  return (
    <Carousel
      activeIndex={activeIndex}
      next={next}
      previous={prev}
      interval={2000} // Set the interval for slide change (in milliseconds)
    >
      <CarouselIndicators items={items} activeIndex={activeIndex} onClickHandler={goToIndex} />
      {items.map((item) => (
        <CarouselItem key={item.src}>
          <img
            src={item.src}
            alt={item.altText}
            style={{ width: '100%', height: 'auto', objectFit: 'cover' }} // Ensures images cover the container
          />
          <CarouselCaption captionText={item.caption} captionHeader={item.altText} />
        </CarouselItem>
      ))}
      <CarouselControl direction="prev" directionText="Previous" onClickHandler={prev} />
      <CarouselControl direction="next" directionText="Next" onClickHandler={next} />
    </Carousel>
  );
};

export default CarouselComponent;
