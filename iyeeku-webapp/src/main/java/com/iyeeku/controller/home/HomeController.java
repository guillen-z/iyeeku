package com.iyeeku.controller.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@RestController
public class HomeController {

    private static String token = "iyeeku";

    @RequestMapping(value = "/hahaha" , method = RequestMethod.GET)
    public ModelAndView toIndexPage(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {


        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");


        System.out.println( " signature ==>> " + signature );
        System.out.println( " timestamp ==>> " + timestamp);
        System.out.println(" nonce ==>> " + nonce);
        System.out.println(" echostr ==>> " + echostr);

        PrintWriter out = response.getWriter();

        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (checkSignature(signature, timestamp, nonce)) {
            System.out.print("echostr=" + echostr);
            out.print(echostr);
        }

        out.close();
        out = null;


        return new ModelAndView("home");
    }

    @RequestMapping(value = "/home/reg" , method = RequestMethod.GET)
    public ModelAndView toRegisterPage(){
        return new ModelAndView("register");
    }


    /**
     * 方法名：checkSignature</br>
     * 详述：验证签名</br>
     * 开发人员：sony</br>
     * 创建时间：2017-12-29 </br>
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     * @throws
     */
    public static boolean checkSignature(String signature, String timestamp,
                                         String nonce) {
        // 1.将token、timestamp、nonce三个参数进行字典序排序
        String[] arr = new String[] { token, timestamp, nonce };
        Arrays.sort(arr);

        // 2. 将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        content = null;
        // 3.将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    private static String byteToStr(byte[] byteArray) {
        StringBuilder strDigest = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            strDigest.append(byteToHexStr(byteArray[i]));
        }
        return strDigest.toString();
    }


    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }

}
