package com.satya.rest.advancejaxrs;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/singleton/{pathParam}")

// URL to access: http://localhost:8080/advanced-jsxrs/webapi/singleton/Satyanand?query=queryValue


//@Singleton 

/* If we enable this singleton, then the Parms will not be injected as it belongs to request
 where as Singleton Resources are initialized before request and during app start up. So we get an error
 
 
 Error below:
 org.glassfish.jersey.server.model.ModelValidationException: Validation of the application 
 resource model has failed during application initialization.
[[HINT] Cannot create new registration for component type 
class org.glassfish.jersey.jsonb.internal.JsonBindingProvider: Existing previous registration 
found for the type.; source='null', [FATAL] Parameter pathParamValue of 
private java.lang.String com.satya.rest.advancejaxrs.SingletonResource.pathParamValue cannot be 
injected into singleton resource.; source='private java.lang.String 
com.satya.rest.advancejaxrs.SingletonResource.pathParamValue', [FATAL] 
Parameter queryParamValue of 
private java.lang.String com.satya.rest.advancejaxrs.SingletonResource.queryParamValue 
cannot be injected into singleton resource.; 
source='private java.lang.String com.satya.rest.advancejaxrs.SingletonResource.queryParamValue']
 
 */
public class SingletonResource {
	
	@PathParam("pathParam") private String pathParamValue;
	@QueryParam("query") private String queryParamValue;
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getParamValues(){
		return "Path Param: "+ pathParamValue + " and Query Param Value "+ queryParamValue;
	}
	
	

}
