package com.zhufk.order.impl;

import com.zhufk.common.order.drawable.OrderDrawable;
import com.zhufk.myrouter_annotation.ARouter;
import com.zhufk.order.R;

/**
 * @ClassName OrderDrawableImpl
 * @Description 订单模块对外暴露接口实现类，其他模块可以获取返回res资源
 * @Author zhufk
 * @Date 2019/11/27 10:09
 * @Version 1.0
 */
@ARouter(path = "/order/getDrawable")
public class OrderDrawableImpl implements OrderDrawable {

    @Override
    public int getDrawable() {
        return R.drawable.ic_group_work_black_24dp;
    }
}
