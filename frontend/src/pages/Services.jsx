import React from 'react';

const ServicesPage = () => {
  const services = [
    { id: 1, name: 'Oil Change', description: 'Regular oil change for your vehicle.' },
    { id: 2, name: 'Tire Rotation', description: 'Rotate and balance your tires for optimal performance.' },
    { id: 3, name: 'Brake Inspection', description: 'Thorough inspection of your vehicle\'s braking system.' },
    { id: 4, name: 'Engine Tune-Up', description: 'Comprehensive engine tune-up and diagnostics.' },
    // Add more services as needed
  ];

  return (
    <div>
      <h2>Services Page</h2>
      <ul>
        {services.map((service) => (
          <li key={service.id}>
            <h3>{service.name}</h3>
            <p>{service.description}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ServicesPage;
