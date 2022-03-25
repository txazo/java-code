package jdk.java.io;

import org.junit.Test;

import java.io.*;

/**
 * @see Closeable
 * @see AutoCloseable
 */
public class CloseableTest {

    @Test
    public void test() {
        CloseableResource resource = new CloseableResource();
        resource.close();
    }

    static class CloseableResource implements Closeable {

        @Override
        public void close() {
            System.out.println("CloseableResource close");
        }

    }

}
