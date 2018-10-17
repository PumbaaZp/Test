package com.pro.CSV;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class GenerateCsv {
    public static void main(String[] args) {
        OutputStream outputStream = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            osw = new OutputStreamWriter(outputStream);
            bw = new BufferedWriter(osw);
            bw.append("中文测试").append(",");
            bw.newLine();
            bw.append("\t").append("中文测试2").append(",");
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                    bw = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                    osw = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}