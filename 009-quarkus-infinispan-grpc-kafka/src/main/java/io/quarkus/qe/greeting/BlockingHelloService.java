package io.quarkus.qe.greeting;

import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.grpc.stub.StreamObserver;
import io.quarkus.example.GreeterGrpc;
import io.quarkus.example.HelloReply;
import io.quarkus.example.HelloRequest;
import io.smallrye.common.annotation.Blocking;

@Singleton
public class BlockingHelloService extends GreeterGrpc.GreeterImplBase {

    @Inject
    SomeService service;

    @ActivateRequestContext
    @Blocking
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        responseObserver.onNext(HelloReply.newBuilder().setMessage(service.checkBlockingThreads()).build());
        responseObserver.onCompleted();
    }
}