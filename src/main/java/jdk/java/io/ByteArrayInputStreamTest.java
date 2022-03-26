package jdk.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 内存流
 *
 * @see ByteArrayInputStream，从byte[]读取数据
 * @see ByteArrayOutputStream，写入数据到byte[]
 * @see CharArrayReader
 * @see CharArrayWriter
 */
public class ByteArrayInputStreamTest {

    @Test
    public void test() {
        byte b;
        String data = "ByteArrayInputStream";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        while ((b = (byte) inputStream.read()) != -1) {
            System.out.println(b);
        }
    }

}
