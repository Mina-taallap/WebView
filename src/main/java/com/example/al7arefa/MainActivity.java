package com.example.al7arefa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialog;
import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialogListener;
import com.example.al7arefa.Fragm.DashboardFragment;
import com.example.al7arefa.Fragm.FreelancersFragment;
import com.example.al7arefa.Fragm.JobFragment;
import com.example.al7arefa.Fragm.ProfileFragment;
import com.example.al7arefa.Fragm.ProposalFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    String baseURl="https://www.al7arefa.com/";
    BottomNavigationView bottomNav;
    @SuppressLint("JavascriptInterface")
    Fragment frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.main_webview);
        bottomNav=findViewById(R.id.navigation_bottom);
        bottomNav.setOnNavigationItemSelectedListener(navListner);
       // getSupportFragmentManager().beginTransaction().replace(R.id.fragemt_container,new HomeFragment()).commit();

      progressdilaogFun();
    if (isConnectedToInternet()){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.requestFocus();


        webView.setWebViewClient(new Al7arefaWebClient(){

            @Override public void onPageFinished(WebView view, String url) {


            webView.loadUrl("javascript:document.getElementByName('username').value = 'username'");

            }
        });
                        //put your url here
           webView.loadUrl("https://www.al7arefa.com/Account/Login");
           webView.loadUrl("javascript:document.getElementsByName('username').value = 'username'");
           webView.loadUrl("javascript:document.getElementsByName('password').value = 'password'");
           webView.loadUrl("javascript:document.forms['login'].submit()");


   //     webView.loadDataWithBaseURL(baseURl,widgetInfo,"text/html","UTF-8", null);

      }
      else{
          bottomNav.setVisibility(View.INVISIBLE);
          new TTFancyGifDialog.Builder(MainActivity.this)
                  .setPositiveBtnText("Internet Problom !")
                  .setMessage("check your internet connection !")
                  .setGifResource(R.drawable.internet_connection)
                  .setPositiveBtnText("ok")
                  .setPositiveBtnBackground("#22b573")
                  .isCancellable(true)
                  .OnPositiveClicked(new TTFancyGifDialogListener() {
                      @Override
                      public void OnClick() {
                          startActivity(new Intent(MainActivity.this,MainActivity.class));
                          finish();
                      }
                  }).build();
      }

    }

private BottomNavigationView.OnNavigationItemSelectedListener navListner=
             new BottomNavigationView.OnNavigationItemSelectedListener(){

                 @Override
                 public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                     Fragment selectedFragment=null;
                     switch (menuItem.getItemId())
                     {

                         case R.id.nav_dash:
                            progressdilaogFun();
                             if (isConnectedToInternet()){
                             selectedFragment=new DashboardFragment();}
                             else
                             {
                                 bottomNav.setVisibility(View.INVISIBLE);
                                 new TTFancyGifDialog.Builder(MainActivity.this)
                                         .setPositiveBtnText("Internet Problom !")
                                         .setMessage("check your internet connection !")
                                         .setGifResource(R.drawable.internet_connection)
                                         .setPositiveBtnText("ok")
                                         .setPositiveBtnBackground("#22b573")
                                         .isCancellable(true)
                                         .OnPositiveClicked(new TTFancyGifDialogListener() {
                                             @Override
                                             public void OnClick() {
                                                 startActivity(new Intent(MainActivity.this,MainActivity.class));
                                                 finish();
                                             }
                                         }).build();
                             }

                             break;
                             case R.id.nav_Jobs:
                                 progressdilaogFun();
                                 if (isConnectedToInternet()){
                             selectedFragment=new JobFragment();}
                                 else{

                                     bottomNav.setVisibility(View.INVISIBLE);
                                     new TTFancyGifDialog.Builder(MainActivity.this)
                                             .setPositiveBtnText("Internet Problom !")
                                             .setMessage("check your internet connection !")
                                             .setGifResource(R.drawable.internet_connection)
                                             .setPositiveBtnText("ok")
                                             .setPositiveBtnBackground("#22b573")
                                             .isCancellable(true)
                                             .OnPositiveClicked(new TTFancyGifDialogListener() {
                                                 @Override
                                                 public void OnClick() {
                                                     startActivity(new Intent(MainActivity.this,MainActivity.class));
                                                     finish();
                                                 }
                                             }).build();
                                 }
                            break;
                         case R.id.nav_proposal:
                             progressdilaogFun();
                             if (isConnectedToInternet()){
                                 selectedFragment=new ProposalFragment();
                             }
                             else{

                                 bottomNav.setVisibility(View.INVISIBLE);
                                 new TTFancyGifDialog.Builder(MainActivity.this)
                                         .setPositiveBtnText("Internet Problom !")
                                         .setMessage("check your internet connection !")
                                         .setGifResource(R.drawable.internet_connection)
                                         .setPositiveBtnText("ok")
                                         .setPositiveBtnBackground("#22b573")
                                         .isCancellable(true)
                                         .OnPositiveClicked(new TTFancyGifDialogListener() {
                                             @Override
                                             public void OnClick() {
                                                 startActivity(new Intent(MainActivity.this,MainActivity.class));
                                                 finish();
                                             }
                                         }).build();
                             }
                            break;
                         case R.id.nav_freelancer:
                            progressdilaogFun();
                             if (isConnectedToInternet()){
                                 selectedFragment=new FreelancersFragment();
                             }
                             else{
                                progressdilaogFun();
                                 bottomNav.setVisibility(View.INVISIBLE);
                                 new TTFancyGifDialog.Builder(MainActivity.this)
                                         .setPositiveBtnText("Internet Problom !")
                                         .setMessage("check your internet connection !")
                                         .setGifResource(R.drawable.internet_connection)
                                         .setPositiveBtnText("ok")
                                         .setPositiveBtnBackground("#22b573")
                                         .isCancellable(true)
                                         .OnPositiveClicked(new TTFancyGifDialogListener() {
                                             @Override
                                             public void OnClick() {
                                                 startActivity(new Intent(MainActivity.this,MainActivity.class));
                                                 finish();
                                             }
                                         }).build();
                             }

                            break;
                         case R.id.nav_profile:
                                progressdilaogFun();
                             if (isConnectedToInternet()){
                                 selectedFragment=new ProfileFragment();
                             }
                             else{
                                 progressdilaogFun();
                                 bottomNav.setVisibility(View.INVISIBLE);
                                 new TTFancyGifDialog.Builder(MainActivity.this)
                                         .setPositiveBtnText("Internet Problom !")
                                         .setMessage("check your internet connection !")
                                         .setGifResource(R.drawable.internet_connection)
                                         .setPositiveBtnText("ok")
                                         .setPositiveBtnBackground("#22b573")
                                         .isCancellable(true)
                                         .OnPositiveClicked(new TTFancyGifDialogListener() {
                                             @Override
                                             public void OnClick() {
                                                 startActivity(new Intent(MainActivity.this,MainActivity.class));
                                                 finish();
                                             }
                                         }).build();
                             }

                             break;


                     }
                     frag=selectedFragment;
                   if (isConnectedToInternet()){
                     getSupportFragmentManager().beginTransaction().replace(R.id.fragemt_container,
                             selectedFragment).commit();}
                   else
                   {
                       progressdilaogFun();
                       bottomNav.setVisibility(View.INVISIBLE);
                       new TTFancyGifDialog.Builder(MainActivity.this)
                               .setPositiveBtnText("Internet Problom !")
                               .setMessage("check your internet connection !")
                               .setGifResource(R.drawable.internet_connection)
                               .setPositiveBtnText("ok")
                               .setPositiveBtnBackground("#22b573")
                               .isCancellable(true)
                               .OnPositiveClicked(new TTFancyGifDialogListener() {
                                   @Override
                                   public void OnClick() {
                                       startActivity(new Intent(MainActivity.this,MainActivity.class));
                                       finish();
                                   }
                               }).build();
                   }

                     return true;
                 }
             };
    private void progressdilaogFun()
    {

        final ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading");

        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                progressDialog.dismiss();

            }
        }).start();
    }
    public boolean isConnectedToInternet() {
        boolean connected=false;

        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;


    }

   /* @Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {

            webView.goBack();
        }





    }*/

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
            webView.goBack();

    }
}
