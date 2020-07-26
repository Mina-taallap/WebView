package com.example.al7arefa.Fragm;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.al7arefa.Al7arefaWebClient;
import com.example.al7arefa.MainActivity;
import com.example.al7arefa.R;

public class ProfileFragment extends Fragment {
    WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmnt_profile,container,false);
        webView=view.findViewById(R.id.profile_webview);
        webView.loadUrl("https://www.al7arefa.com/profile");
        webView.setWebViewClient(new Al7arefaWebClient());

        return view;

    }
}
