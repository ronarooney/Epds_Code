package com.example.epds_new;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FacebookFragment extends Fragment {
	
	public ProgressDialog progressDialog;
	 @Override
	public void onPause() {
		// TODO Auto-generated method stub
		 if (progressDialog.isShowing()) {
             progressDialog.dismiss();
             progressDialog = null;
         }
		super.onPause();
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
  	  if (progressDialog == null) {
            // in standard case YourActivity.this
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }
		super.onResume();
	}
	private WebView webView;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.facebook, container, false);
        webView = (WebView)rootView.findViewById(R.id.webView1);

        startWebView("https://www.facebook.com/Epdshp?fref=ts");
        return rootView;
    }
	 private void startWebView(String url) {

         //Create new webview Client to show progress dialog
         //When opening a url or click on link

         webView.setWebViewClient(new WebViewClient() {
             ProgressDialog progressDialog;

             //If you will not use this method url links are opeen in new brower not in webview
             public boolean shouldOverrideUrlLoading(WebView view, String url) {
                 view.loadUrl(url);
                 return true;
             }

             //Show loader on url load
            
           

			@Override
			public void onLoadResource(WebView view, String url) {
				// TODO Auto-generated method stub
				super.onLoadResource(view, url);
			}

			public void onPageFinished(WebView view, String url) {
                 try{
                     
                 }catch(Exception exception){
                     exception.printStackTrace();
                 }
             }

         });

         // Javascript inabled on webview
         webView.getSettings().setJavaScriptEnabled(true);

         // Other webview options
    

     /*
      String summary = "<html><body>You scored <b>192</b> points.</body></html>";
      webview.loadData(summary, "text/html", null);
      */

         //Load url in webview
         webView.loadUrl(url);


     }

     // Open previous opened link from history on webview when back button pressed


 }
