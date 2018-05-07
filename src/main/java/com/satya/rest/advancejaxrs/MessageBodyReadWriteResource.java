package com.satya.rest.advancejaxrs;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messagebodydemo")
public class MessageBodyReadWriteResource {
	
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public Date getDate(){
		return Calendar.getInstance().getTime();
	}

}
