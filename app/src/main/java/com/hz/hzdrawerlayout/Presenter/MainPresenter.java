package com.hz.hzdrawerlayout.Presenter;

import android.app.Activity;
import android.content.res.TypedArray;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.hz.hzdrawerlayout.R;
import com.hz.hzdrawerlayout.entry.TabEntity;

import java.util.ArrayList;

/**
 * Created by hz on 2018/5/30.
 * GitHub：https://github.com/1428610664
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG            #
 * #                                                   #
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private Activity activity;

    public MainPresenter(MainContract.View androidView) {
        this.mView = androidView;
    }

    @Override
    public void subscribe() {

    }


    @Override
    public void unSubscribe() {
        activity = null;
    }


    @Override
    public void bindView(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ArrayList<CustomTabEntity> getTabEntity() {
        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        TypedArray mIconUnSelectIds = activity.getResources().obtainTypedArray(R.array.main_tab_un_select);
        TypedArray mIconSelectIds = activity.getResources().obtainTypedArray(R.array.main_tab_select);
        String[] mainTitles = activity.getResources().getStringArray(R.array.main_title);
        for (int i = 0; i < mainTitles.length; i++) {
            int unSelectId = mIconUnSelectIds.getResourceId(i, R.drawable.tab_home_unselect);
            int selectId = mIconSelectIds.getResourceId(i, R.drawable.tab_home_select);
            mTabEntities.add(new TabEntity(mainTitles[i],selectId , unSelectId));
        }
        mIconUnSelectIds.recycle();
        mIconSelectIds.recycle();
        return mTabEntities;
    }

    /**
     * 版本更新
     * 后期自己制作json文件，暂时先放着
     */
    @Override
    public void getUpdate() {

    }
}
