package fedor.games.werewolf.services;

import fedor.games.werewolf.entities.Game;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;

/**
 *
 */
@Service
public class GameService {
	private HashMap<Integer, Game> games = new HashMap<>();

	public GameService() {
		System.out.println("Game Service");
	}

	public void createGame(WebSocketSession session) {
		System.out.println("Service");
		games.put(1, new Game(session));
	}

	public Game getGame(WebSocketSession session) {
		return games.get(1);
	}

	@Override
	public String toString() {
		return "GameService{" +
				"games=" + games +
				'}';
	}
}
