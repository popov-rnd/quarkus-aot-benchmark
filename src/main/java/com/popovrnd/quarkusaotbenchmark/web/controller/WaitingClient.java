package com.popovrnd.quarkusaotbenchmark.web.controller;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/waiting")
@RegisterRestClient(baseUri = "http://127.0.0.1:8081")
public interface WaitingClient {

    @GET
    Uni<Response> waiting();
}
