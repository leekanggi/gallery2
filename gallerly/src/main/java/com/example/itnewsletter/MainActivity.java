// MainActivity.java
package com.example.itnewsletter;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 웹 뷰 초기화
        webView = findViewById(R.id.webView);

        // JavaScript 사용 허용
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // 버튼 클릭 이벤트 처리
        Button newsletterButton = findViewById(R.id.newsletterButton);
        newsletterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewsletter();
            }
        });
    }

    private void openNewsletter() {
        // 뉴스레터 URL을 여기에 입력
        String newsletterUrl = "https://www.mmu.ac.kr/S1/board/469";

        // WebViewClient 설정
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        // 웹 페이지 로드
        webView.loadUrl(newsletterUrl);
    }

    // 액티비티 종료 시 웹 뷰 정리
    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroy();
    }
}