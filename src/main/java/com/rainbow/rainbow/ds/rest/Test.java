package com.rainbow.rainbow.ds.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("test")
public class Test {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("t1")
	public Response test1() {
		return Response.status(Status.OK).entity("good").build();
	}

}
