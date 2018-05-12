package com.satya.rest.advancejaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/secured")
public class SecuredResource {
	
	
	@Path("message")
	@GET
	public String getMessage(){
		return "Secured Message";
	}

}
