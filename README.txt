Rest Web Services:

1.	Extends Application from jaxrs makes a class as a rest app
2.	@ApplicationPath(“webapi”) sets the application context path
3.	 By default each Resource in JAX-RS is created per request
4.	We can have singleton Resource as well by marking the Resource class as @Singleton
5.	@Params can be accessed through member variables
6.	If we make a Resource as Singleton and declare member variables with Path or Query or any @Param or @Context, it fails during the initialization. This is because Singleton Resource creation happens during application startup  and before the request, and so those member variables cannot be injected as they are related to request

Param Converters

1.	Involves conversion of data type for the Params values
2.	We can create our own Custom Converters to convert from and to custom objects
3.	ParamConveter interface does that
4.	Implement ParamConverterProvider which has two methods to convert from and to the object


Message Body Readers and Message Body Writers:

1.	Converts raw request and response from and to JAXRS and Raw Type
2.	ParamConverters converts the Params


Custom Message Body Writers:
1. Implement MessageBodyWriter<T> and put @Provider annotation

Filters:
1. We use filter for cross cutting concern for Ex: logging after each Request and/or Response
2. Implement ContainerRequestFilter and ContainerResponseFilter

Auth:
1. Basic Auth. Suitable only for SSL or HTTPS. Base64.(encodeusername:password).
2. It is encoded but not secured. It can easly be decoded and details can be hacked
3. Other options are:
	 a. Digest Access Auth(MD5 Hashing) 
	 b. Assymetric Cryptography(Public and Private Key) 
	 3. OAuth 
	 4. JSON Web Tokens





Important Links:

Base URL: http://localhost:8080/advanced-jsxrs/webapi
Date Resource: http://localhost:8080/advanced-jsxrs/webapi/date/today
Singleton Demo: http://localhost:8080/advanced-jsxrs/webapi/singleton/pathParam?query=queryParam
Custom Message Writer Demo: http://localhost:8080/advanced-jsxrs/webapi/messagebodydemo/customMediaType
							Accept: text/shortDate or text/plain





