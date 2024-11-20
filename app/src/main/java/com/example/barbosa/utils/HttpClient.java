package com.example.barbosa.utils;

import java.util.concurrent.CompletableFuture;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpClient<T> {
    private final String baseUrl = "https://barber-shop-backend-eight.vercel.app";
    private final OkHttpClient httpClient = new OkHttpClient();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private String token = null;

    public HttpClient() {
    }

    public HttpClient(String token) {
        this.token = "Bearer " + token;
    }

    public CompletableFuture<Response> get(String path) {
        Request.Builder requestBuild = new Request.Builder()
                .url(baseUrl + path)
                .get();

        if (token != null) {
            requestBuild.header("Authorization", token);
        }

        Request request = requestBuild.build();

        CallbackResponse callbackResponse = new CallbackResponse();
        httpClient.newCall(request).enqueue(callbackResponse);

        return callbackResponse.getResponse();
    }

    public CompletableFuture<Response> post(String path, T obj) {
        String jsonBody = JsonConverter.convert(obj);
        RequestBody body = RequestBody.create(jsonBody, JSON);

        Request.Builder requestBuild = new Request.Builder()
                .url(baseUrl + path)
                .post(body);

        if (token != null) {
            requestBuild.header("Authorization", token);
        }

        Request request = requestBuild.build();

        CallbackResponse callbackResponse = new CallbackResponse();
        httpClient.newCall(request).enqueue(callbackResponse);

        return callbackResponse.getResponse();
    }

    public CompletableFuture<Response> put(String path, T obj) {
        String jsonBody = JsonConverter.convert(obj);
        RequestBody body = RequestBody.create(jsonBody, JSON);

        Request.Builder requestBuild = new Request.Builder()

                .url(baseUrl + path)
                .put(body);

        if (token != null) {
            requestBuild.header("Authorization", token);
        }

        Request request = requestBuild.build();

        CallbackResponse callbackResponse = new CallbackResponse();
        httpClient.newCall(request).enqueue(callbackResponse);

        return callbackResponse.getResponse();
    }

    public CompletableFuture<Response> delete(String path) {
        Request.Builder requestBuild = new Request.Builder()
                .url(baseUrl + path)
                .delete();

        if (token != null) {
            requestBuild.header("Authorization", token);
        }

        Request request = requestBuild.build();

        CallbackResponse callbackResponse = new CallbackResponse();
        httpClient.newCall(request).enqueue(callbackResponse);

        return callbackResponse.getResponse();
    }
}
