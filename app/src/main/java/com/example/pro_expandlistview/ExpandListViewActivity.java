package com.example.pro_expandlistview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;

public class ExpandListViewActivity extends Activity {
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置绑定视图
        setContentView(R.layout.t_expandlistview);
        //上下文
        mContext = ExpandListViewActivity.this;
        //获取ExpandListView
        ExpandableListView expandableListView = findViewById(R.id.expandlv1);
        //设置数据
        ArrayList<String> groups = new ArrayList<>();
        //创建组Item
        Map<String,ArrayList<String>> childs = new HashMap<>();
        for (int i=0;i<3;i++){
            String groupName = "group"+i;
            groups.add(groupName);
            ArrayList<String> childItem = new ArrayList<>();
            for (int j=0;j<4;j++) {
                childItem.add("child"+j);
            }
            childs.put(groupName,childItem);
        }
        //设置Adpater
        ExpandListViewAdapter expandListViewAdapter=new ExpandListViewAdapter(mContext,groups,childs);
        //设置适配器
        expandableListView.setAdapter(expandListViewAdapter);
    }
}
