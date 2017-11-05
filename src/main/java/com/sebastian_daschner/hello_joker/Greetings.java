package com.sebastian_daschner.hello_joker;

import javax.inject.Inject;

public class Greetings {

    @Inject
    GreetingProcessor greetingProcessor;

    public String hello() {
        return "From Saint Petersburg with <3";
    }

    public String hello(String name) {
        return greetingProcessor.calculateGreeting(name);
    }
}
