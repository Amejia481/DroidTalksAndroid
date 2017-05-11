package com.arturomejiamarmol.droidtalks.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arturomejiamarmol.droidtalks.R;

/**
 * Created by Arturo Mejia on 5/9/2017.
 */

public class PageFragment extends Fragment {
    private static final String ARG_PAGE = "ARG_PAGE";
    
    private int mPage;
    
    public static PageFragment newInstance(int page){
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE,page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        
        return fragment;
    }
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page,container,false);
        TextView textView = (TextView) view;
        textView.setText("Fragment #"+ mPage);
        return textView;
    }
}
