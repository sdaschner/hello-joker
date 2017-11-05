package com.sebastian_daschner.hello_joker;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class GreetingProcessor {

    private Client client;
    private WebTarget target;

    @PostConstruct
    private void initClient() {
        client = ClientBuilder.newClient()
                .property("http.connection.timeout", 200)
                .property("http.receive.timeout", 1000);
        target = client.target("http://joker-greetings:8080/joker-greetings/resources/greetings");
    }

    @FailureToNull
    public String calculateGreeting(String name) {
        return target.path(name)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get()
                .readEntity(JsonObject.class)
                .getString("greeting", null);
    }

    @PreDestroy
    private void closeClient() {
        client.close();
    }

}
