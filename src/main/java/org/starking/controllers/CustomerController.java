package org.starking.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.starking.dtos.CustomerDTO;
import org.starking.services.CustomerService;

@Path("/api/customers")
public class CustomerController {

	@Inject
	private CustomerService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CustomerDTO> findAll() {
		return this.service.findAll();
	}
	
	@POST
	@Transactional
	public Response saveCustomer(CustomerDTO dto) {
		try {
			this.service.createNewCustomer(dto);
			return Response.ok().build();
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@PUT
	@Path("/{id}")
	@Transactional
	public Response changeCustomer(@PathParam("id") Long id, CustomerDTO dto) {
		try {
			this.service.changeCustomer(id, dto);
			return Response.noContent().build();
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
