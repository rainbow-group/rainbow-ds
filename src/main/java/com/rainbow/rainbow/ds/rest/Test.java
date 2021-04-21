package com.rainbow.rainbow.ds.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.rainbow.rainbow.ds.repo.TestRepo;


@Path("test")
public class Test {
	

	private TestRepo testRepo;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("t1")
	public Response test1() {
		testRepo = new TestRepo();
		return Response.status(Status.OK).entity(testRepo.test()).build();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("t2")
	public Response test2() {
		return Response.status(Status.OK).entity("aaaaaa").build();
	}

}
