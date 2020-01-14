package com.zhufk.common.order.drawable;

import com.zhufk.myrouter_api.core.Call;


/**
 * @ClassName OrderDrawable
 * @Description 订单模块对外暴露接口，其他模块可以获取返回res资源
 * @Author zhufk
 * @Date 2019/11/27 10:01
 * @Version 1.0
 */
public interface OrderDrawable extends Call {
    int getDrawable();
}
