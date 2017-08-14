package com.arturomejiamarmol.droidtalks;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Arturo Mejia on 5/9/2017.
 */

public class MainActivityPageFragment extends Fragment {
    private static final String ARG_PAGE = "ARG_PAGE";
    
    private int mPage;
    
    public static MainActivityPageFragment newInstance(int page){
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE,page);
        MainActivityPageFragment fragment = new MainActivityPageFragment();
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
