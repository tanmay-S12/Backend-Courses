
# Backend-Courses - IIT Bombay Assignment

## Overview

The `Backend-Courses` application provides a RESTful API for managing courses and their delivery instances. This backend service allows you to perform CRUD operations on courses and manage instances of course deliveries. The API supports operations to create, list, view, and delete courses and their delivery instances.

## Project Setup

To run this project on your local machine using Docker, follow the steps below:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/tanmay-S12/Backend-Courses.git

2. **Run the Docker image**

   ```bash
   docker-compose up

3. **Access the application :**
   ```bash
   localhost:8080


## API Endpoints

### Courses API

- **Create a New Course**
  - **Endpoint**: `POST /api/courses`
  - **Description**: Create a new course by providing necessary details in the request body.

- **List All Courses**
  - **Endpoint**: `GET /api/courses`
  - **Description**: Retrieve a list of all available courses.

- **View Course Details**
  - **Endpoint**: `GET /api/courses/{id}`
  - **Description**: View detailed information about a course by providing the course ID in the URL.

- **Delete a Course**
  - **Endpoint**: `DELETE /api/courses/{id}`
  - **Description**: Delete a specific course by providing the course ID in the URL.

### Instances API

- **Create a New Instance of a Course Delivery**
  - **Endpoint**: `POST /api/instances`
  - **Description**: Create a new instance of a course delivery by providing necessary details in the request body.

- **List Courses Delivered in a Specific Year and Semester**
  - **Endpoint**: `GET /api/instances/{year}/{semester}`
  - **Description**: Retrieve a list of courses delivered in a specified year and semester.

- **View Instance Details**
  - **Endpoint**: `GET /api/instances/{year}/{semester}/{id}`
  - **Description**: View detailed information about a specific instance of a course by providing the year, semester, and instance ID in the URL.

- **Delete a Course Instance**
  - **Endpoint**: `DELETE /api/instances/{year}/{semester}/{id}`
  - **Description**: Delete a specific instance of a course by providing the year, semester, and instance ID in the URL.



