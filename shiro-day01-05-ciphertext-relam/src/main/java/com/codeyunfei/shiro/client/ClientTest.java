package com.codeyunfei.shiro.client;

import com.codeyunfei.shiro.tools.DigestsUtil;
import com.codeyunfei.shiro.tools.EncodesUtil;
import org.junit.Test;

import java.util.Map;

/**
 * @author 云飞
 * @create 2022-08-05-下午 06:01:17
 * @decription: 测试
 */
public class ClientTest {

    @Test
    public void testDigestsUtil(){
        Map<String,String> map =  DigestsUtil.entryptPassword("123");
        System.out.println("获得结果："+map.toString());
    }
    /**
     * 测试16进制Hex编码
     */
    @Test
    public void testHex(){
        String val = "holle";
        String flag = EncodesUtil.encodeHex(val.getBytes());
        String valHandler = new String(EncodesUtil.decodeHex(flag));
        System.out.println("比较结果："+val.equals(valHandler));
    }

    /**
     * 测试base64编码
     */
    @Test
    public void testBase64(){
        String val = "holle";
        String flag = EncodesUtil.encodeBase64(val.getBytes());
        String valHandler = new String(EncodesUtil.decodeBase64(flag));
        System.out.println("比较结果："+val.equals(valHandler));
    }


}
