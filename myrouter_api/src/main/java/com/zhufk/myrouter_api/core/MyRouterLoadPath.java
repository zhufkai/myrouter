package com.zhufk.myrouter_api.core;

import com.zhufk.myrouter_annotation.model.RouterBean;

import java.util.Map;

/**
 * @ClassName MyRouterLoadPath
 * @Description TODO
 * @Author zhufk
 * @Date 2019/11/25 16:41
 * @Version 1.0
 */
public interface MyRouterLoadPath {

    /**
     * 加载路由组Group中的Path详细数据
     * 比如："app"分组下有这些信息：
     *
     * @return key:"/app/MainActivity", value:MainActivity信息封装到RouterBean对象中
     */
    Map<String, RouterBean> loadPath();
}
