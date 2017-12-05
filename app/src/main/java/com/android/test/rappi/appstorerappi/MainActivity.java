package com.android.test.rappi.appstorerappi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.test.rappi.appstorerappi.Models.Category;
import com.android.test.rappi.appstorerappi.Models.Entry;
import com.android.test.rappi.appstorerappi.Models.Feed;
import com.android.test.rappi.appstorerappi.Models.Result;
import com.android.test.rappi.appstorerappi.adapters.ListEntryAdapter;
import com.android.test.rappi.appstorerappi.application.App;
import com.android.test.rappi.appstorerappi.decorations.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ListEntryAdapter.ItemClickListener, AdapterView.OnItemClickListener,View.OnClickListener {

    //Views
    @BindView(R.id.recyclerViewFeeds)
    RecyclerView recyclerViewFeeds;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.left_drawer)
    ListView mDrawerList;

    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    ListEntryAdapter mAdapter;
    //data
    Feed feed;
    private String[] menuItems;
    List<String> categories = new ArrayList<>();

    //no connection vars
    @BindView(R.id.wrapper_no_data_no_conn)
    View wrapperNoDataConn;
    @BindView(R.id.btn_try)
    Button btnTry;
    @BindView(R.id.labelNoCon)
    TextView labelNoCon;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //load the menu
        menuItems = getResources().getStringArray(R.array.menu_items);

        mTitle = mDrawerTitle = getTitle();
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        recyclerViewFeeds.setHasFixedSize(true);

        int spanCount;
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            spanCount = 3;
        }
        else{
            spanCount = 5;
        }

        int spacing = 70; // 70px
        boolean includeEdge = true;
        recyclerViewFeeds.setLayoutManager(new GridLayoutManager(this, spanCount));
        recyclerViewFeeds.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        mAdapter = new ListEntryAdapter(new ArrayList<Entry>());
        mAdapter.setClickListener(MainActivity.this);
        recyclerViewFeeds.setAdapter(mAdapter);

        wrapperNoDataConn.setOnClickListener(null);
        btnTry.setOnClickListener(this);

        loading();

    }

    public void loading(){
        btnTry.setVisibility(View.GONE);
        btnTry.setOnClickListener(null);
        labelNoCon.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //Load the feed
                loadFeeds("20");
            }
        }, 1000); // 3000 milliseconds delay
    }

    public void noDataNoConnection(){
        wrapperNoDataConn.setVisibility(View.VISIBLE);
        btnTry.setVisibility(View.VISIBLE);
        labelNoCon.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        btnTry.setOnClickListener(this);
        Toast.makeText(getApplicationContext(),"No hay coneccion a internet",Toast.LENGTH_LONG).show();
    }

    public void loadingOk(){
        btnTry.setOnClickListener(this);
        wrapperNoDataConn.setVisibility(View.GONE);
    }

    //load feed from service or database
    public void loadFeeds(String limit){

        //check the internet state
        if(App.getInstance().isConnected()){
            Call<Result> mlc = App.getInstance().getServiceApple().listFeeds(limit);
            mlc.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    Result result = response.body();
                    feed = result.getFeed();

                    mAdapter.setEntryList(feed.getEntry());
                    mAdapter.notifyDataSetChanged();
                    loadCategories(feed.getEntry());

                    mDrawerList.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            R.layout.drawer_list_item, categories));
                    // Set the list's click listener
                    mDrawerList.setOnItemClickListener(MainActivity.this);

                    loadingOk();

                    // save the data on the device for offline option
                    App.getInstance().saveDataOnSharedPreferences(feed);
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    loadFeedFromPreferences();
                }
            });
        }
        else{
            //if there is not connection
            loadFeedFromPreferences();
        }

    }

    public void loadFeedFromPreferences(){

        feed = App.getInstance().getDataSharedPreferences();
        if(feed!=null){
            mAdapter.setEntryList(feed.getEntry());
            mAdapter.notifyDataSetChanged();
            loadCategories(feed.getEntry());

            mDrawerList.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                    R.layout.drawer_list_item, categories));
            // Set the list's click listener
            mDrawerList.setOnItemClickListener(MainActivity.this);

            loadingOk();
        }
        else{
            //if data is empty the empty view will be showed
            noDataNoConnection();
        }
    }

    @Override
    public void onItemClick(View view, int position) {

        Intent i = new Intent(this, EntryDetailActivity.class);
        i.putExtra(EntryDetailActivity.TAG_ENTRY_DATA, feed.getEntry().get(position));

        startActivity(i);
        overridePendingTransition(R.transition.slide_enter,R.transition.slide_leave);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        switch (item.getItemId()) {

            case R.id.action_info_app:
                if(feed!=null){
                    Intent i = new Intent(this, InfoAppActivity.class);
                    i.putExtra(InfoAppActivity.TAG_FEED_FOR_INFO, feed);

                    startActivity(i);
                    overridePendingTransition(R.transition.slide_enter,R.transition.slide_leave);

                }
                else {
                    Toast.makeText(this,"La informacion aún no esta disponible.",Toast.LENGTH_SHORT).show();
                }
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId()==R.id.left_drawer){
            //filtro de lista de categorias
            if(feed != null && !feed.getEntry().isEmpty()){
                mDrawerLayout.closeDrawer(Gravity.START);
                final List<Entry> filteredModelList = filter(feed.getEntry(),  ((TextView) view).getText().toString());
                mAdapter.animateTo(filteredModelList);
                recyclerViewFeeds.scrollToPosition(0);
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //load all categories
    public void loadCategories(List<Entry> entries){
        categories = new ArrayList<>();
        if(entries==null || entries.isEmpty()){
            return;
        }

        for (Entry entry:entries) {
            Category category = entry.getCategory();
            //buscamos si esta repetida para que no se dupliquen
            boolean encontrado = false;
            for (String cat:categories) {
                if(category.getAttributes().getLabel().equals(cat)){
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado){
                //agregamos la categoria sino fue encontrada ya cargada
                categories.add(category.getAttributes().getLabel());
            }
        }
    }

    //filter by category
    private List<Entry> filter(List<Entry> models, String query) {
        query = query.toLowerCase();

        final List<Entry> filteredModelList = new ArrayList<>();
        for (Entry model : models) {
            final String text = model.getCategory().getAttributes().getLabel().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==btnTry.getId())
        {
            loading();

        }
    }
}
