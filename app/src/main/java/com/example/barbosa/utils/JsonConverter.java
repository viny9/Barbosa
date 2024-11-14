package com.example.barbosa.utils;

import com.example.barbosa.Login;
import com.google.gson.Gson;

public class JsonConverter {
    public static <T> String convert(T obj)  {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static <T> T reverter(String json, Class<T> objType)  {
        Gson gson = new Gson();
        return gson.fromJson(json, objType);
    }
}
