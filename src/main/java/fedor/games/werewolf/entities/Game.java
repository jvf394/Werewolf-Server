package fedor.games.werewolf.entities;

import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Game {
	private int id;
	private List<Player> players = new ArrayList<>();

	public Game(WebSocketSession session) {
		Player player = new Player();
		player.setSession(session);
		players.add(player);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
}
