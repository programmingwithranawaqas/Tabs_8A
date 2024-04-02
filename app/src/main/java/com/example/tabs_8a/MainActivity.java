package com.example.tabs_8a;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        viewPager.setAdapter(new OrderPagerAdapter(this));

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position)
                {
                    case 0:
                    {
                        tab.setText("Confirmed");
                        tab.setIcon(R.drawable.ic_confirmed);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setNumber(9);
                        badgeDrawable.setBackgroundColor(getResources().getColor(R.color.red, getTheme()));
                        badgeDrawable.setMaxCharacterCount(3);
                        badgeDrawable.setVisible(true);
                        break;
                    }
                    case 1:
                    {
                        tab.setText("Pending");
                        tab.setIcon(R.drawable.ic_pending);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setNumber(100);
                        badgeDrawable.setBackgroundColor(getResources().getColor(R.color.red, getTheme()));
                        badgeDrawable.setMaxCharacterCount(3);
                        badgeDrawable.setVisible(true);

                        break;
                    }
                    case 2:
                    {
                        tab.setText("Deliveed");
                        tab.setIcon(R.drawable.ic_delivered);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();

                        badgeDrawable.setNumber(51);
                        badgeDrawable.setBackgroundColor(getResources().getColor(R.color.red, getTheme()));
                        badgeDrawable.setMaxCharacterCount(3);
                        badgeDrawable.setVisible(true);
                        break;
                    }
                }
            }
        }
        );

        tabLayoutMediator.attach();

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable bd = Objects.requireNonNull(tabLayout.getTabAt(position)).getOrCreateBadge();
                bd.setVisible(false);
                bd.setNumber(0);
            }
        });
    }
}