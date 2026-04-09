package com.popovrnd.quarkusaotbenchmark.web.controller;

import com.popovrnd.quarkusaotbenchmark.web.request.IngestRequest;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
public class IngestResource {

    private static final Logger log =
            LoggerFactory.getLogger(IngestResource.class);

    @POST
    @Path("/ingest")
    public Response ingest(@Valid IngestRequest request) {
        //log.info("Ingest body, thread = {}, request = {}", Thread.currentThread(), request);
        return Response.noContent().build();
    }
}

