package com.coolweather.weixin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class MyAdapter extends BaseAdapter {


    private int i;
    private View view;
    private ViewGroup viewGroup;
    ArrayList<ItemBean> list = new ArrayList<ItemBean>();

    public MyAdapter(ArrayList<ItemBean> list) {
        this.list = list;
    }

    @Override
    //ListView需要显示的数据数量
    public int getCount() {
        return list.size();
    }

    @Override
    //指定的索引对应的数据项
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    //指定的索引对应的数据项ID
    public long getItemId(int position) {
        return position;
    }

    @Override
    //返回每一项的显示内容
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();

        //如果view未被实例化过，缓存池中没有对应的缓存
        if(convertView == null){
            //进行地址初始化
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.frut_item,null);
            viewHolder.tvName = convertView.findViewById(R.id.tvUserName);
            viewHolder.tvMsg = convertView.findViewById(R.id.tvMsg);
            viewHolder.imgAvatar = convertView.findViewById(R.id.imgAvatar);
            convertView.setTag(viewHolder);//通过setTag将convertView与viewHolder关联
        } else {
            //如果缓存池中有对应的view缓存，则直接通过getTag取出viewHolder
            viewHolder = (ViewHolder)convertView.getTag();
        }
        // 取出bean对象
        ItemBean itemBean = list.get(position);
        // 设置控件的数据
        viewHolder.tvName.setText(itemBean.getUserName());
        viewHolder.tvMsg.setText(itemBean.getMsg());
        viewHolder.imgAvatar.setImageResource(itemBean.getImgId());
        return convertView;
    }



    //用于缓存
    class ViewHolder{
        //修改的组件
        TextView tvName,tvMsg;
        ImageView imgAvatar;
    }
}
