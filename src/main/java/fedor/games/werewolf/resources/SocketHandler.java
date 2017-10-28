package fedor.games.werewolf.resources;

import fedor.games.werewolf.entities.Game;
import fedor.games.werewolf.entities.Player;
import fedor.games.werewolf.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 *
 */
@Component
public class SocketHandler extends TextWebSocketHandler {

	@Autowired
	private GameService gameService;

//	@Autowired
//	public SocketHandler (GameService gameService) {
//		this.gameService = gameService;
//		System.out.println(gameService);
//	}

	public SocketHandler() {
		System.out.println("Loading");
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		try {
			System.out.println(message);
			System.out.println(session);
			System.out.println(gameService);
			gameService.createGame(session);
			System.out.println("Game");
			session.sendMessage(new TextMessage("!!" + message.getPayload() + "!!"));
			Game game = gameService.getGame(session);
			int i = 1;
			for (Player player : game.getPlayers()) {
				System.out.println(player.getSession().getId());
				player.getSession().sendMessage(new TextMessage(i + ""));
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
