package com.example.springkpi.lessons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;

//@SpringBootApplication
public class SpringKpiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKpiApplication.class, args);
	}

	@Bean
	CommandLineRunner test(UserService userService) {
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception{
//				userService.printUserName();
//			}
//		};
		return args -> userService.printUserName(); // lambda expression
	}

}
@Component

class UserService {

	// 3 - Autowired - OK, don't do this
	@Autowired
	private UserRepository userRepository;
//	// Setter DI - Good
//	@Autowired
//	public void setUserRepository(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	//	// 1- Constructor, perfect Dependency Injection
//	public UserService(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}


	//	public UserService() {					   //
//		userRepository = new UserRepository(); // BAD
//	}										   //

	public void printUserName() {
		System.out.println(userRepository.getName());
	}
}
@Component
class UserRepository {
	public String getName() {
		return "Jack Sparrow";
	}
}

interface Logger {
	void log();
}

class TextFileLogger implements Logger {
	@Override
	public void log() {

	}
}

class DataBaseLogger implements Logger {
	@Override
	public void log() {

	}
}

class Client {
	OldComponent oldComponent;
	void test() {
		try {
			oldComponent.doSomething();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class OldComponent {
	// percent 0...100
	public int doSomething() throws IOException {
		return 0;
	}
}

class NewComponent extends OldComponent {

	// 1 - percent = 0..100 - OK
	// 2 - percent = 20..80 -
	// 3 - percent = -50..150 -
	@Override
	public int doSomething() throws FileNotFoundException {
		return 1;
	}
}

@Component
class Egg {
	Chicken chicken;
	@Autowired
	public void setChicken(Chicken chicken) {
		this.chicken = chicken;
	}

	//	public Egg(Chicken chicken) {
//		this.chicken = chicken; 	DOESN'T WORK
//	}
}
@Component
class Chicken {
	Egg egg;

	@Autowired
	public void setEgg(Egg egg) {
		this.egg = egg;
	}
//	public Chicken(Egg egg) {
//		this.egg = egg;				DOESN'T WORK
//	}
}
