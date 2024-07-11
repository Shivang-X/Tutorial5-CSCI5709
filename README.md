# Tutorial 5

* *Date Created*: 11 JULY 2024
* *Last Modification Date*: 11 JULY 2024
* *Tutorial Hosted URL*: <https://tutorial5-7c92.onrender.com>
* *GitLab URL*: <https://git.cs.dal.ca/khush/csci-5709-tutorials/-/tree/main/Tutorial5?ref_type=heads>

## Authors

* [Shivang](sh587705@dal.ca)

## Getting Started

### Prerequisites

For running this project on your local machine, you need to first have few libraries installed which are listed below
- [Java JDK](https://www.oracle.com/ca-en/java/technologies/downloads/#java17) `v17`
- [maven](https://maven.apache.org/) `v3`

### Installing

Clone the Repository

```bash
 git clone https://git.cs.dal.ca/khush/csci-5709-tutorials.git
 ```
OR
 ```bash
 git clone git@git.cs.dal.ca:khush/csci-5709-tutorials.git
```

Navigate to the Tutorial 3 directory

```
cd Tutorial5 
```
Install dependencies

- Run the following command to install dependencies:

```bash
mvn install
```

Start Spring boot App

- After installing dependencies, start the Spring Boot development server by running:

```bash
mvn spring boot:run
```

- After Application has successfully started, all APIs will be available at:  [http://localhost:8080](http://localhost:8080).


## Deployment


- To deploy your applicaiton to Render follow the instructions below.

#### Step 1:
Go to www.render.com and Sign up or Login
#### Step 2:
Create a New Site:
- Click on "+ New" button.
- Click on Web Service
#### Step 3:
Configure Settings:
- Select Build and deploy from a Git repository and click next button
- Select your github account
- Click Connect
- Name: tutorial5
- Language: Docker
- Branch: main
- Instance Type: Free
- Click Deploy Web Application


## Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/)
* [Java JDK 17](https://www.oracle.com/ca-en/java/technologies/downloads/)


## Sources Used
```
package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
```
The code above was taken as reference from [Spring Boot](https://spring.io/guides/gs/rest-service) for creating rest services in Java 

```
public static List<Player> getPlayers() throws IOException {
    Path path = Paths.get("players.dat");
    List<String> players = Files.readAllLines(path);

    return players.stream()
      .map(Player::new)
      .collect(Collectors.toList());
}
```
- The code above was taken as reference from [Baeldug](https://www.baeldung.com/java-exceptions) for handeling exceptions.


## Acknowledgments
I appreciate using tools such as Spring Boot, Maven, and Java JDK 17 to enhance the development workflow.
