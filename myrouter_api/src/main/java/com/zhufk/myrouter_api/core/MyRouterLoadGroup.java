package com.zhufk.myrouter_api.core;

import java.util.Map;

/**
 * @ClassName MyRouterLoadGroup
 * @Description TODO
 * @Author zhufk
 * @Date 2019/11/25 16:40
 * @Version 1.0
 */
public interface MyRouterLoadGroup {
    /**
     * 加载路由组Group数据
     * 比如："app", ARouter$$Path$$app.class（实现了ARouterLoadPath接口）
     *
     * @return key:"app", value:"app"分组对应的路由详细对象类
     */
    Map<String, Class<? extends MyRouterLoadPath>> loadGroup();
}
