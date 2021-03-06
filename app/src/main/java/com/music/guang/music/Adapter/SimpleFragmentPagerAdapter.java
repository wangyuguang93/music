package com.music.guang.music.Adapter;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.music.guang.music.Fragment.BendiMusicFragment;
import com.music.guang.music.Fragment.NetWorkMusicFragment;

/**
 * Created by Administrator on 2015/7/30.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"本地音乐","网络音乐"};
    private Context context;

    public SimpleFragmentPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0)
        {
            return BendiMusicFragment.newInstance(position);
        }else
        {
          //  return NetWorkMusicFragment.newInstance(position);
            return NetWorkMusicFragment.newInstance(position);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}