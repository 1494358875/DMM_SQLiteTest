package com.dm.damiaomiao_sqlite_test;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dm.damiaomiao_sqlite_test.model.User;

import org.litepal.LitePal;
import org.litepal.crud.callback.FindMultiCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //配置LitePal
        LitePal.initialize(this);
        setContentView(R.layout.activity_main);

//        SQLiteDatabase database = LitePal.getDatabase();
        boolean save1 = new User("大喵", 20, true).save();
        boolean save2 = new User(null, 20, true).save();
        boolean save3 = new User("大狗", 20, true).save();
        User user = LitePal.find(User.class, 1);
        List<User> list1 = LitePal.where("name like ?", "大%").find(User.class);
        User user1 = new User();
        user1.setAge(19);
//        user1.update(1);
        int updateAll = user1.updateAll("name like ?", "大%");
        List<User> list = LitePal.findAll(User.class);
        int delete = LitePal.delete(User.class, 1);
        int 大喵 = LitePal.deleteAll(User.class, "name like ?", "大喵");
        LitePal.findAllAsync(User.class).listen(new FindMultiCallback<User>() {
            @Override
            public void onFinish(List<User> list) {
                int size = list.size();
            }
        });

    }
}
