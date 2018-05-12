package com.satya.rest.advancejaxrs.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

import com.satya.rest.advancejaxrs.errors.UnAuthorizedException;


@Provider
public class SecurityFilter implements ContainerRequestFilter{

	private static final String AUTH_HEADER = "Authorization";
	private static final String AUTH_TOKEN_PREFIX = "Basic ";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		
		if (!requestContext.getUriInfo().getPath().contains("secured")){
			return;
		}
		
		
		List<String> authHeaders = requestContext.getHeaders().get(AUTH_HEADER);
		
		if(authHeaders != null && authHeaders.size() > 0){
			String authToken = authHeaders.get(0);
			authToken = authToken.replaceFirst(AUTH_TOKEN_PREFIX, "");
			String decodedString = Base64.decodeAsString(authToken);
			StringTokenizer token = new StringTokenizer(decodedString, ":");
			String userName = token.nextToken();
			String password = token.nextToken();
			
			
			
			
			if ("user".equals(userName) && "password".equals(password)){
				return;
			}
			
//			Response unauthorizedResponse = Response
//																					.status(Response.Status.NOT_FOUND)
//																					.entity("Resource Not Found")
//																					.build();
			
			throw new UnAuthorizedException();
			
			//requestContext.abortWith(unauthorizedResponse);
			
		}
		
	}

}
