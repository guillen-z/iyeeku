package com.iyeeku.watch.client;

import com.iyeeku.watch.message.Message1000VO;

import java.io.Serializable;

public class BioServerClient1 {

    public static void main(String[] args) {

        Message1000VO.Req_Message1000 req_message1000 = new Message1000VO.Req_Message1000();
        req_message1000.setName("张三");

        //Message1000VO.Resp_Message1000 respMessage1000 = (Message1000VO.Resp_Message1000) IyeekuCall.call("1000",req_message1000);

        Serializable response = IyeekuCall.call("1000" , req_message1000);

        if (response instanceof Message1000VO.Resp_Message1000){

            Message1000VO.Resp_Message1000 resp = (Message1000VO.Resp_Message1000) response;
            System.out.println(resp.getRespCode());
            System.out.println(resp.getRespMsg());

        }

        if (response instanceof Message1000VO.Exp_Message1000){

            Message1000VO.Exp_Message1000 exp = (Message1000VO.Exp_Message1000) response;
            System.out.println(exp.getExpCode());
            System.out.println(exp.getExpMsg());

        }

        //System.out.println(respMessage1000.getCount());

    }

}

