package com.zhufk.myrouter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.zhufk.common.order.OrderAddress;
import com.zhufk.common.order.OrderBean;
import com.zhufk.common.order.drawable.OrderDrawable;
import com.zhufk.common.user.BaseUser;
import com.zhufk.common.user.IUser;
import com.zhufk.common.utils.Cons;
import com.zhufk.myrouter_annotation.ARouter;
import com.zhufk.myrouter_annotation.Parameter;
import com.zhufk.myrouter_api.ParameterManager;
import com.zhufk.myrouter_api.RouterManager;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {

    @Parameter
    String name;

    @Parameter(name = "ages")
    String age;

//    @Parameter(name = "/order/getDrawable")
//    OrderDrawable orderDrawable;
//
//    @Parameter(name = "/order/getOrderBean")
//    OrderAddress orderAddress;
    @Parameter(name = "/order/getUserInfo")
    IUser iUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BuildConfig.isRelease) {
            Log.e(Cons.TAG, "当前为：集成化模式，除app可运行，其他子模块都是Android Library");
        } else {
            Log.e(Cons.TAG, "当前为：组件化模式，app/order/personal子模块都可独立运行");
        }

        // 懒加载方式，跳到哪加载哪个类
        ParameterManager.getInstance().loadParameter(this);
        BaseUser userInfo = iUser.getUserInfo();
        if (userInfo != null) {
            Log.e(Cons.TAG, userInfo.getName() + " / "
                    + userInfo.getAccount() + " / "
                    + userInfo.getPassword());
        }
//        int drawableId = orderDrawable.getDrawable();
//        ImageView imageView = findViewById(R.id.main_img);
//        imageView.setImageResource(drawableId);

//        // 测试获取接口通信
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    OrderBean orderBean = orderAddress.getOrderBean("aa205eeb45aa76c6afe3c52151b52160", "144.34.161.97");
//                    Log.e("zhufk >>> ", orderBean.toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Log.e(Cons.TAG, data.getStringExtra("call"));
        }
    }

    public void jumpOrder(View view) {
        RouterManager.getInstance()
                .build("/order/Order_MainActivity")
                .withString("username", "simon")
                .navigation(this, 1000);
    }

    public void jumpPersonal(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("name", "simon");
        bundle.putInt("age", 35);
        bundle.putBoolean("isSuccess", true);
        bundle.putString("netease", "net163");

        RouterManager.getInstance()
                .build("/personal/Personal_MainActivity")
                .withString("username", "baby")
                .withBundle(bundle)
                .navigation(this, 163);
    }
}
