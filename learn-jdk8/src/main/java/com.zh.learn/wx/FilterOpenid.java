package com.zh.learn.wx;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-14
 */
public class FilterOpenid {

    public static void main(String[] args) {

        String filePath = "/Users/kevin/Desktop/all_openid.txt";

        HashSet<String> hashSet = new HashSet<>();

        File file = new File(filePath);
        try {
            for (String readLine : FileUtils.readLines(file, Charset.forName("UTF-8"))) {
                readLine = readLine.replaceAll("\n", "");
                if (!hashSet.contains(readLine)) {
                    hashSet.add(readLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        String filePath2 = "/Users/kevin/Desktop/all_openid_filter.txt";
        File file2 = new File(filePath2);

        System.out.println(hashSet.size());

        int count = 0;

        for (String s : hashSet) {
            if (StringUtils.isNotBlank(s)) {
                try {
                    FileUtils.write(file2, s + "\n", Charset.forName("UTF-8"), true);
                    count++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(count == 2239050);

    }

}
