package com.example.barbosa.utils;

import com.example.barbosa.Login;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonConverter {
    public static <T> String convert(T obj)  {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static <T> T reverter(String json, Class<T> objType)  {
        Gson gson = new Gson();
        return gson.fromJson(json, objType);
    }

    public static <T> List<T> reverterList(String json, Class<T> objType)  {
        Gson gson = new Gson();
        Type listType = TypeToken.getParameterized(List.class, objType).getType();
        return gson.fromJson(json, listType);
    }
}
