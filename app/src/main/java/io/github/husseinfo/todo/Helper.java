package io.github.husseinfo.todo;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class Helper {

    public static void saveItem(Context context, String item, boolean delete) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getPackageName(), Context.MODE_PRIVATE);
        Set<String> items = new HashSet<>(sharedPref.getStringSet("items", new HashSet<>()));
        if (delete)
            items.remove(item);
        else
            items.add(item);
        sharedPref.edit().putStringSet("items", items).apply();
    }

    public static Set<String> getItems(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getPackageName(), Context.MODE_PRIVATE);
        return sharedPref.getStringSet("items", new HashSet<>());
    }
}
