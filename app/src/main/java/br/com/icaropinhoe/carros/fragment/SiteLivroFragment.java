package br.com.icaropinhoe.carros.fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import br.com.icaropinhoe.carros.R;

public class SiteLivroFragment extends Fragment {

    private static final String URL_SOBRE = "http://www.livroandroid.com.br/site/pages/livro-android.php";
    private WebView mWebView;
    private ProgressBar mProgressBar;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    public SiteLivroFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_site_livro, container, false);

        mWebView = view.findViewById(R.id.webview);
        mProgressBar = view.findViewById(R.id.progress);
        setWebViewClient();
        mWebView.loadUrl(URL_SOBRE);

        mSwipeRefreshLayout = view.findViewById(R.id.swipeToRefresh);
            mSwipeRefreshLayout.setColorSchemeResources(
                R.color.refresh_progress_1,
                R.color.refresh_progress_2,
                R.color.refresh_progress_3
        );
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mWebView.reload();
            }
        });

        return view;
    }

    private void setWebViewClient() {
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mProgressBar.setVisibility(View.GONE);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

}
