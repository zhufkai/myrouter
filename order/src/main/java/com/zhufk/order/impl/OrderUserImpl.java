package com.zhufk.order.impl;

import com.zhufk.common.user.BaseUser;
import com.zhufk.common.user.IUser;
import com.zhufk.myrouter_annotation.ARouter;
import com.zhufk.order.model.UserInfo;


/**
 * @ClassName OrderUserImpl
 * @Description personal模块实现的内容
 * @Author zhufk
 * @Date 2019/11/27 10:16
 * @Version 1.0
 */
@ARouter(path = "/order/getUserInfo")
public class OrderUserImpl implements IUser {
    @Override
    public BaseUser getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("zhufk");
        userInfo.setAccount("netease_river");
        userInfo.setPassword("666666");
        userInfo.setVipLevel(9);
        return userInfo;
    }
}
