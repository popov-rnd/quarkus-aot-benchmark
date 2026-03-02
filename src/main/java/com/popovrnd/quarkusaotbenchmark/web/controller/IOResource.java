package com.popovrnd.quarkusaotbenchmark.web.controller;

import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path("/io")
public class IOResource {

    private static final Logger log =
            LoggerFactory.getLogger(IOResource.class);

    private static final String WAITING_URI = "http://127.0.0.1:8081/waiting";

    // Single reusable client (transport-neutral baseline)
    private static final HttpClient CLIENT =
            HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();

    // Reusable immutable request
    private static final HttpRequest REQUEST =
            HttpRequest.newBuilder()
                    .uri(URI.create(WAITING_URI))
                    .GET()
                    .build();

    @RestClient
    WaitingClient waitingClient;

    @GET
    public Uni<Response> getNonBlocking() {

        log.info("IO is called! Async signature. Thread = {}", Thread.currentThread());

        return waitingClient.waiting()
                .map(r -> (r.getStatus() == 200)
                        ? Response.ok().build()
                        : Response.status(500).build());
    }


    // Synchronous signature => runs on worker thread by default
    /*@GET
    @RunOnVirtualThread
    public Response getBlocking() throws Exception {

        //log.info("IO is called! Synchronous signature. Thread = {}", Thread.currentThread());

        int sc = CLIENT.send(REQUEST, HttpResponse.BodyHandlers.discarding()).statusCode();

        return sc == 200 ? Response.ok().build() : Response.status(500).build();
    }*/

}

