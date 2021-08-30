package io.basc.start.example.ws;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import io.basc.framework.logger.Logger;
import io.basc.framework.logger.LoggerFactory;


@ServerEndpoint(value="/websocket")
public class WebSocketEndpoint extends Endpoint{
	private static Logger logger = LoggerFactory.getLogger(WebSocketEndpoint.class);
	
	@Override
	public void onOpen(Session session, EndpointConfig config) {
		logger.info("open [{}] config [{}]", session.toString(), config.toString());
	}
	
	@OnMessage
	public void onMessage(String message){
		logger.info("message: {}", message);
	}
	
	@Override
	public void onClose(Session session, CloseReason closeReason) {
		logger.info("close [{}] reason [{}]", session.toString(), closeReason);
		super.onClose(session, closeReason);
	}
	
	@Override
	public void onError(Session session, Throwable throwable) {
		logger.error(throwable, "error [{}]", session.toString());
		super.onError(session, throwable);
	}
}
