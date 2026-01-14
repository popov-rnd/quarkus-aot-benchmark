package com.popovrnd.quarkusaotbenchmark.web.controller;

import com.popovrnd.quarkusaotbenchmark.web.request.EchoRequest;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/echo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EchoResource {

    private static final Logger log =
            LoggerFactory.getLogger(EchoResource.class);

    @POST
    public EchoRequest echo(@Valid EchoRequest request) {
        log.info("Echo controller with payload = {}", request);
        return request;
    }
}

