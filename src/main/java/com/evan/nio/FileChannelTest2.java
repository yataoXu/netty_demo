package com.evan.nio;

import java.io.File;
import java.nio.ByteBuffer;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Description
 * @ClassName FileChannelTest2
 * @Author Evan
 * @date 2020.06.09 20:32
 */
public class FileChannelTest2 {
    public static void main(String[] args) {
        File file = new File("a.txt");
        try (FileInputStream fis = new FileInputStream(file)) {

            FileChannel channel = fis.getChannel();
            //创建缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

            //将 通道的数据读入到Buffer
            channel.read(byteBuffer);
            //将byteBuffer 的 字节数据 转成String
            System.out.println(new String(byteBuffer.array()));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
