package fedor.games.werewolf.entities;

import org.springframework.web.socket.WebSocketSession;

/**
 * This or the other Player class should be refactored to prevent confusion.
 */
@Deprecated
public class Player {
	private WebSocketSession session;

	public WebSocketSession getSession() {
		return session;
	}

	public void setSession(WebSocketSession session) {
		this.session = session;
	}
}
