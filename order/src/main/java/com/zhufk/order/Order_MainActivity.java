package com.zhufk.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zhufk.common.user.BaseUser;
import com.zhufk.common.user.IUser;
import com.zhufk.common.utils.Cons;
import com.zhufk.myrouter_annotation.ARouter;
import com.zhufk.myrouter_annotation.Parameter;
import com.zhufk.myrouter_api.ParameterManager;
import com.zhufk.myrouter_api.RouterManager;

@ARouter(path = "/order/Order_MainActivity")
public class Order_MainActivity extends AppCompatActivity {

    @Parameter(name = "/app/getUserInfo")
    IUser iUser;

    @Parameter
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_main);

        // 懒加载方式，跳到哪加载哪个类
        ParameterManager.getInstance().loadParameter(this);

//        BaseUser userInfo = iUser.getUserInfo();
//        if (userInfo != null) {
//            Log.e(Cons.TAG, userInfo.getName() + " / "
//                    + userInfo.getAccount() + " / "
//                    + userInfo.getPassword());
//        }
    }

    public void jumpApp(View view){
        RouterManager.getInstance()
                .build("/app/MainActivity")
                .withResultString("call", "I'am comeback!")
                .navigation(this);
    }

    public void jumpPersonal(View view){
        RouterManager.getInstance()
                .build("/personal/Personal_MainActivity")
                .withString("name", "simon")
                .navigation(this);
    }
}
