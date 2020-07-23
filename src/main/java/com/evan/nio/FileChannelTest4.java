package com.evan.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description
 * @ClassName FileChannelTest3
 * @Author Evan
 * @date 2020.06.09 22:29
 */
public class FileChannelTest4 {
    public static void main(String[] args) {

        File file = new File("a.jpg");
        try (FileInputStream fis = new FileInputStream(file)) {
            try (FileOutputStream fos = new FileOutputStream("b.jpg")) {

                FileChannel source = fis.getChannel();
                FileChannel dest = fos.getChannel();

                //使用transferForm完成拷贝
                dest.transferFrom(source, 0, source.size());

            } catch (Exception e) {
                e.getStackTrace();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}