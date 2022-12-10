package com.changgou.pay.controller;

import com.alibaba.fastjson.JSON;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.pay.service.WeixinPayService;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/weixin/pay")
public class WeixinPayController {
    @Autowired
    private WeixinPayService weixinPayService;

    /*
    * out_trade_no 订单号
    *total_fee 金额
    * */
    @RequestMapping("/create/native")
    public Result<Map<String,String>> createNative(String out_trade_no,String total_fee){
        Map<String,String> resultMap = weixinPayService.createNative(out_trade_no,total_fee);
        return new Result<Map<String,String>>(true, StatusCode.OK,"创建二维码连接成功",resultMap);
    }
    //查询订单的支付状态
    @GetMapping("/status/query")
    public Result queryStatus(String out_trade_no){
        Map<String,String> resultMap = weixinPayService.queryPayStatus(out_trade_no);
        return new Result(true,StatusCode.OK,"查询结果成功",resultMap);
    }

    private static final String WX_SUCCESS="<xml>\n" +
            "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
            "  <return_msg><![CDATA[OK]]></return_msg>\n" +
            "</xml>";
    private static final String WX_FAILE="<xml>\n" +
            "  <return_code><![CDATA[FAIL]]></return_code>\n" +
            "  <return_msg><![CDATA[ERROR]]></return_msg>\n" +
            "</xml>";
    @Autowired
     private RabbitTemplate rabbitTemplate;
    @Value("${mq.pay.exchange.order}")
    private String exchange;
    @Value("${mq.pay.queue.order}")
    private String queue;
    @Value("${mq.pay.routing.key}")
    private String routing;

    @RequestMapping(value = "/notify/url")
    public String notifyurl(HttpServletRequest request){
        InputStream inStream;
        try {
            //读取支付回调数据
            inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inStream.close();
            // 将支付回调数据转换成xml字符串
            String result = new String(outSteam.toByteArray(), "utf-8");
            //将xml字符串转换成Map结构
            Map<String, String> map = WXPayUtil.xmlToMap(result);
            //将消息发送给RabbitMQ
            rabbitTemplate.convertAndSend(exchange,routing, JSON.toJSONString(map));


            //响应数据设置
            Map respMap = new HashMap();
            respMap.put("return_code","SUCCESS");
            respMap.put("return_msg","OK");
            return WXPayUtil.mapToXml(respMap);
        } catch (Exception e) {
            e.printStackTrace();
            //记录错误日志
        }
        return null;
    }}
