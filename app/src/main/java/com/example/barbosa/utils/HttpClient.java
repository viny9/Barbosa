package com.example.barbosa.utils;

import androidx.annotation.NonNull;

import com.example.barbosa.models.ResponseCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpClient<T> {
    private final String baseUrl = "https://barber-shop-backend-eight.vercel.app/";
    private final OkHttpClient httpClient = new OkHttpClient();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public void get(String path, ResponseCallback callback) {
        Request request = new Request.Builder()
                .url(baseUrl + path)
                .get()
                .build();

        httpClient.newCall(request).enqueue(callbackResponse(callback));
    }

    public void post(String path, T obj, ResponseCallback callback) {
        String jsonBody = JsonConverter.convert(obj);
        RequestBody body = RequestBody.create(jsonBody, JSON);

        Request request = new Request.Builder()
                .url(baseUrl + path)
                .post(body)
                .build();

        httpClient.newCall(request).enqueue(callbackResponse(callback));
    }

    public void put(String path, T obj, ResponseCallback callback) {
        String jsonBody = JsonConverter.convert(obj);
        RequestBody body = RequestBody.create(jsonBody, JSON);

        Request request = new Request.Builder()
                .url(baseUrl + path)
                .put(body)
                .build();

        httpClient.newCall(request).enqueue(callbackResponse(callback));
    }

    public void delete(String path, ResponseCallback callback) {
        Request request = new Request.Builder()
                .url(baseUrl + path)
                .delete()
                .build();

        httpClient.newCall(request).enqueue(callbackResponse(callback));
    }

    private Callback callbackResponse(ResponseCallback callback) {
        return new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    callback.onResponse(response);
                } else {
                    callback.onFailure(new IOException("Erro na requisição: " + response.code()));
                }
            }
        };
    }
}
