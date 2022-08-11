package com.codeyunfei.shiro.tools;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;

/**
 * @author 云飞
 * @create 2022-08-05-下午 06:01:28
 * @decription: 编码工具类
 */
public class EncodesUtil {
    /**
     * HEX-byte[]--String转换
     * @param input 输入数组
     * @return String
     */
    public static String encodeHex(byte[] input){
        return Hex.encodeToString(input);
    }

    /**
     * HEX-string--byte[]转换
     * @param input 输入字符串
     * @return byte[]
     */
    public static byte[] decodeHex(String input){
        return Hex.decode(input);
    }

    /**
     * base64-byte[]--String转换
     * @param input 输入数组
     * @return String
     */
    public static String encodeBase64(byte[] input){
        return Base64.encodeToString(input);
    }

    /**
     * base64-string--byte[]转换
     * @param input 输入字符串
     * @return byte[]
     */
    public static byte[] decodeBase64(String input){
        return Base64.decode(input);
    }


}
