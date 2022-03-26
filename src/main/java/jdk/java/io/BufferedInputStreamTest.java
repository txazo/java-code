package jdk.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流
 *
 * @see BufferedInputStream
 * @see BufferedOutputStream
 * @see BufferedReader
 * @see BufferedWriter
 */
public class BufferedInputStreamTest {

    @Test
    public void test() throws IOException {
        int bufferSize = 1024;
        try (InputStream inputStream = new BufferedInputStream(
                new FileInputStream("/Users/txazo/JavaProject/java-code/pom.xml"), bufferSize)) {
            while (inputStream.read(new byte[500]) > -1) {
                System.out.println("read 500 bytes");
            }
        }
    }

}
