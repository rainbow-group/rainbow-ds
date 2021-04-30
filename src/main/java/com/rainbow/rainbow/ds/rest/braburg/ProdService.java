package com.rainbow.rainbow.ds.rest.braburg;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.rainbow.rainbow.ds.repo.barburg.ProdRepo;
import com.rainbow.rainbow.ds.rest.BaseService;
import com.rainbow.rainbow.ds.vo.barburg.Product;

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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list/{categoryId}")
	public Response getProdByCategory(@PathParam("categoryId") String categoryId) {
		prodRepo = new ProdRepo();
		List<Product> list = prodRepo.getActiveProdByCategory(categoryId);
		return Response.status(Status.OK).entity(this.getJsonStr(list)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{productId}")
	public Response getProdById(@PathParam("productId") String productId) {
		prodRepo = new ProdRepo();
		Product prod = prodRepo.getProdDetailById(productId);
		prod.setInfoList(prodRepo.getProdInfoListByProdId(productId));
		prod.setParamsList(prodRepo.getProdParamsListByProdId(productId));
		return Response.status(Status.OK).entity(this.getJsonStr(prod)).build();
	}

}
