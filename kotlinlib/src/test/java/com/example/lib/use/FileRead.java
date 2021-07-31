package com.example.lib.use;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileRead {

    public static void read() {
        //Java 实现
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream("/home/test.txt");
            dis = new DataInputStream(new BufferedInputStream(fis));
            String lines = "";
            while ((lines = dis.readLine()) != null) {
                System.out.println(lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null)
                    dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
