package coolio.gadgeothek;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Stack;

import ch.hsr.mge.gadgeothek.service.LibraryService;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {

    private FragmentManager fragmentManager;
    private enum Pages{GADGET, LIBRARYCHANGE, LOAN, LOGIN, REGISTRATION, RESERVATION}
    private Stack<Pages> pages = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LibraryService.setServerAddress("http://mge1.dev.ifs.hsr.ch/public");

        fragmentManager = getSupportFragmentManager();
        pages.push(Pages.LOGIN);
        getSupportActionBar().setTitle("Login");
        switchTo(new LoginFragment());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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
            pages.pop();
            if (pages.empty()) {
                finish();
            } else {
                switch (pages.peek()) {
                    case GADGET:
                        getSupportActionBar().setTitle("Gadgets");
                        switchTo(new GadgetFragment());
                        break;
                    case LOAN:
                        getSupportActionBar().setTitle("Ausleihen");
                        switchTo(new LoanFragment());
                        break;
                    case RESERVATION:
                        getSupportActionBar().setTitle("Reservationen");
                        switchTo(new ReservationFragment());
                        break;
                    case LOGIN:
                        getSupportActionBar().setTitle("Login");
                        switchTo(new LoginFragment());
                        break;
                    case REGISTRATION:
                        getSupportActionBar().setTitle("Registration");
                        switchTo(new RegistrationFragment());
                        break;
                    case LIBRARYCHANGE:
                        getSupportActionBar().setTitle("Bibliothek wechseln");
                        switchTo(new LibraryChangeFragment());
                        break;
                }
            }
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
        switch (item.getItemId()) {
            case R.id.nav_gadgets:
                getSupportActionBar().setTitle("Gadgets");
                pages.push(Pages.GADGET);
                switchTo(new GadgetFragment());
                break;
            case R.id.nav_loans:
                getSupportActionBar().setTitle("Ausleihen");
                pages.push(Pages.LOAN);
                switchTo(new LoanFragment());
                break;
            case R.id.nav_reservation:
                getSupportActionBar().setTitle("Reservationen");
                pages.push(Pages.RESERVATION);
                switchTo(new ReservationFragment());
                break;
            case R.id.nav_login:
                getSupportActionBar().setTitle("Login");
                pages.push(Pages.LOGIN);
                switchTo(new LoginFragment());
                break;
            case R.id.nav_registration:
                getSupportActionBar().setTitle("Registration");
                pages.push(Pages.REGISTRATION);
                switchTo(new RegistrationFragment());
                break;
            case R.id.nav_libchange:
                getSupportActionBar().setTitle("Bibliothek wechseln");
                pages.push(Pages.LIBRARYCHANGE);
                switchTo(new LibraryChangeFragment());
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void switchTo(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
