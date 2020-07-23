package com.evan.nio;

import java.nio.IntBuffer;

/**
 * @Description
 * @ClassName BasicBuffer
 * @Author Evan
 * @date 2020.06.09 16:47
 */
public class BasicBuffer {
    public static void main(String[] args) {

        // 创建一个缓冲区，大小为5。即可以存放5个int
        IntBuffer allocate = IntBuffer.allocate(5);

        // 存放数据
        for (int i = 0; i < allocate.capacity(); i++) {
            allocate.put(i);

        }

        //如何从buffer读取数据
        //将buffer转换，读写切换(!!!)
        /*
        public final Buffer flip() {
        limit = position; //读数据不能超过5
        position = 0;
        mark = -1;
        return this;
    }
         */
        allocate.flip();
        allocate.position(1);//1,2
//        System.out.println(allocate.get());
        allocate.limit(3);
        while (allocate.hasRemaining()) {
            System.out.println(allocate.get());
        }
    }
}
