package com.example.jefferson.theme.activity;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jefferson.theme.R;
import com.example.jefferson.theme.adapter.NavigationDrawerAdapter;
import com.example.jefferson.theme.adapter.RecyclerAdapterLandscape;
import com.example.jefferson.theme.model.Landscape;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        setDrawer();
        setupRecyclerView();

    }

    private void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home Page");
        toolbar.inflateMenu(R.menu.menu_main);
        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10f);
        } else {

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String msg = "";
                switch (item.getItemId()) {
                    case R.id.delete:
                        msg = "Delete";
                        break;
                    case R.id.search:
                        msg = "Search";
                        break;
                    case R.id.edit:
                        msg = "Edit";
                        break;
                    case R.id.settings:
                        msg = "Settings";
                        break;
                    case R.id.exit:
                        msg = "Exit";
                        break;
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        }*/
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapterLandscape recyclerAdapter = new RecyclerAdapterLandscape(this, Landscape.getData());
        recyclerView.setAdapter(recyclerAdapter);

        LinearLayoutManager mliLinearLayout = new LinearLayoutManager(this);
        mliLinearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mliLinearLayout);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setDrawer(){
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drawer_frag);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment.setUpDrawer(R.id.nav_drawer_frag, drawerLayout,toolbar);

    }
}
