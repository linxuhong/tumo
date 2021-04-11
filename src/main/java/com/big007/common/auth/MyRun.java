package com.big007.common.auth;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;

public class MyRun implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String strFilePath = "big007.txt";
        File file = new File(strFilePath);
        if(file.exists()== false) {
            file.createNewFile();
        }

        Process p = Runtime.getRuntime().exec("attrib +H " + strFilePath);
        byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
    }
}
