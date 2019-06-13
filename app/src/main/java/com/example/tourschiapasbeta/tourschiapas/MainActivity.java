package com.example.tourschiapasbeta.tourschiapas;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import ahmed.easyslider.EasySlider;
import ahmed.easyslider.SliderItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, PackageFragment.OnFragmentInteractionListener, ToursFragment.OnFragmentInteractionListener {

    EasySlider slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slider = findViewById(R.id.sliderId);

        List<SliderItem> sliders = new ArrayList<>();
        sliders.add(new SliderItem("¿Qué visitar en Chiapas", R.drawable.ques));
        sliders.add(new SliderItem("Cascadas de Agua Azul",R.drawable.azule));
        sliders.add(new SliderItem("Cascadas de Chiflon", R.drawable.cas));
        sliders.add(new SliderItem("Selva Lacandona", R.drawable.landacona));

        slider.setPages(sliders);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
            Fragment fragment = null;
            Boolean FragmentoSeleccionado= false;
        if (id == R.id.nav_package) {
            fragment = new PackageFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.escenario, fragment).commit();
            FragmentoSeleccionado = true;
            slider.setVisibility(View.INVISIBLE);
        } else if (id == R.id.nav_travel) {
            fragment = new ToursFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.escenario, fragment).commit();
            FragmentoSeleccionado = true;
            slider.setVisibility(View.INVISIBLE);
        } else if (id == R.id.nav_cerrar) {
            getSupportFragmentManager().beginTransaction().replace(R.id.idlogin, fragment).commit();
        }
        if(FragmentoSeleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.escenario, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
