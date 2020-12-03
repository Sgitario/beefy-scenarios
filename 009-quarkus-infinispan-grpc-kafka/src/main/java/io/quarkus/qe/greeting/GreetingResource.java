package io.quarkus.qe.greeting;

import java.time.Duration;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.example.GreeterGrpc;
import io.quarkus.example.HelloRequest;
import io.quarkus.example.MutinyGreeterGrpc;
import io.quarkus.grpc.runtime.annotations.GrpcService;

@Path("/hello")
public class GreetingResource {

    @Inject
    @GrpcService("hello")
    GreeterGrpc.GreeterBlockingStub blockingClient;

    @Inject
    @GrpcService("hello")
    MutinyGreeterGrpc.MutinyGreeterStub mutinyClient;

    @GET
    @Path("/blocking/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String blockingHello(@PathParam("name") String name) {
        return blockingClient.sayHello(HelloRequest.newBuilder().setName(name).build()).getMessage();
    }

    @GET
    @Path("/mutiny/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        return mutinyClient.sayHello(HelloRequest.newBuilder().setName(name).build())
                .await().atMost(Duration.ofSeconds(1)).getMessage();
    }
}