package com.zh.learn.wx.convert;


import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-16
 */
public class ConvertUnionId {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConvertUnionId.class);

    public static void main(String[] args) throws NoSuchAlgorithmException {

        int count = 0;
        int count1 = 0;

        final String filePath = "/Users/kevin/Desktop/all_openid_unionid.txt";

        final String filePath2 = "/Users/kevin/Desktop/all_openid_unionid_urs.txt";

        final File file2 = new File(filePath2);

        List<String> openidFromDisk = readOpenidFromDisk(filePath);

        if (CollectionUtils.isNotEmpty(openidFromDisk)) {

            for (String line : openidFromDisk) {

                String[] strings = line.split("\t");

                if (!strings[1].equals("null")) {

                    String urs = weixinUnionIdToUid(strings[1]);
                    urs = urs + "@wx.163.com";

                    try {
                        FileUtils.write(file2, strings[0] + "\t" + strings[1] + "\t" + urs + "\n", Charset.forName("UTF-8"), true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {

                    LOGGER.info("openid={}: nid is null.", strings[0]);
                    count1++;

                    try {
                        FileUtils.write(file2, strings[0] + "\t" + strings[1] + "\t" + "null" + "\n", Charset.forName("UTF-8"), true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                count++;

                if (count % 20000 == 0) {

                    LOGGER.info("has down " + count);
                }
            }

        }

        System.out.println(count);
        System.out.println(count1);


    }

    public static List<String> readOpenidFromDisk(String filePath) {

        if (StringUtils.isBlank(filePath)) {
            return null;
        }

        ArrayList<String> list = Lists.newArrayList();

        File file = new File(filePath);

        try {
            for (String readLine : FileUtils.readLines(file, Charset.forName("UTF-8"))) {
                readLine = readLine.replaceAll("\n", "");
                list.add(readLine);
            }
            LOGGER.info("read form disk over. all openid count = " + list.size());
            return list;
        } catch (IOException e) {
            LOGGER.error("error", e);
            return null;
        }

    }


    public static String weixinUnionIdToUid(String unionid) throws NoSuchAlgorithmException {
        String uid = null;
        String suffix = unionid;
        if (StringUtils.isNotBlank(unionid)) {
            if (unionid.length() > 10) {
                suffix = unionid.substring(0, 10);
            }
            uid = suffix.replace("-", "_") + convertToMd5(unionid);
            return uid;
        }
        return "";
    }

    public static String convertToMd5(String str) throws NoSuchAlgorithmException {

        byte newByte1[] = str.getBytes();
        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
        byte newByte2[] = messagedigest.digest(newByte1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < newByte2.length; i++) {
            String temp = Integer.toHexString(newByte2[i] & 0x000000ff);
            if (temp.length() < 2) {
                sb.append("0");
            }
            sb.append(temp);
        }
        String cryptograph = sb.toString();
        return cryptograph;
    }

}
