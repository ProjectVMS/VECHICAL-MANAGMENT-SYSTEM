// import React from 'react';

// const ServicesPage = () => {
//   const services = [
//     { id: 1, name: 'Oil Change', description: 'Regular oil change for your vehicle.' },
//     { id: 2, name: 'Tire Rotation', description: 'Rotate and balance your tires for optimal performance.' },
//     { id: 3, name: 'Brake Inspection', description: 'Thorough inspection of your vehicle\'s braking system.' },
//     { id: 4, name: 'Engine Tune-Up', description: 'Comprehensive engine tune-up and diagnostics.' },
//     // Add more services as needed
//   ];

//   return (
//     <div>
//       <h2>Services Page</h2>
//       <ul>
//         {services.map((service) => (
//           <li key={service.id}>
//             <h3>{service.name}</h3>
//             <p>{service.description}</p>
//           </li>
//         ))}
//       </ul>
//     </div>
//   );
// };

// export default ServicesPage;

import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/services_page.css';
import oilChangeImage from '../assets/all-images/service-img/oilChangeImage.png';
import tireRotationImage from '../assets/all-images/service-img/tireRotationImage.png';
import brakeInspectionImage from '../assets/all-images/service-img/brakeInspectionImage.png';
import engineTuneUpImage from '../assets/all-images/service-img/engineTuneUpImage.png';

const ServicesPage = () => {
  const services = [
    { id: 1, name: 'Oil Change' },
    { id: 2, name: 'Tire Rotation' },
    { id: 3, name: 'Brake Inspection' },
    { id: 4, name: 'Engine Tune-Up' },
    // Add more services as needed
  ];

  const serviceImages = {
    1: oilChangeImage,
    2: tireRotationImage,
    3: brakeInspectionImage,
    4: engineTuneUpImage,
    // Add more image imports as needed
  };

  return (
    <div>

      <br />
      <br />
      { <center><h2>Choose the Service You Desire</h2></center> }
      <br />
      <br />
      <ul className='services-list'>
        {services.map((service) => (
          <li key={service.id} className='service-box'>
            <div className="service-content">
              <h3>{service.name}</h3>
              <img src={serviceImages[service.id]} alt={`${service.name} Image`} className="service-image" />
            </div>
            <Link to={`/book/${service.id}`} className="btn btn-outline-primary">
              Book Service
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ServicesPage;
