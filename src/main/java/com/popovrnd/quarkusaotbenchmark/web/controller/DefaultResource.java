package com.popovrnd.quarkusaotbenchmark.web.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
public class DefaultResource {

    private static final Logger log =
            LoggerFactory.getLogger(DefaultResource.class);

    @GET
    public Response get() {
        log.info("Default is called!");
        return Response.ok().build();
    }
}

