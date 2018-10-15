package by.task.raikiry.web;

import by.task.raikiry.entity.Person;
import by.task.raikiry.service.PersonService;

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

//    @Context HttpHeaders headers

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById() {
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
}
