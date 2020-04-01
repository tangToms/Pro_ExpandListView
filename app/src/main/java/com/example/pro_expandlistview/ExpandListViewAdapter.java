package com.example.pro_expandlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ExpandListViewAdapter extends BaseExpandableListAdapter {
    private ArrayList<String> groupLists;
    private Map<String,ArrayList<String>> childLists;
    private Context mContext;
    public ExpandListViewAdapter(Context context,ArrayList<String> group,Map<String,ArrayList<String>> child){
        this.mContext=context;
        this.groupLists=group;
        this.childLists=child;
    }
    @Override
    public int getGroupCount() {
        return groupLists.size();
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        //获取组名
        String name =groupLists.get(groupPosition);
        return childLists.get(name).size();
    }
    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }
    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        //获取group的layout
        View view=LayoutInflater.from(mContext).inflate(R.layout.t_expandlistview_group,null);
        //获取视图组件
        TextView textView= view.findViewById(R.id.gp_tv1);
        textView.setText(groupLists.get(groupPosition));
        return view;
    }
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //获取子Item的layout
        View view = LayoutInflater.from(mContext).inflate(R.layout.t_expandlistview_item,null);
        //获取视图组件
        TextView textView = view.findViewById(R.id.tv1);
        //获取组名
        String groupName = groupLists.get(groupPosition);
        //获取子Item的text
        textView.setText(childLists.get(groupName).get(childPosition));
        return view;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
