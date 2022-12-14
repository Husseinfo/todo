package io.github.husseinfo.todo;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class Helper {

    public static void saveItem(Context context, String item, boolean delete) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getPackageName(), Context.MODE_PRIVATE);
        Set<String> items = sharedPref.getStringSet("items", new HashSet<>());
        Set<String> newItems = new HashSet<>(items);
        if (delete)
            newItems.remove(item);
        else
            newItems.add(item);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putStringSet("items", newItems);
        editor.apply();
    }

    public static Set<String> getItems(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getPackageName(), Context.MODE_PRIVATE);
        return sharedPref.getStringSet("items", new HashSet<>());
    }
}
