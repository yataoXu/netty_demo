package com.evan.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description
 * @ClassName FileChannelTest
 * @Author Evan
 * @date 2020.06.09 20:20
 */
public class FileChannelTest {
    public static void main(String[] args) {

        String str = "hello file channel";

        try(FileOutputStream fos = new FileOutputStream("a.txt")){

            //通过 fileOutputStream 获取 对应的 FileChannel
            //这个 fileChannel 真实 类型是  FileChannelImpl
            FileChannel fileChannel = fos.getChannel();

            //创建一个缓冲区 ByteBuffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //将 str 放入 byteBuffer
            byteBuffer.put(str.getBytes());

            //对byteBuffer 进行flip
            byteBuffer.flip();

            //将byteBuffer 数据写入到 fileChannel
            fileChannel.write(byteBuffer);

        }catch (IOException e) {
            e.getStackTrace();
        }
    }
}
