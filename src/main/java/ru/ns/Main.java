package ru.ns;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.IOException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws IOException {
        String source = "D:\\Users\\foxwi\\Downloads\\target.zip";
        String destination = "D:\\Users\\foxwi\\Downloads\\fol";
        byte[] src = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        byte[] password = new byte[6];


        ZipFile zipFile = new ZipFile(source);
        for (int i = 0; i < src.length; i++){
            password[0] = src[i];
            for (int j = 0; j < src.length; j++){
                password[1] = src[j];
                for (int k = 0; k < src.length; k++){
                    password[2] = src[k];
                    for (int p = 0; p < src.length; p++){
                        password[3] = src[p];
                        for (int q = 0; q < src.length; q++){
                            password[4] = src[q];
                            for (int y = 0; y < src.length; y++){
                                password[5] = src[y];
                                byte[] realPass = Base64.getEncoder().encode(password);

                                boolean ex = false;
                                try {
                                    zipFile.setPassword(new String(realPass).toCharArray());
                                    zipFile.extractAll(destination);
                                } catch (IOException ignored) {
                                    ex = true;
                                }

                                if (!ex) {
                                    System.out.println("SUCCESS");
                                    zipFile.close();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(i);
        }

        zipFile.close();
    }
}