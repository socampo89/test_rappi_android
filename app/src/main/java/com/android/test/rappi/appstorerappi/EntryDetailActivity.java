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

import com.android.test.rappi.appstorerappi.Models.Entry;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EntryDetailActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG_ENTRY_DATA = "TAG_ENTRY_DATA";
    @BindView(R.id.ivEntryLogo)
    ImageView ivEntryLogo;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvSummary)
    TextView tvSummary;
    @BindView(R.id.tvPrice)
    TextView tvPrice;
    @BindView(R.id.btn_get)
    Button btn_get;

    Entry entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_detail);
        ButterKnife.bind(this);
        //get the date from intent
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            entry = bundle.getParcelable(TAG_ENTRY_DATA);
        }
        else{
            finish();
        }
        setTitle(entry.getImName().getLabel());
        if(getActionBar()!=null){
            getActionBar().setDisplayHomeAsUpEnabled(true);
            getActionBar().setDisplayShowHomeEnabled(true);
        }

        Uri uri = Uri.parse(entry.getImImage().get(2).getLabel());
        Glide.with(this).load(uri).apply(RequestOptions.circleCropTransform()).into(ivEntryLogo);
        tvName.setText(entry.getImName().getLabel());
        tvSummary.setText(entry.getSummary().getLabel());
        tvPrice.setText(new StringBuilder().append(entry.getImPrice().getAttributes().getAmount()).append(" ").append(entry.getImPrice().getAttributes().getCurrency()).toString());
        btn_get.setTag(entry.getLink().getAttributes().getHref());
        btn_get.setText(entry.getImPrice().getLabel());
        btn_get.setOnClickListener(this);

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
