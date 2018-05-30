package com.hz.hzdrawerlayout;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hz.hzdrawerlayout.listener.PerfectClickListener;
import com.hz.hzdrawerlayout.utils.StatusBarUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navView;
    FrameLayout flTitleMenu;

    private ImageView iv_avatar;
    private LinearLayout ll_nav_scan_download;
    private LinearLayout ll_nav_deedback;
    private LinearLayout ll_nav_about;
    private LinearLayout ll_nav_login;
    private LinearLayout ll_nav_video;
    private LinearLayout ll_nav_homepage;
    private View view;
    TextView setting;
    TextView quit;

    private long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //避免切换横竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initView();
        initListener();
    }

    public void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navView = (NavigationView) findViewById(R.id.nav_view);
        flTitleMenu = (FrameLayout) findViewById(R.id.fl_title_menu);
        setting = (TextView) findViewById(R.id.setting);
        quit = (TextView) findViewById(R.id.quit);

        initDrawerLayoutStatus();
        initBar();
        initNav();
    }

    public void initListener() {
        flTitleMenu.setOnClickListener(MainActivity.this);
        navView.setOnClickListener(MainActivity.this);

        //侧滑点击事件
        if (view != null) {
            iv_avatar.setOnClickListener(listener);
            ll_nav_homepage.setOnClickListener(listener);
            ll_nav_scan_download.setOnClickListener(listener);
            ll_nav_deedback.setOnClickListener(listener);
            ll_nav_about.setOnClickListener(listener);
            ll_nav_login.setOnClickListener(listener);
            ll_nav_video.setOnClickListener(listener);
            setting.setOnClickListener(listener);
            quit.setOnClickListener(listener);
        }
    }

    /**
     * 自定义菜单点击事件
     */
    private PerfectClickListener listener = new PerfectClickListener() {
        @Override
        protected void onNoDoubleClick(final View v) {
            drawerLayout.closeDrawer(GravityCompat.START);
            drawerLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch (v.getId()) {
                        case R.id.iv_avatar:
                            Toast.makeText(MainActivity.this, "头像", Toast.LENGTH_SHORT).show();
                            break;
                        // 主页
                        case R.id.ll_nav_homepage:
                            Toast.makeText(MainActivity.this, "项目主页", Toast.LENGTH_SHORT).show();
                            break;
                        //扫码下载
                        case R.id.ll_nav_scan_download:
                            Toast.makeText(MainActivity.this, "扫码下载", Toast.LENGTH_SHORT).show();
                            break;
                        // 问题反馈
                        case R.id.ll_nav_deedback:
                            Toast.makeText(MainActivity.this, "问题反馈", Toast.LENGTH_SHORT).show();
                            break;
                        // 关于
                        case R.id.ll_nav_about:
                            Toast.makeText(MainActivity.this, "关于", Toast.LENGTH_SHORT).show();
                            break;
                        // 个人
                        case R.id.ll_nav_login:
                            Toast.makeText(MainActivity.this, "个人中心", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.ll_nav_video:
                            Toast.makeText(MainActivity.this, "语音识别", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.setting:
                            Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.quit:
                            Toast.makeText(MainActivity.this, "退出", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            break;
                    }
                }
            }, 0);
        }
    };


    /**
     * 初始化侧滑菜单的状态栏
     */
    private void initDrawerLayoutStatus() {
        //为DrawerLayout 布局设置状态栏变色，也就是加上透明度
        StatusBarUtils.setColorForDrawerLayout(this, drawerLayout,
                getResources().getColor(R.color.colorTheme), 0);
    }

    /**
     * 初始化ActionBar按钮
     */
    private void initBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    /**
     * 初始化侧滑菜单
     */
    private void initNav() {
        view = navView.inflateHeaderView(R.layout.nav_header_main);
        iv_avatar = (ImageView) view.findViewById(R.id.iv_avatar);
        TextView tv_username = (TextView) view.findViewById(R.id.tv_username);
        ll_nav_homepage = (LinearLayout) view.findViewById(R.id.ll_nav_homepage);
        ll_nav_scan_download = (LinearLayout) view.findViewById(R.id.ll_nav_scan_download);
        ll_nav_deedback = (LinearLayout) view.findViewById(R.id.ll_nav_deedback);
        ll_nav_about = (LinearLayout) view.findViewById(R.id.ll_nav_about);
        ll_nav_login = (LinearLayout) view.findViewById(R.id.ll_nav_login);
        ll_nav_video = (LinearLayout) view.findViewById(R.id.ll_nav_video);

        //ImageUtils.loadImgByPicassoWithCircle(MainActivity.this, R.drawable.ic_person_logo, iv_avatar);
        //tv_username.setText("陈辉泽");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_capture:
                Toast.makeText(this, "二维码扫描", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about_us:
                Toast.makeText(this, "点击关于我们", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * onBackPressed、onKeyDown和onKeyUp这三个事件的区别
     */
    @Override
    public void onBackPressed() {
        Log.e("触摸监听", "onBackPressed");
        if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 是当某个按键被按下是触发。所以也有人在点击返回键的时候去执行该方法来做判断
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e("触摸监听", "onKeyDown");
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                // 不退出程序，进入后台
                //moveTaskToBack(true);

                //双击返回桌面
                if ((System.currentTimeMillis() - time > 1000)) {
                    Toast.makeText(this, "再按一次返回桌面", Toast.LENGTH_SHORT).show();
                    time = System.currentTimeMillis();
                } else {
                    moveTaskToBack(true);
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    /**
     * 这个方法是当某个按键被按下后，抬起的时候执行，其实跟onKeyDown没什么差别
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.e("触摸监听", "onKeyUp");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "点击菜单" +view.getId(), Toast.LENGTH_SHORT).show();
        switch (view.getId()) {
            case R.id.fl_title_menu:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
    }

}
