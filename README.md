# Golden Raspberry Awards Worst Movie API
API RESTful with indicators of the worst film category of the Golden Raspberry Awards.

## About The Project
The purpose of this API is to read a CSV data source, store the data in memory and provide the producer with the longest interval between two consecutive awards, and the one who got two awards faster.

### Key Features
* Golden Raspberry Awards
* Worst Movie
* Movie data reader
* CSV file adapter
* Producers intervals
* Consecutive awards
* Two awards faster
* Awards range

### API Resource
**Request**
**Method:** GET
**URL:** /worstmovie-api/v1/producers/awards-range
**Response data structure:**
| Property | Type |
|--|--|
| min | Array |
| min.producer | String |
| min.interval| Long |
| min.previousWin| Long |
| min.followingWin| Long |
| max | Array |
| max.producer | String |
| max.interval| Long |
| max.previousWin| Long |
| max.followingWin| Long |
**Response sample:**
```javascript
{
	"min": [{
		"producer": "Joel Silver",
		"interval": 1,
		"previousWin": 1990,
		"followingWin": 1991
	}],
	"max": [{
		"producer": "Matthew Vaughn",
		"interval": 13,
		"previousWin": 2002,
		"followingWin": 2015
	}]
}
```

### Built With
* [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/) - The IDE used
* [Java 8](https://www.java.com/pt-BR/) - Execution platform
* [Spring Boot - 2.4.4](https://spring.io/projects/spring-boot) - Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run"
* [H2 Database](https://www.h2database.com/html/main.html) - In memory database
* [Project Lombok](https://projectlombok.org/) - Repetitive code reduction
* [JUnit](https://junit.org/junit5/) - Unit and integration tests
* [Maven](https://maven.apache.org/) - Build automation tool

## Getting Started
To get a local copy up and running follow these simple steps.

### Prerequisites
This project requires Java 8 or higher and use an IDE of your choice that supports Maven.

### Installation
Clone the repo
```
git clone https://github.com/ezequieljuliano/worst-movie-award-api.git
```

## Usage
Open the project in your preferred IDE and run the main class **WorstMovieApplication**.

Use Postman, or your browser to call the main resource or:
```
curl http://localhost:8000/worstmovie-api/v1/producers/awards-range
```

### Junit Integration Tests
Run the unit tests and check that everything is fine. 
Execute the class **WorstMovieApplicationTests**.

## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the APACHE LICENSE. See `LICENSE` for more information.

## Contact

To contact us use the options:
* E-mail  : ezequieljuliano@gmail.com
* Twitter : [@ezequieljuliano](https://twitter.com/ezequieljuliano)
* Linkedin: [ezequiel-juliano-müller](https://www.linkedin.com/in/ezequiel-juliano-müller-43988a4a)

## Project Link
[https://github.com/ezequieljuliano/worst-movie-award-api](https://github.com/ezequieljuliano/worst-movie-award-api)