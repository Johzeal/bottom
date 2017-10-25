package com.example.zhujiaxiang.dibulan2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ViewPager mTabPager;
    private ImageView mTabMusic,mTabLove,mTabExit;
    private int currIndex = 0;// 当前页卡编号
    private int startY;
    private int endY;
    private int endX;
    private int startX;
    private MotionEvent motionEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabPager = (ViewPager)findViewById(R.id.tabpager);
        mTabPager.setOnPageChangeListener(new MyOnPageChangeListener());

        mTabMusic = (ImageView) findViewById(R.id.img_music);
        mTabLove = (ImageView) findViewById(R.id.img_love);
        mTabExit = (ImageView) findViewById(R.id.img_exit);
        mTabMusic.setOnClickListener(new OnClick(0));
        mTabLove.setOnClickListener(new OnClick(1));
        mTabExit.setOnClickListener(new OnClick(2));

        //将要分页显示的View装入数组中
        LayoutInflater mLi = LayoutInflater.from(this);
        View viewMusic = mLi.inflate(R.layout.activity_music, null);
        View viewLove = mLi.inflate(R.layout.activity_love, null);
        View viewExit = mLi.inflate(R.layout.activity_exit, null);

        //每个页面的view数据
        final ArrayList<View> views = new ArrayList<View>();
        views.add(viewMusic);
        views.add(viewLove);
        views.add(viewExit);
//        mTabPager.setOnTouchListener(new View.OnTouchListener(){
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int action = event.getAction();
//                switch (action) {
//                    case MotionEvent.ACTION_DOWN:
//                        startX = (int) event.getX();
//                        startY = (int) event.getY();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        endX = (int) event.getX();
//                        endY = (int) event.getY();
//                        if (Math.abs(endX - startX) < 50 && Math.abs(endY - startY) < 50) {
//                            try {
//                                Toast.makeText(getApplicationContext(), "这是从子控件传来的参数，在ViewPager中响应的事件", Toast.LENGTH_SHORT).show();
//                            } catch (Exception e) {
//                            }
//                        }
//                        break;
//                }
//                return false;
//            }
//        });
        //填充ViewPager的数据适配器
        PagerAdapter mPagerAdapter = new PagerAdapter()
        {
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public void destroyItem(View container, int position, Object object) {
                ((ViewPager)container).removeView(views.get(position));
            }

            @Override
            public Object instantiateItem(View container, int position) {
                ((ViewPager)container).addView(views.get(position));
                return views.get(position);
            }
        };
        mTabPager.setAdapter(mPagerAdapter);
        mTabPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch(action){
                    case MotionEvent.ACTION_DOWN:
                        startX = (int)event.getX();
                        startY = (int)event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        endX = (int)event.getX();
                        endY = (int)event.getY();
                        if (Math.abs(endX - startX) < 50 &&Math.abs(endY - startY) < 50)
                        try{

                        }catch (Exception e){
                        }
                }
                return false;
            }
        });
//        mTabPager.setOnTouchListener(new View.OnTouchListener() {
//                                         @Override
//                                         public boolean onTouch(View v, MotionEvent event) {
//                                             switch (event.getAction()) {
//                                                 case MotionEvent.ACTION_MOVE:
//                                                     mTabPager.requestDisallowInterceptTouchEvent(true);
//                                                     break;
//                                                 case MotionEvent.ACTION_UP:
//                                                 case MotionEvent.ACTION_CANCEL:
//                                                     mTabPager.requestDisallowInterceptTouchEvent(false);
//                                                     return false;
//                                             }
//
//                                     });
//        mTabPager.setOnTouchListener(new View.OnTouchListener() {
//            private boolean moved;
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
//                moved = false;
//                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
//                    moved = true;
//                }
//                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
//                }
//
//                return false;
//            }
//        });
//
    }


    /**
     * 头标点击监听
     */
    public class OnClick implements View.OnTouchListener, View.OnClickListener {
        private int index = 0;
        public OnClick(int i)
        {
            index = i;
        }
        @Override
        public void onClick(View v)
        {
            mTabPager.setCurrentItem(index);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            switch (action){
                case MotionEvent.ACTION_DOWN:
            }
            return false;
        }
    };



    /**
     * 页卡切换监听
     */
    public class MyOnPageChangeListener implements OnPageChangeListener
    {
        @Override
        public void onPageSelected(int arg0)
        {
            switch (arg0)
            {
                case 0:
                {
                    mTabMusic.setImageDrawable(getResources().getDrawable(R.mipmap.biezhen));
                    if (currIndex == 1)
                    {
                        mTabLove.setImageDrawable(getResources().getDrawable(R.mipmap.jiantou));
                    }
                    else if (currIndex == 2)
                    {
                        mTabExit.setImageDrawable(getResources().getDrawable(R.mipmap.ren));
                    }
                    break;
                }
                case 1:
                {
                    mTabLove.setImageDrawable(getResources().getDrawable(R.mipmap.jiantou));
                    if (currIndex == 0)
                    {
                        mTabMusic.setImageDrawable(getResources().getDrawable(R.mipmap.biezhen));
                    }
                    else if (currIndex == 2)
                    {
                        mTabExit.setImageDrawable(getResources().getDrawable(R.mipmap.ren));
                    }
                    break;
                }
                case 2:
                {
                    mTabExit.setImageDrawable(getResources().getDrawable(R.mipmap.ren));
                    if (currIndex == 0)
                    {
                        mTabMusic.setImageDrawable(getResources().getDrawable(R.mipmap.biezhen));
                    }
                    else if (currIndex == 1)
                    {
                        mTabLove.setImageDrawable(getResources().getDrawable(R.mipmap.jiantou));
                    }
                    break;
                }
            }
            currIndex = arg0;
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}