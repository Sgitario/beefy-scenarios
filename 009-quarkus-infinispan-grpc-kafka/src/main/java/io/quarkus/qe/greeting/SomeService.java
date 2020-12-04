package io.quarkus.qe.greeting;

import javax.enterprise.context.RequestScoped;

import io.quarkus.runtime.BlockingOperationControl;

@RequestScoped
public class SomeService {
    public String checkBlockingThreads() {
        return "Can be blocked? " + BlockingOperationControl.isBlockingAllowed();
    }
}
