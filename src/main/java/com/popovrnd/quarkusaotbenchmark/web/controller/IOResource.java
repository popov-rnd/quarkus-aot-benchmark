package com.popovrnd.quarkusaotbenchmark.web.controller;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/io")
public class IOResource {

    private static final Logger log =
            LoggerFactory.getLogger(IOResource.class);

    @RestClient
    WaitingClient waitingClient;

    @GET
    public Uni<Response> getNonBlocking() {

        //log.info("IO is called! Thread = {}", Thread.currentThread());

        return waitingClient.waiting()
                .map(r -> (r.getStatus() == 200)
                        ? Response.ok().build()
                        : Response.status(500).build());
    }
}

