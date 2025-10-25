E-Commerce Application
Project Overview

This is a full-stack E-Commerce Web Application developed using Java Spring Boot for the backend and React.js for the frontend. The application allows users to browse products, add items to the cart, and make purchases. Admins can manage products and track orders.

Features

User Features:

User registration and authentication

Browse and search products

Add/remove products to/from cart

Checkout and order history

Admin Features:

Add, edit, and delete products

Manage user orders

View product inventory

Common Features:

Responsive design

Secure authentication and authorization

Integration with MySQL database

Technologies Used

Backend: Java, Spring Boot, Spring JPA/Hibernate

Frontend: React.js, HTML5, CSS3, Bootstrap

Database: MySQL

Tools: Maven, Postman (for API testing), Git

Project Structure
e-commerce-app/
├── backend/                 # Spring Boot application
│   ├── src/main/java/
│   │   └── com/example/e_commerce/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       └── service/
│   └── src/main/resources/
│       └── application.properties
├── frontend/                # React.js application
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   └── App.js
│   └── package.json
└── README.md

Setup Instructions
Backend

Clone the repository:

git clone <repository-url>


Navigate to backend folder:

cd backend


Configure database connection in application.properties.

Build and run the application:

mvn clean install
mvn spring-boot:run

Frontend

Navigate to frontend folder:

cd frontend


Install dependencies:

npm install


Start the development server:

npm start

Usage

Access the frontend at http://localhost:3000

Backend APIs run at http://localhost:8080

Admin panel can be accessed with admin credentials

Future Enhancements

Payment gateway integration

Product reviews and ratings

Advanced search and filter options

Email notifications for orders

Author

Santhosh Kumar S

GitHub: https://github.com/santhoshkumar611