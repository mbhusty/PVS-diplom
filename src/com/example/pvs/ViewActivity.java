package com.example.pvs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ViewActivity extends Activity {

 	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        
        setContentView(R.layout.view);
        
        //скрываем строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        Bundle bundle = getIntent().getExtras();
        
		String itemname = "n" + bundle.getString("defStrID"); //получаем строку и формируем имя ресурса
		
		Context context = getBaseContext(); //получаем контекст
		
		//читаем текстовый файл из ресурсов по имени
		
		String text = readRawTextFile(context, getResources().getIdentifier(itemname, "raw", "com.example.pvs"));
		
        WebView myWebView = (WebView) findViewById(R.id.webView);
        String summary = "<!Doctype html><html><head><meta charset=utf-8></head><body>" + text + "</body></html>";
       myWebView.loadDataWithBaseURL(null,summary,"text/html" ,"utf-8",null);//загружаем текст в webview
    }
    
    public static String readRawTextFile(Context ctx, int resId) //читаем текст из raw
    {
         InputStream inputStream = ctx.getResources().openRawResource(resId);

            InputStreamReader inputreader = new InputStreamReader(inputStream);
            BufferedReader buffreader = new BufferedReader(inputreader);
             String line;
             StringBuilder text = new StringBuilder();

             try {
               while (( line = buffreader.readLine()) != null) {
                   text.append(line);
                   text.append('\n');
                 }
           } catch (IOException e) {
               return null;
           }
             return text.toString();
    }
}
