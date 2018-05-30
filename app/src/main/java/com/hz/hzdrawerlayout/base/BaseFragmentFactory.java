package com.hz.hzdrawerlayout.base;

import com.hz.hzdrawerlayout.fragment.DataFragment;
import com.hz.hzdrawerlayout.fragment.FindFragment;
import com.hz.hzdrawerlayout.fragment.HomeFragment;
import com.hz.hzdrawerlayout.fragment.MeFragment;

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

public class BaseFragmentFactory {

    private static BaseFragmentFactory mInstance;
    private HomeFragment mHomeFragment;
    private FindFragment mFindFragment;
    private DataFragment mDataFragment;
    private MeFragment mMeFragment;

    private BaseFragmentFactory() {}

    public static BaseFragmentFactory getInstance() {
        if (mInstance == null) {
            synchronized (BaseFragmentFactory.class) {
                if (mInstance == null) {
                    mInstance = new BaseFragmentFactory();
                }
            }
        }
        return mInstance;
    }


    public HomeFragment getHomeFragment() {
        if (mHomeFragment == null) {
            synchronized (BaseFragmentFactory.class) {
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
            }
        }
        return mHomeFragment;
    }


    public FindFragment getFindFragment() {
        if (mFindFragment == null) {
            synchronized (BaseFragmentFactory.class) {
                if (mFindFragment == null) {
                    mFindFragment = new FindFragment();
                }
            }
        }
        return mFindFragment;
    }


    public DataFragment getDataFragment() {
        if (mDataFragment == null) {
            synchronized (BaseFragmentFactory.class) {
                if (mDataFragment == null) {
                    mDataFragment = new DataFragment();
                }
            }
        }
        return mDataFragment;
    }


    public MeFragment getMeFragment() {
        if (mMeFragment == null) {
            synchronized (BaseFragmentFactory.class) {
                if (mMeFragment == null) {
                    mMeFragment = new MeFragment();
                }
            }
        }
        return mMeFragment;
    }

}
