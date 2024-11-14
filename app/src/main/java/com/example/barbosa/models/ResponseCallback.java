package com.example.barbosa.models;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Response;

public interface ResponseCallback {
    public void onFailure(@NonNull IOException e);

    public void onResponse(@NonNull Response response);
}
