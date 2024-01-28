package io.github.husseinfo.todo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addFab = findViewById(R.id.fab_add);
        addFab.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AddItemActivity.class)));

        ListView listView = findViewById(R.id.lv_items);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, new ArrayList<>());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setPrimaryClip(ClipData.newPlainText("task", adapter.getItem(position)));
            Toast.makeText(this, "Copied ✅", Toast.LENGTH_SHORT).show();
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("❌ Delete?")
                    .setPositiveButton("❌ Delete", (dialog, which) -> {
                        Helper.saveItem(this, adapter.getItem(position), true);
                        adapter.clear();
                        adapter.addAll(Helper.getItems(this));
                    })
                    .setNegativeButton("Cancel", (dialog, which) -> {
                    })
                    .create().show();
            return true;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.clear();
            adapter.addAll(Helper.getItems(this));
        }
    }
}
