package io.quarkus.qe.hello;

import java.io.RandomAccessFile;

public class GenerateLargeFile {
    public static void main(String args[]) throws Exception {

        // args[0] is expected to be something like /Users/rsvoboda/git/beefy-scenarios/scenario-201-static/target/classes
        RandomAccessFile f = new RandomAccessFile(args[0] + "/META-INF/resources/big-file", "rw");
        f.setLength(1024 * 1024 * 1024);
    }
}
