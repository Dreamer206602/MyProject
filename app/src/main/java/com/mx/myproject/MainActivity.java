package com.mx.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mx.myproject.mvp.people;
import com.mylhyl.superdialog.SuperDialog;
import com.mylhyl.superdialog.res.values.ColorRes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView= (ListView) findViewById(R.id.listView);

        mListView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,new String[]{"提示框","确定框","换头像"}));

        mListView.setOnItemClickListener(this);




    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                new  SuperDialog.Builder(this).setRadius(10)
                        .setTitle("标题",80,205)
                        .setMessage("可以看到?")
                        .setPositiveButton("确定", new SuperDialog.OnClickPositiveListener() {
                            @Override
                            public void onClick(View v) {


                            }
                        }).build();
                break;
            case 1:
                new SuperDialog.Builder(this)
                        .setTitle("标题")
                        .setMessage("从这里开始")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new SuperDialog.OnClickPositiveListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).build();

                break;
            case 2:
                final String[]strings={"拍照","从相册选择","取消"};
                List<people>list=new ArrayList<>();
                list.add(new people(1,"拍照"));
                list.add(new people(2,"从相册选择"));
                list.add(new people(3,"小视频"));
                new SuperDialog.Builder(this)
                        .setTitle("上传头像", ColorRes.negativeButton)
                        .setCanceledOnTouchOutside(true)
                        .setItems(list, new SuperDialog.OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                Toast.makeText(MainActivity.this, strings[position], Toast.LENGTH_LONG).show();

                            }
                        })
                .setNegativeButton("取消",null)
                .build();

                break;
        }
    }
}
