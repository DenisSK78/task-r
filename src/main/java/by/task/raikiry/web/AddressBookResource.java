package by.task.raikiry.web;

import by.task.raikiry.entity.Person;
import by.task.raikiry.service.EmailService;
import by.task.raikiry.service.PersonService;
import by.task.raikiry.service.PhoneService;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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

    @Inject
    private EmailService emailService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPerson() {
        List<Person> people = personService.getAll();
        return Response.status(200)
                .entity(people).build();
    }

    @Path("person/{personId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("personId") Long personId) {
        Person person = personService.getById(personId);
        return Response.status(200)
                .entity(person).build();
    }

    @Path("/person/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response putPerson(Person person) {
        Boolean up = personService.update(person);
        Person upPerson = personService.getById(person.getId());
        return Response.status(200)
                .entity(upPerson).build();
    }

    @Path("/phone/{phoneId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePhone(@PathParam("phoneId") Long phoneId) {
        phoneService.delete(phoneId);
        return Response.status(200).build();
    }
}
