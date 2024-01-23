# Liveasy Load Management System

## Overview

The Liveasy Load Management System is a Java and Spring Boot-based API project that facilitates the management of loads for shippers. It provides endpoints to add, retrieve, update, and delete load information.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)

## Prerequisites

Ensure you have the following prerequisites installed:

- [Java](https://www.java.com/en/download/)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Database](https://www.postgressql.com/)

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/palak003/liveasy.git
   cd liveasy
   ```

2. Build the project:

   ```bash
   mvn clean install
   ```

3. Run the application:

   ```bash
   java -jar target/your-application.jar
   ```

## Usage

The application runs on `http://localhost:8080` by default. You can use [Postman](https://www.postman.com/) or any other API testing tool to interact with the provided endpoints.

## API Endpoints

1. **POST /load**

   - Payload:

     ```json
     {
       "loadingPoint": "delhi",
       "unloadingPoint": "jaipur",
       "productType": "chemicals",
       "truckType": "canter",
       "noOfTrucks": "1",
       "weight": "100",
       "comment": "",
       "shipperId": "shipper:<UUID>",
       "date": "dd-mm-yyyy"
     }
     ```

   - Response:

     ```
     Loads details added successfully
     ```

2. **GET /load**

   - Query Params:

     ```
     shipperId
     ```

   - Response:

     ```
     List of loads with this shipperId
     ```

3. **GET /load/{loadId}**

   - Response:

     ```
     Load details for the specified loadId
     ```

4. **PUT /load/{loadId}**

   - Payload:

     ```json
     {
       "loadingPoint": "alwar",
       "unloadingPoint": "jaipur",
       "productType": "chemicals",
       "truckType": "canter",
       "noOfTrucks": "1",
       "weight": "100",
       "comment": "",
       "shipperId": "shipper:<UUID>",
       "date": "dd-mm-yyyy"
     }
     ```

   - Response:

     ```
     Load details updated successfully
     ```

5. **DELETE /load/{loadId}**

   - Response:

     ```
     Load deleted successfully
     ```

