package com.satya.rest.advancejaxrs.errors;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class UnAuthorizedExceptionMapper implements ExceptionMapper<UnAuthorizedException>{

	

	@Override
	public Response toResponse(UnAuthorizedException exception) {
		// TODO Auto-generated method stub
		return Response.status(Response.Status.UNAUTHORIZED).entity(new ErrorMessage(Response.Status.UNAUTHORIZED.getStatusCode(), "User Not Authorized")).build();
	}

}
