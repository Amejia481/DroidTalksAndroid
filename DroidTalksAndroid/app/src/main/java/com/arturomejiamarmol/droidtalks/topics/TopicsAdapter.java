package com.arturomejiamarmol.droidtalks.topics;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arturomejiamarmol.droidtalks.R;


import java.util.List;

import com.arturomejiamarmol.droidtalks.ui.tools.Utils;
public class TopicsAdapter extends RecyclerView.Adapter<TopicsAdapter.ViewHolder> {
    

    private final OnListFragmentInteractionListener mListener;

    private List<String> topics;

    public TopicsAdapter(List<String> topics, OnListFragmentInteractionListener listener) {
        mListener = listener;
        this.topics = topics;

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.topics_item_list, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mTopic.setText(topics.get(position));
        holder.mTopic.setTextColor(Utils.getMatColor("500",holder.mTopic.getContext()));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mTopic.getText().toString());
                }
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return topics.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTopic;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTopic = (TextView) view.findViewById(R.id.topic);
        }
        
        @Override
        public String toString() {
            return super.toString() + " '" ;}
    }
}
