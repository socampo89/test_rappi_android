package com.android.test.rappi.appstorerappi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.test.rappi.appstorerappi.Models.Feed;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoAppActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG_FEED_FOR_INFO = "TAG_FEED_FOR_INFO" ;
    Feed feed;

    @BindView(R.id.iconAppStore)
    ImageView appStoreIcon;
    @BindView(R.id.tv_app_store_name)
    TextView tvAppStoreName;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.copyright)
    TextView tvCopyright;

    @BindView(R.id.btn_get)
    Button btn_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_app);
        ButterKnife.bind(this);
        //get the date from intent
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            feed = bundle.getParcelable(TAG_FEED_FOR_INFO);
            Uri uri = Uri.parse(feed.getIcon().getLabel());
            Glide.with(this).load(uri).apply(RequestOptions.circleCropTransform()).into(appStoreIcon);
            tvAppStoreName.setText(feed.getAuthor().getName().getLabel());
            if(feed.getTitle()!=null){
                tvTitle.setText(feed.getTitle().getLabel());
            }
            if(feed.getRights()!=null){
                tvCopyright.setText(feed.getRights().getLabel());
            }
            btn_link.setTag(feed.getAuthor().getUri().getLabel());
            btn_link.setOnClickListener(this);
        }
        else{
            finish();
        }

        if(getActionBar()!=null){
            getActionBar().setDisplayHomeAsUpEnabled(true);
            getActionBar().setDisplayShowHomeEnabled(true);
        }




    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_get){
            Uri uri = Uri.parse(view.getTag().toString());

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(uri);
            startActivity(i);
            overridePendingTransition(R.transition.slide_enter,R.transition.slide_leave);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.transition.slide_leave_right_left, R.transition.slide_enter_right_left);
    }

    @Override public void finish() {
        super.finish();
        overridePendingTransition(R.transition.slide_leave_right_left, R.transition.slide_enter_right_left);
    }
}
