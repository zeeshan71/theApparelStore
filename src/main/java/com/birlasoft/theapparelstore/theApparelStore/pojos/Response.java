package com.birlasoft.theapparelstore.theApparelStore.pojos;

public class Response {
	
	private String message;
	private int status;
	private Object payload;
	
	public Response() {
		// TODO Auto-generated constructor stub
	}

	public Response(String message, int status, Object payload) {
		super();
		this.message = message;
		this.status = status;
		this.payload = payload;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}
	
	

}
