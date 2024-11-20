package com.example.barbosa.utils;

import androidx.annotation.NonNull;


import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CallbackResponse implements Callback {
    private final CompletableFuture<Response> response = new CompletableFuture<>();

    public CallbackResponse() {
    }

    public CompletableFuture<Response> getResponse() {
        return response;
    }

    @Override
    public void onFailure(@NonNull Call call, @NonNull IOException e) {
        this.response.completeExceptionally(e);
    }

    @Override
    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
        this.response.complete(response);
    }
}
