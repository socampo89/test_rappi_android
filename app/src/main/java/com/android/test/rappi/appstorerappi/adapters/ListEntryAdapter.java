package com.android.test.rappi.appstorerappi.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.test.rappi.appstorerappi.Models.Entry;
import com.android.test.rappi.appstorerappi.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ListEntryAdapter extends RecyclerView.Adapter<ListEntryAdapter.ViewHolder> {

    List<Entry> entryList;
    private ItemClickListener mClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ItemClickListener mClickListener;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.ivImage)
        ImageView ivImage;

        public ViewHolder(View v,ItemClickListener mClickListener) {
            super(v);
            ButterKnife.bind(this, v);
            this.mClickListener = mClickListener;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListEntryAdapter(List<Entry> entryList) {
        this.entryList = entryList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListEntryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_feed_entrys, parent, false);

        ViewHolder vh = new ViewHolder(v,mClickListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(entryList.get(position).getImName().getLabel());
        Uri uri = Uri.parse(entryList.get(position).getImImage().get(1).getLabel());
        Glide.with(holder.ivImage.getContext()).load(uri).apply(RequestOptions.circleCropTransform()).into(holder.ivImage);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return entryList.size();
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    /**
     * Filter Logic
     **/
    public void animateTo(List<Entry> entries) {
        applyAndAnimateRemovals(entries);
        applyAndAnimateAdditions(entries);
        applyAndAnimateMovedItems(entries);

    }

    private void applyAndAnimateRemovals(List<Entry> newModels) {

        for (int i = newModels.size() - 1; i >= 0; i--) {
            final Entry model = newModels.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<Entry> newModels) {

        for (int i = 0, count = newModels.size(); i < count; i++) {
            final Entry model = newModels.get(i);
            if (!newModels.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<Entry> newModels) {

        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final Entry model = newModels.get(toPosition);
            final int fromPosition = entryList.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public Entry removeItem(int position) {
        final Entry model = entryList.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, Entry model) {
        entryList.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final Entry model = entryList.remove(fromPosition);
        entryList.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
}
