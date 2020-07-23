package com.evan.bio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @ClassName TryWithSource
 * @Author Evan
 * @date 2020.06.09 19:22
 */
public class TryWithSource {
    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = new FileInputStream(new File("D://evan.txt"));
            System.out.println(is.read());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
        }

        // ----------try-with-resource------------------
        try (FileInputStream is1 = new FileInputStream(new File("D://evan.txt"));) {
            System.out.println(is.read());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
