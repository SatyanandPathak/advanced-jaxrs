package com.satya.rest.advancejaxrs.converters;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;


@Provider
@Produces("text/shortDate")
public class CustomShortDateMesdageBodyWriter implements MessageBodyWriter<Date>{

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		
		
		return Date.class.isAssignableFrom(type);
	}

	@Override
	public void writeTo(Date t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
	    MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
	    throws IOException, WebApplicationException {
		String myDate = t.getDate() + "-"+t.getMonth();
		entityStream.write(myDate.getBytes());
		
	}

	

}
