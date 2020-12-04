package io.quarkus.qe.ping.clients;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class HeaderGenerator {
    public static String lookupAuth() {
        return "Bearer asdsd";
    }
}
