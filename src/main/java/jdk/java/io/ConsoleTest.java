package jdk.java.io;

import java.io.*;

/**
 * 控制台
 *
 * @see Console
 */
public class ConsoleTest {

    /**
     * java jdk.java.io.ConsoleTest
     */
    public static void main(String[] args) {
        String line;
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("Console is null");
        }
        for (; ; ) {
            console.printf("请输入: ");
            line = console.readLine();
            if ("exit".equals(line)) {
                console.printf("exit!").printf("\n");
                break;
            }
            console.printf("机器人: ").printf(line).printf("\n");
        }
    }

}
