package com.rainbow.rainbow.ds.rest.braburg;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.rainbow.rainbow.ds.repo.barburg.ProdRepo;
import com.rainbow.rainbow.ds.rest.BaseService;

@Path("prod")
public class ProdService extends BaseService {

	private ProdRepo prodRepo;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("categories")
	public Response getCategories() {
		prodRepo = new ProdRepo();
		return Response.status(Status.OK).entity(this.getJsonStr(prodRepo.getCategories())).build();
	}

}
