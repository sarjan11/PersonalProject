package com.saran;

import javax.ws.rs.GET; 

/*
Annotation	Description
@PATH(your_path)	 Sets the path to base URL + /your_path. The base URL is based on your application name, the servlet and the URL pattern from the web.xml configuration file.
@POST	 Indicates that the following method will answer to an HTTP POST request.
@GET	 Indicates that the following method will answer to an HTTP GET request.
@PUT	 Indicates that the following method will answer to an HTTP PUT request.
@DELETE	 Indicates that the following method will answer to an HTTP DELETE request.
@Produces(MediaType.TEXT_PLAIN[, more-types])	 @Produces defines which MIME type is delivered by a method annotated with @GET. In the example text ("text/plain") is produced. Other examples would be "application/xml" or "application/json".
@Consumes(type[, more-types])	 @Consumes defines which MIME type is consumed by this method.
@PathParam	 Used to inject values from the URL into a method parameter. This way you inject, for example, the ID of a resource into the method to get the correct object.
*/
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;  
   
@Path("ConversionService")  
public class FeetToInchAndInchToFeetConversionService {  
     @GET  
     @Path("/InchToFeet/{i}")  
      @Produces(MediaType.TEXT_XML)  
      public String convertInchToFeet(@PathParam("i") int i) {  
   
        int inch=i;  
        double feet = 0;  
        feet =(double) inch/12;  
        
        return "<InchToFeetService>"  
        + "<Inch>" + inch + "</Inch>"  
          + "<Feet>" + feet + "</Feet>"  
         + "</InchToFeetService>";  
      }  
   
      @Path("/FeetToInch/{f}")  
      @GET  
      @Produces(MediaType.TEXT_XML)  
      public String convertFeetToInch(@PathParam("f") int f) {  
       int inch=0;  
          int feet = f;  
          inch = 12*feet;  
     
          return "<FeetToInchService>"  
            + "<Feet>" + feet + "</Feet>"  
            + "<Inch>" + inch + "</Inch>"  
            + "</FeetToInchService>";  
      }  
}  

