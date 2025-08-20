# Library Management System (Spring JPA Tutorial)

A cutting-edge Library Management System designed to showcase the power of Spring Framework with Java Persistence API (JPA). This application will serve as a testament to the capabilities of Spring and JPA, demonstrating their synergy in creating robust and efficient web services. (Not really it's just a simple demo project)

Also, this project only works on Happy cases, meaning it does not handle any exceptions or errors. It is a simple demonstration of how to use Spring JPA to create a RESTful API for managing books in a library.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 17 or _higher_
- Gradle
- MySQL

### Installing

1. Clone the repository
```shell
git clone https://github.com/Sorravit/SpringJPATutorial.git
```

2. Navigate to the project directory
```shell
cd SpringJPATutorial
```

3. Build the project
```shell
gradle build
```

4. Run the application
```shell
gradle bootRun
```

## Running the tests

To run the automated tests for this system, use the following command:

```shell
gradle test
```

## Database Setup

Before running the application, make sure you have MySQL installed and running. Then:

1. Start MySQL service:
```shell
sh run.sh database-start
```

## API Testing

Here are the curl commands to test the API endpoints:

### Books API

1. Create a new book:
    <br>*Note that isbn is unique and required for each book*
```shell
curl -X POST http://localhost:8080/books \
  -H "Content-Type: application/json" \
  -d '{"title":"Spring Boot Tutorial","author":"John Doe","isbn":"1234567890"}'
```

2. Get a book by ISBN:
```shell
curl http://localhost:8080/books/1234567890
```

3. Get all books:
```shell
curl http://localhost:8080/books
```

4. Update a book by ISBN:
```shell
curl -X PUT http://localhost:8080/books/1234567890 \
  -H "Content-Type: application/json" \
  -d '{"title":"Updated Spring Boot Tutorial","author":"Jane Doe","isbn":"1234567890"}'
```

5. Delete a book by ISBN:
```shell
curl -X DELETE http://localhost:8080/books/1234567890
```

Note: Replace "1234567890" with the actual ISBN of the book you want to modify.

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [Gradle](https://gradle.org/) - Dependency Management
- [MySQL](https://www.mysql.com/) - Used to generate RSS Feeds

## Authors

- **Sorravit** - *Initial work* - [sorravit](https://github.com/sorravit)

## License

This project is licensed under the MIT License - Google it yourself for details
