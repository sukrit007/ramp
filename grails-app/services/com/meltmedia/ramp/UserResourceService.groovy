package com.meltmedia.ramp

import org.grails.jaxrs.provider.DomainObjectNotFoundException

import com.meltmedia.ramp.representation.UserRepresentation;


import static com.meltmedia.ramp.representation.UserRepresentation.*

class UserResourceService {

    def create(UserRepresentation dto) {
        toUser(dto).save()
    }

    def read(id) {
        def obj = User.get(id)
        if (!obj) {
            throw new DomainObjectNotFoundException(User, id)
        }
        fromUser obj
    }

    def readAll() {
        User.findAll().collect { fromUser it}
    }

    def update(id, UserRepresentation dto) {
        def obj = User.get(id)
        if (!obj) {
            throw new DomainObjectNotFoundException(User, dto.id)
        }
        obj.properties = toUser(dto).properties
        fromUser obj
    }

    void delete(id) {
        def obj = User.get(id)
        if (obj) {
            obj.delete()
        }
    }
}
