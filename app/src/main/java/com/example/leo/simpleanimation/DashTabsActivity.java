package com.example.leo.simpleanimation;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DashTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView toolbar_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_tabs);
        setUI();
    }






    private void setUI()
    {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar_tv = (TextView)findViewById(R.id.toolbar_title);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setUpTabIcons();
        tabLayout.getTabAt(2).select();
        Typeface proto = Typeface.createFromAsset(getAssets(),  "fonts/proto.ttf");
        toolbar_tv.setTypeface(proto);



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition())
                {
                    case 0:
                        toolbar_tv.setText("LEARN THE MOVEMENTS");
                        break;
                    case 1:
                        toolbar_tv.setText("TRAINING");
                        break;
                    case 2:
                        toolbar_tv.setText("COACH");
                        break;
                    case 3:
                        toolbar_tv.setText("PROFILE");
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Completed ());
        adapter.addFragment(new Catagory());
        adapter.addFragment(new MainPanel());
        adapter.addFragment(new Profile());

        viewPager.setAdapter(adapter);
    }



    private void setUpTabIcons()
    {
        tabLayout.getTabAt(0).setIcon(R.drawable.stud);
        tabLayout.getTabAt(1).setIcon(R.drawable.dumbbles);
        tabLayout.getTabAt(2).setIcon(R.drawable.body);
        tabLayout.getTabAt(3).setIcon(R.drawable.propic);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }


    }


    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
