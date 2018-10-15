package by.task.raikiry.web;

import by.task.raikiry.entity.Person;
import by.task.raikiry.entity.Phone;
import by.task.raikiry.service.PersonService;
import by.task.raikiry.service.PhoneService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/address-book")
public class AddressBookResource {

    @Inject
    private PersonService personService;

    @Inject
    private PhoneService phoneService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPerson() {
        final List<Person> people = personService.getAll();
        return Response.ok(people).build();
    }

    @Path("/{personId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("personId") final Long personId) {
        final Person tutorial = personService.getById(personId);
        return Response.ok(tutorial).build();
    }

    @Path("/phones")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPhone() {
        final List<Phone> people = phoneService.getAll();
        return Response.ok(people).build();
    }
}
