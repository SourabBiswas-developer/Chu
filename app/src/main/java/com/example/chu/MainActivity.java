package com.example.chu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);


        Paper.init (this);



        toolbar = findViewById (R.id.toolbar);
        ///////set title color to white
        toolbar.setTitleTextColor (getResources ().getColor (R.color.white));
        ///////set three dot color as white
        toolbar.setOverflowIcon (getDrawable (R.drawable.dot));
        toolbar.setTitle ("Home");
        setSupportActionBar (toolbar);


        FloatingActionButton fab=(FloatingActionButton)findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Snackbar.make (view,"Reoplace wth your action",Snackbar.LENGTH_SHORT)
                        .setAction ("Action",null).show ();
            }
        });



        //////drawer menu settings
        drawerLayout = findViewById (R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle (this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener (drawerToggle);
        //////burger color
        drawerToggle.getDrawerArrowDrawable ().setColor (getResources ().getColor (R.color.white));
        drawerToggle.setDrawerIndicatorEnabled (true); ///////enabel hati ka khandala
        drawerToggle.syncState ();
        ///////lets select navigation view first

        navigationView = findViewById (R.id.navigationView);
        navigationView.setNavigationItemSelectedListener (this);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout)findViewById (R.id.drawer);
        if(drawer.isDrawerOpen (GravityCompat.START))
        {
            drawer.closeDrawer (GravityCompat.START);
        }else
            {
            super.onBackPressed ( );
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ///set menu layout
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate (R.menu.main_menu,menu);
        return true;
    }

////handle menue item
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId ()){
            case R.id.rateus:
                Toast.makeText (this, "Rate btn clicked", Toast.LENGTH_SHORT).show ( );
                break;

            case R.id.settings:
                Toast.makeText (this, "Rate btn clicked", Toast.LENGTH_SHORT).show ( );
                break;

            case R.id.contact:
                Toast.makeText (this, "Rate btn clicked", Toast.LENGTH_SHORT).show ( );
                break;
        }
        return super.onOptionsItemSelected (item);
    }


    @SuppressWarnings ("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId ())
    {
        case R.id.nav_cart:
            Toast.makeText (this, "Home btn clicked", Toast.LENGTH_SHORT).show ( );
            break;

        case R.id.nav_orders:
            Toast.makeText (this, "Home btn clicked", Toast.LENGTH_SHORT).show ( );
            break;

        case R.id.nav_categories:
            Toast.makeText (this, "Home btn clicked", Toast.LENGTH_SHORT).show ( );
            break;

        case R.id.nav_settings:
            Toast.makeText (this, "Home btn clicked", Toast.LENGTH_SHORT).show ( );
            break;


        case R.id.nav_logout:

           // Paper.book ().destroy ();
            Intent intent = new Intent (MainActivity.this,Good.class);
            intent.addFlags (Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity (intent);
            finish ();

            Toast.makeText (this, "Home btn clicked", Toast.LENGTH_SHORT).show ( );
            break;

    }
    DrawerLayout drawer=(DrawerLayout)findViewById (R.id.drawer);
        drawer.closeDrawer (GravityCompat.START);
        return true;
    }
}
