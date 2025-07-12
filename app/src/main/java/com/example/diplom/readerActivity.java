package com.example.diplom;

import static com.example.diplom.courseUseActivity.OutDocs;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class readerActivity extends AppCompatActivity {
    private WebView webView;
    public String path;
    private static final String PPTX_MIME_TYPE = "application/vnd.openxmlformats-officedocument.presentationml.presentation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_reader);
        TextView FIO = findViewById(R.id.textView5);
        FIO.setText("ФАМИЛИЯ ИМЯ ОТЧЕСТВО");

        webView = findViewById(R.id.webview);

        for (document item : OutDocs) {
            if (item.getDoc_id() == DocumentAdapter.DocOutID) {
                path = item.getRef();
                break;
            }
        }

        // Проверяем тип содержимого
        if (isWebUrl(path)) {
            openInBrowser(path);
            finish();
        } else if (isPptxFile(path)) {
            // Обработка PPTX файлов
            copyPptxToExternalStorage();
        } else {
            // Обработка других локальных файлов
            setupWebView();
            loadHtmlFromAssets();
        }
    }

    private boolean isWebUrl(String path) {
        return path != null && (path.startsWith("http://") || path.startsWith("https://"));
    }

    private boolean isPptxFile(String path) {
        return path != null && path.toLowerCase().endsWith(".pptx");
    }

    private void copyPptxToExternalStorage() {
        try {
            // Создаем директорию, если ее нет
            File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File appDir = new File(downloadsDir, "MyAppPresentations");
            if (!appDir.exists()) {
                appDir.mkdirs();
            }

            // Создаем файл назначения
            String fileName = new File(path).getName();
            File destFile = new File(appDir, fileName);

            // Копируем файл из assets
            InputStream in = getAssets().open("documents/" + path);
            OutputStream out = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();

            // Открываем файл через Intent
            openPptxFile(destFile);

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Ошибка копирования файла", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void openPptxFile(File file) {
        try {
            Uri uri = FileProvider.getUriForFile(this,
                    getApplicationContext().getPackageName() + ".provider",
                    file);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, PPTX_MIME_TYPE);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            // Проверяем наличие приложения для открытия
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Нет приложения для открытия PPTX файлов", Toast.LENGTH_LONG).show();
                finish();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Ошибка открытия файла", Toast.LENGTH_LONG).show();
            e.printStackTrace();
            finish();
        }
    }

    private void openInBrowser(String url) {
        try {
            // Исправляем URL, если нет протокола
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            // Пытаемся открыть без проверки (на случай бага в эмуляторе)
            try {
                startActivity(intent);
                finish();
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "Нет браузера для открытия ссылки", Toast.LENGTH_LONG).show();
                finish();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Ошибка: " + e.getMessage(), Toast.LENGTH_LONG).show();
            finish();
        }
    }


    private void setupWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
    }

    private void loadHtmlFromAssets() {
        try {
            InputStream inputStream = getAssets().open(path);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String html = new String(buffer, "UTF-8");
            webView.loadDataWithBaseURL(
                    null,
                    html,
                    "text/html",
                    "UTF-8",
                    null
            );
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Ошибка загрузки файла: " + path, Toast.LENGTH_LONG).show();
            finish();
        }
    }
}