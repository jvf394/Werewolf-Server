package fedor.games.werewolf.resources;

import fedor.games.werewolf.entities.Greeting;
import fedor.games.werewolf.entities.HelloMessage;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 *
 */
@Controller
public class GreetingController {
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message, @Headers Map<String, Object> headerMap) throws Exception {
		System.out.println(headerMap);
		Thread.sleep(500); // simulated delay
		return new Greeting("Hello, " + message.getName() + "!");
	}
}
