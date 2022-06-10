package com.coolweather.weixin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private List<View> mView = new ArrayList<View>();
    private PageAdapter mAdapter = new PageAdapter(mView);

    private LinearLayout mTabWeixin, mTabFriend, mTabTongxunlu, mTabSet;
    private ImageButton mWeixinImg, mFriendImg, mTongxunluImg, mSetImg;
    private String[] data ={"朋友1","朋友2","朋友3","朋友4","朋友5","朋友6","朋友7","朋友8",};

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉主题自带的标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        inirView();
        initEvents();

    }

    private void initEvents() {
        mTabWeixin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabTongxunlu.setOnClickListener(this);
        mTabSet.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                resetImg();
                int currentItem = mViewPager.getCurrentItem();
                switch (currentItem) {
                    case 0:
                        /*ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
                        ListView listView=findViewById(R.id.list_item);
                        listView.setAdapter(adapter);*/
                        Log.d("zhouchangzhi", "myBaseAdapter: currentItem的值为"+ currentItem +"....");
                        mWeixinImg.setImageResource(R.drawable.phone);
                        ArrayList<ItemBean> list = new ArrayList<ItemBean>();
                        myBaseAdapter(list);
                        break;
                    case 1:
                        Log.d("zhouchangzhi", "myBaseAdapter: currentItem的值为"+ currentItem +"....");
                        mFriendImg.setImageResource(R.drawable.phone);
                        break;
                    case 2:
                        Log.d("zhouchangzhi", "myBaseAdapter: currentItem的值为"+ currentItem +"....");
                        mTongxunluImg.setImageResource(R.drawable.phone);
                        break;
                    case 3:
                        Log.d("zhouchangzhi", "myBaseAdapter: currentItem的值为"+ currentItem +"....");
                        mSetImg.setImageResource(R.drawable.phone);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void resetImg() {
        mWeixinImg.setImageResource(R.drawable.more);
        mFriendImg.setImageResource(R.drawable.find);
        mTongxunluImg.setImageResource(R.drawable.history);
        mSetImg.setImageResource(R.drawable.settings);

    }

    private void inirView() {
        mViewPager=findViewById(R.id.id_viewpager);
        mTabWeixin=findViewById(R.id.tab_weixin);
        mTabFriend=findViewById(R.id.tab_friend);
        mTabTongxunlu=findViewById(R.id.tab_tongxunlu);
        mTabSet=findViewById(R.id.tab_set);

        mWeixinImg=findViewById(R.id.tab_weixin_img);
        mFriendImg=findViewById(R.id.tab_friend_img);
        mTongxunluImg=findViewById(R.id.tab_tongxunlu_img);
        mSetImg=findViewById(R.id.tab_set_img);
        LayoutInflater minflater=LayoutInflater.from(this);
        View tab01 =minflater.inflate(R.layout.tab01,null);
        View tab02 =minflater.inflate(R.layout.tab02,null);
        View tab03 =minflater.inflate(R.layout.tab03,null);
        View tab04 =minflater.inflate(R.layout.tab04,null);
        mView.add(tab01);
        mView.add(tab02);
        mView.add(tab03);
        mView.add(tab04);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(0);
        mViewPager.setCurrentItem(1);

    }

    @Override
    public void onClick(View view) {
        resetImg();
        switch (view.getId()){
            case R.id.tab_weixin:
                mViewPager.setCurrentItem(0);
                /*ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
                ListView listView=findViewById(R.id.list_item);
                listView.setAdapter(adapter);*/
                //myBaseAdapter();
                mWeixinImg.setImageResource(R.drawable.phone);
                break;
            case R.id.tab_friend:
                mViewPager.setCurrentItem(1);
                mWeixinImg.setImageResource(R.drawable.phone);
                break;
            case R.id.tab_tongxunlu:
                mViewPager.setCurrentItem(2);
                mWeixinImg.setImageResource(R.drawable.phone);
                break;
            case R.id.tab_set:
                mViewPager.setCurrentItem(3);
                mWeixinImg.setImageResource(R.drawable.phone);
                break;
            default:
                break;
        }

    }

    public void myBaseAdapter(ArrayList<ItemBean> list) {
        //初始化数据
        int num=0;
        listView = findViewById(R.id.list_item);
        int[] imageNmae = {R.mipmap.m0, R.mipmap.m1, R.mipmap.m2, R.mipmap.m3
        };

        for (int i = 0; i < 4; i++) {
            String userName = "微信好友" + i;
            String userMsg = "这是一条很长很长很长的语音消息建议您删除好友" + i;
            list.add(new ItemBean(userName, userMsg, imageNmae[i]));
            if (i==3){
                num++;
            }
        }

        //创建适配器对象
        MyAdapter myAdapter = new MyAdapter(list);
        listView.setAdapter((ListAdapter) myAdapter);

        //单机事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "第" + position + "个条目被点击了", Toast.LENGTH_SHORT).show();
            }
        });

        //长按事件
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "第" + position + "个条目被点长按了", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
//        Log.d("zhouchangzhi", "myBaseAdapter: 执行了"+ num +"次");
    }

    /*class MyAdapter extends BaseAdapter {


        private int i;
        private View view;
        private ViewGroup viewGroup;
        ArrayList<ItemBean> list = new ArrayList<ItemBean>();

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
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.frut_item,null);
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
    }*/

}