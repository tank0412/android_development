package com.example.lab5ad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.lab5ad.ui.NotSample;
import com.example.lab5ad.ui.SampleFifth;
import com.example.lab5ad.ui.SampleFirst;
import com.example.lab5ad.ui.SampleFourth;
import com.example.lab5ad.ui.SampleSecond;
import com.example.lab5ad.ui.SampleThird;
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    private Drawer drawerResult = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(getSupportActionBar() != null)
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        toolbar.getBackground().setAlpha(100);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerResult = new DrawerBuilder().withActivity(this)
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                //.withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new SecondaryDrawerItem().withName(R.string.drawer_item_sample1).withIcon(FontAwesome.Icon.faw_angle_left).withIdentifier(1),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_sample2).withIcon(FontAwesome.Icon.faw_angle_left).withIdentifier(2),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_sample3).withIcon(FontAwesome.Icon.faw_angle_left).withIdentifier(3),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_sample4).withIcon(FontAwesome.Icon.faw_angle_left).withIdentifier(4),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_sample5).withIcon(FontAwesome.Icon.faw_angle_left).withIdentifier(5),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_not_sample).withIcon(FontAwesome.Icon.faw_angle_left).withIdentifier(6)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem)
                    {
                        // do something with the clicked item :D
                        selectDrawerItem((int)drawerItem.getIdentifier(), drawerItem);
                        return true;
                    }
                })
                .build();

    }
    @Override
    public void onBackPressed() {
        if (drawerResult.isDrawerOpen()) {
            drawerResult.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    public void selectDrawerItem(int ItemId, IDrawerItem drawerItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass = SampleFirst.class;
        switch(ItemId) {
            case 1:
                fragmentClass = SampleFirst.class;
                break;
            case 2:
                fragmentClass = SampleSecond.class;
                break;
            case 3:
                fragmentClass = SampleThird.class;
                break;
            case 4:
                fragmentClass = SampleFourth.class;
                break;
            case 5:
                fragmentClass = SampleFifth.class;
                break;
            case 6:
                fragmentClass = NotSample.class;
                break;
            default:
                fragmentClass = SampleFirst.class;
                break;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        drawerResult.closeDrawer();
    }
}
