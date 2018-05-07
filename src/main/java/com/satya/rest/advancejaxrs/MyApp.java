package com.satya.rest.advancejaxrs;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("webapi")
public class MyApp extends Application {

	public Set<Class<?>> getClasses() {
		return super.getClasses();
	}
}
