package com.zhufk.order.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhufk.common.order.OrderAddress;
import com.zhufk.common.order.OrderBean;
import com.zhufk.myrouter_annotation.ARouter;
import com.zhufk.order.services.OrderServices;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;


/**
 * @ClassName OrderAddressImpl
 * @Description 订单模块对外暴露接口实现类，其他模块可以获取返回数据
 * @Author zhufk
 * @Date 2019/11/27 10:20
 * @Version 1.0
 */
//@ARouter(path = "/order/getOrderBean")
public class OrderAddressImpl implements OrderAddress {

    private final static String BASE_URL = "http://apis.juhe.cn/";

    @Override
    public OrderBean getOrderBean(String key, String ip) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
        OrderServices host = retrofit.create(OrderServices.class);

        // Retrofit GET同步请求
        Call<ResponseBody> call = host.get(ip, key);

        retrofit2.Response<ResponseBody> response = call.execute();
        if (response != null && response.body() != null) {
            JSONObject jsonObject = JSON.parseObject(response.body().string());
            OrderBean orderBean = jsonObject.toJavaObject(OrderBean.class);
            System.out.println("解析后结果 >>> " + orderBean.toString());
            return orderBean;
        }
        return null;
    }
}
