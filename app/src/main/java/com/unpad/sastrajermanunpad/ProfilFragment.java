package com.unpad.sastrajermanunpad;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class ProfilFragment extends Fragment {

    public ProfilFragment() {
        // Required empty public constructor
    }

    WebView view;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profil, container, false);

        String url = "http://jerman.fib.unpad.ac.id/profil/";

        view = (WebView) rootView.findViewById(R.id.profilWeb);

        progressBar = (ProgressBar) rootView.findViewById(R.id.myProgressBar);

        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().getAllowContentAccess();
        view.getSettings().setAppCacheEnabled(true);
        view.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        view.getSettings().setLoadsImagesAutomatically(true);
        view.getSettings().setDomStorageEnabled(true);

        if(Build.VERSION.SDK_INT >= 19){
            view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }else{
            view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        view.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url)
            {
                progressBar.setVisibility(View.GONE);
                view.loadUrl("javascript:(function() { " +
                        "var menu = document.getElementsByClassName('mobile-menu-anchor primary-menu')[0];"
                        + "menu.parentNode.removeChild(menu);" +
                        "var search = document.getElementsByClassName('widget widget_search')[0];"
                        + "search.parentNode.removeChild(search);" +
                        "var post = document.getElementsByClassName('widget widget_recent_entries')[0];"
                        + "post.parentNode.removeChild(post);" +
                        "var meta = document.getElementsByClassName('widget widget_meta')[0];"
                        + "meta.parentNode.removeChild(meta);" +
                        "})()");
            }
        });

        view.canGoBack();
        view.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && view.canGoBack()) {
                    view.goBack();
                    return true;
                }
                return false;
            }
        });

        view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        view.loadUrl(url);

        return rootView ;
    }
}