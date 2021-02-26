package com.example.student_record;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModalClass extends Application {
    public static ArrayList<MyStudnet> studnets;
    public static ArrayList<AssessmentModal> assessmentModals;
    static int alreadyPressedCategory ;
    final static String file = "students_details";
    final static String file_ = "favorite";
    final static String _file = "types";
    static ArrayList<String> typesOfProduct;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }
    void init(){
        alreadyPressedCategory = 0;
        studnets = new ArrayList<MyStudnet>();
        assessmentModals = new ArrayList<AssessmentModal>();
        typesOfProduct = new ArrayList<String>();
    }
    public static void loadProductInformation(Context context){
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPrefs.getString(file, "");
        Type type = new TypeToken<List<MyStudnet>>() {}.getType();
        studnets = gson.fromJson(json, type);
        if(studnets == null){
            studnets = new ArrayList<MyStudnet>();
            studnets.add(new MyStudnet("Abdullah","4123","V1"));
            studnets.add(new MyStudnet("Arslan","5143","V1"));
        }
    }
    public static void loadFavoriteInformation(Context context){
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPrefs.getString(file_, "");
        Type type_ = new TypeToken<List<Integer>>() {
        }.getType();
    }
    public static void saveUserInformation(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(studnets);
       // String json_ = gson.toJson(favoriteProducts);
        //String _json = gson.toJson(typesOfProduct);
        editor.putString(file, json);
        //editor.putString(file_, json_);
        //editor.putString(_file, _json);
        editor.apply();
    }
}
