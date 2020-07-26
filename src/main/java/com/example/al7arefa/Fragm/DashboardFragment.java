package com.example.al7arefa.Fragm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.al7arefa.Al7arefaWebClient;
import com.example.al7arefa.R;

public class DashboardFragment extends Fragment {
    WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dashboard,container,false);
        webView=view.findViewById(R.id.dashboard_webview);


        webView.loadUrl("https://www.al7arefa.com/freelancerdashboard/dashboard");
        webView.setWebViewClient(new Al7arefaWebClient());

        return view;

    }

}
