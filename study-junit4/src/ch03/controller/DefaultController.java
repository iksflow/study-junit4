package ch03.controller;

import java.util.HashMap;
import java.util.Map;

public class DefaultController implements Controller {
	private Map requestHandlers = new HashMap();
	
	protected RequestHandler getHandler(Request request) {
		if (!this.requestHandlers.containsKey(request.getName())) {
			String message = "Cannot find handler for request name" + "[" + request.getName() + "]";
			throw new RuntimeException(message);
		}
		
		return (RequestHandler) this.requestHandlers.get(request.getName());
	}
	
	@Override
	public Response processRequest(Request request) {
		Response response;
		try {
			response = getHandler(request).process(request);
		} catch (Exception exception) {
			response = new ErrorResponse(request, exception);
		}
		return response;
		// TODO Auto-generated method stub
	}

	@Override
	public void addHandler(Request request, RequestHandler requestHandler) {
		// TODO Auto-generated method stub
		if (this.requestHandlers.containsKey(request.getName())) {
			throw new RuntimeException("A request handler has " 
					+ "already been registered for request name "
					+ "[" + request.getName() + "]");
		} else {
			this.requestHandlers.put(request.getName(),
					requestHandler);
		}
	}

}
