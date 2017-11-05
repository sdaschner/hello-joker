package com.sebastian_daschner.hello_joker;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("hello")
public class HelloResource {

    @Inject
    Greetings greetings;

    @GET
    public String hello() {
        return greetings.hello();
    }

    @GET
    @Path("{name}")
    public String hello(@PathParam("name") String name) {
        return greetings.hello(name);
    }

}
