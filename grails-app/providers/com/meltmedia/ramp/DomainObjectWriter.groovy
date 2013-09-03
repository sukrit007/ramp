package com.meltmedia.ramp

import grails.converters.JSON
import grails.converters.XML

import java.lang.annotation.Annotation
import java.lang.reflect.Type

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

import org.grails.jaxrs.support.DomainObjectWriterSupport

import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory

@Provider
@Produces(['text/xml', 'application/xml', 'text/x-json', 'application/json'])
class DomainObjectWriter extends DomainObjectWriterSupport {
	
	static def representationFactory = new StandardRepresentationFactory().withFlag(RepresentationFactory.PRETTY_PRINT).withLink("website", "http://gotohal.net");
	
	
	boolean isWriteable(Class type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return true;
	}

	protected Object writeToXml(Object obj, OutputStream entityStream, String charset) {
		def xml = obj as XML;
		xml.render(new OutputStreamWriter(entityStream));
	}

	protected Object writeToJson(Object obj, OutputStream entityStream, String charset) {
		
		//if (! obj instanceof Representation) {
			def representation = representationFactory.newRepresentation();
			obj = representation.withBean(obj)
		//}
		//print obj.toString()
		def writer= new OutputStreamWriter(entityStream)
		writer.with {
			write(obj.toString("application/hal+json"))
			close()
		}
		//def json = representation
		//json.render(new OutputStreamWriter(entityStream));
	}
}