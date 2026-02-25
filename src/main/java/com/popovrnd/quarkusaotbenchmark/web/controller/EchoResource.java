package com.popovrnd.quarkusaotbenchmark.web.controller;

import com.popovrnd.quarkusaotbenchmark.web.request.EchoRequest;
import com.popovrnd.quarkusaotbenchmark.web.request.EchoRequest300;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EchoResource {

    private static final Logger log =
            LoggerFactory.getLogger(EchoResource.class);

    // ~100 bytes payload
    @POST
    @Path("/echo")
    public EchoRequest echo(@Valid EchoRequest request) {
        //log.info("Echo controller with payload = {}", request);
        //log.info("Thread = {}", Thread.currentThread());
        return request;
    }

    // ~300 bytes payload
    @POST
    @Path("/echo-300")
    public EchoRequest300 echo300(@Valid EchoRequest300 request) {
        return request;
    }
}

