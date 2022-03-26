package jdk.java.io;

import org.junit.Test;

import java.io.*;

/**
 * JVM退出钩子删除文件
 * <p>
 * 1、大量的deleteOnExit，有内存溢出风险
 * <p>
 * // @see DeleteOnExitHook
 */
public class DeleteOnExitHookTest {

    @Test
    public void test() throws Exception {
        File file = new File("/Users/txazo/JavaProject/java-code/DeleteOnExitHook.txt");
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write("DeleteOnExitHook".getBytes());
        }
        file.deleteOnExit();
        Thread.sleep(5000);
    }

}
