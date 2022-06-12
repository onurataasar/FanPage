package com.example.fanpageproject;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class TabAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public TabAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm, totalTabs);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                 Homepage homepageFragment = new Homepage();
                return homepageFragment;
            case 1:
                Groups groupsFragment = new Groups();
                return groupsFragment;
            case 2:
                Profile profileFragment = new Profile();
                return profileFragment;
            case 3:
                Messages messagesFragment = new Messages();
                return messagesFragment;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {

        return totalTabs;
    }
}