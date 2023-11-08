package jdk.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 文件/流结尾异常
 * <p>
 * 1、适用于DataInputStream
 *
 * @see EOFException
 */
public class EOFExceptionTest {

    @Test
    // @Test(expected = EOFException.class)
    public void test() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutput output = new DataOutputStream(baos);
        output.writeByte(0x34);
        DataInput input = new DataInputStream(new ByteArrayInputStream(baos.toByteArray()));
        input.readLong();
    }

}
