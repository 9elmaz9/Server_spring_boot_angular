# Server Management Application

![Project Screenshot](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsEaDUbm-9Fn_f1AOKG7MGLkmvk1ShlMn5PywHxFty6y2BPhtUJOgXF3PIlTbj1N6Mh_M&usqp=CAU)

⚡ Server Management Application ⚡
In modern IT infrastructure, managing servers efficiently is crucial for maintaining performance, reliability, and security. Server Management Application is a lightweight yet powerful solution built with Spring Boot that simplifies server administration by allowing users to add, monitor, update, and remove servers effortlessly.

Whether you're an IT administrator, DevOps engineer, or a software developer, this application provides an intuitive RESTful API to interact with server resources, perform health checks, and keep your infrastructure organized.

🛠 Key Capabilities
Create and Manage Servers: Store details like IP address, name, memory, type, and status.
Real-Time Server Health Monitoring: Ping servers and check their availability instantly.
Organized Data Retrieval: Fetch server details, update configurations, or remove outdated entries.
Effortless Image Management: Retrieve and display server-related images directly from the file system.
REST API Integration: Use the provided endpoints for seamless automation and system integration.
Designed with scalability and simplicity in mind, this project offers a structured API that can be easily extended and integrated into larger infrastructure management solutions.

🚀 Get started today and take control of your servers with ease!


This project demonstrates a simple server management application using Spring Boot. The application allows for creating, pinging, listing, retrieving, updating, and deleting servers. It also provides an endpoint to serve server images.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [License](#license)

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/server-management.git
    ```

2. Navigate to the project directory:
    ```bash
    cd server-management
    ```

3. Build the project using Maven:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Usage

The application provides several endpoints to manage servers. You can use tools like `curl` or Postman to interact with these endpoints.

### Endpoints

- **Create a Server:** `POST /server/save`
- **Ping a Server:** `GET /server/ping/{ipAddress}`
- **List Servers:** `GET /server/list`
- **Get Server by ID:** `GET /server/get/{id}`
- **Update Server:** `PUT /server/update`
- **Delete Server:** `DELETE /server/delete/{id}`
- **Get Server Image:** `GET /server/image/{fileName}`

## Features

- **Create a Server:** Add a new server to the repository with details like IP address, name, memory, type, image URL, and status.
- **Ping a Server:** Check if a server is reachable by its IP address and update its status.
- **List Servers:** Retrieve a list of all servers with a specified limit.
- **Get Server by ID:** Retrieve a specific server's details by its ID.
- **Update Server:** Update the details of an existing server.
- **Delete Server:** Remove a server from the repository by its ID.
- **Get Server Image:** Serve server images stored on the file system.

## License

This project is licensed under the MIT License. 
