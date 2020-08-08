package com.toutou.sample.book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author toutou
 * @date by 2020/07
 * @des
 */
public class TestZip {
    public static void main( String[] args ) {
        try {
            ZipInputStream zin = new ZipInputStream(new FileInputStream("zip.zip"));
            ZipEntry entry;
            try {
                while ((entry = zin.getNextEntry()) != null) {
                    //InputStream in = zin.get
                }
            }catch(IOException e){
                System.out.println(e.toString());
            }
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
    }
}
