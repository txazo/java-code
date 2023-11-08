package jdk.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 数据类型转换流，字节流 <> 基本数据类型、String
 *
 * @see java.io.DataInput
 * @see java.io.DataOutput
 * @see java.io.DataInputStream
 * @see java.io.DataOutputStream
 */
public class DataInputTest {

    @Test
    public void test() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutput output = new DataOutputStream(baos);
        output.writeByte(0x34);
        output.writeUTF("Data中文Stream");
        DataInput input = new DataInputStream(new ByteArrayInputStream(baos.toByteArray()));
        System.out.println(input.readByte());
        System.out.println(input.readUTF());
    }

}
