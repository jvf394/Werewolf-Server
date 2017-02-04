package fedor.games.werewolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * The jumping off place.
 */
@SpringBootApplication
@PropertySource(value = {"classpath:application.properties"})
public class Application {
	public static void main (String args[]) {
		System.out.println("Hello!");
		SpringApplication.run(Application.class, args);
	}
}
