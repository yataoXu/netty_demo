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
public class FileChannelTest3 {
    public static void main(String[] args) {

        File file = new File("a.txt");
        try (FileInputStream fis = new FileInputStream(file)) {
            try (FileOutputStream fos = new FileOutputStream("b.txt")) {

                FileChannel fileChannel01 = fis.getChannel();
                FileChannel fileChannel02 = fos.getChannel();

                ByteBuffer byteBuffer = ByteBuffer.allocate(100);

                while (true) { //循环读取

                    //这里有一个重要的操作，一定不要忘了
                    /*
                     public final Buffer clear() {
                        position = 0;
                        limit = capacity;
                        mark = -1;
                        return this;
                    }
                     */
                    byteBuffer.clear(); //清空buffer
                    int read = fileChannel01.read(byteBuffer);
                    System.out.println("read =" + read);
                    if (read == -1) { //表示读完
                        break;
                    }
                    //将buffer 中的数据写入到 fileChannel02 -- 2.txt
                    byteBuffer.flip();
                    fileChannel02.write(byteBuffer);
                }


            } catch (Exception e) {
                e.getStackTrace();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }


    }
}