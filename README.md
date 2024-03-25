# URL Shortener

This URL shortener project is designed as part of the recruitment process for Payroc, showcasing a simple yet effective approach to creating shortened URLs with Spring Boot.

## Dependencies

- JDK 11 (or newer)
- Spring Boot (2.5.0 or newer)
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Spring Security
- Maven

## How to Use

### 1. Clone the Repository
Clone this repository to your local machine using `git clone` followed by the repository URL.

### 2. Configure the Database
Ensure PostgreSQL is installed and running on your local machine. Create a database for the project and update the `application.properties` file with your database credentials and the JDBC URL.

Example `application.properties` snippet:
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password

#### 2.1 Docker setup for Postgres:
`         docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres`

### 3. Build the Project
In the root directory of the project, run:
mvn clean install

This compiles the project and creates an executable JAR in the `/target` directory.

### 4. Run the Application
Start the application with:
java -jar target/urlshortener-0.0.1-SNAPSHOT.jar

Replace `urlshortener-0.0.1-SNAPSHOT.jar` with the name of your JAR file.

### 5. Access the Application
Open `http://localhost:8080` in a web browser to use the URL shortener.

### 6. Shorten a URL
Enter a URL you wish to shorten. Submit to receive a shortened URL.

### 7. Use the Shortened URL
Click on the shortened URL to be redirected to the original URL.

## Potential Improvements/Future Development

- Enhance the UI and ensure mobile responsiveness.
- Add more security measures and validation to only allow valid and functioning URLs to be shortened.