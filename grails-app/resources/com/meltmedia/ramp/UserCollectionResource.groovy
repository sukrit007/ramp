package com.meltmedia.ramp

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

import com.meltmedia.ramp.representation.UserRepresentation

@Path('/api/users')
@Consumes(['application/json'])
@Produces(['application/json'])
class UserCollectionResource {

	def userResourceService

	@POST
	Response create(UserRepresentation dto) {
		created userResourceService.create(dto)
	}

	@GET
	Response readAll() {
		ok userResourceService.readAll()
	}

	@Path('/{id}')
	UserResource getResource(@PathParam('id') Long id) {
		new UserResource(userResourceService: userResourceService, id:id)
	}
}
