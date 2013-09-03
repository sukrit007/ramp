package com.meltmedia.ramp

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.PUT
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

import com.meltmedia.ramp.representation.UserRepresentation
import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;


@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])
class UserResource {

	def userResourceService
	def id

	@GET
	Response read() {
		Representation rep
		//RepresentationFactory rep;
		
		ok userResourceService.read(id)
	}

	@PUT
	Response update(UserRepresentation dto) {
		ok userResourceService.update(id, dto)
	}

	@DELETE
	void delete() {
		userResourceService.delete(id)
	}
}
