package io.github.husseinfo.todo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends Activity {

    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        et = findViewById(R.id.et_item);

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        et.postDelayed(() -> {
            et.requestFocus();
            imm.showSoftInput(et, 0);
        }, 300);

        Button save = findViewById(R.id.btn_save);
        save.setOnClickListener(v -> {
            String text = et.getText().toString();
            Helper.saveItem(this, text, false);
            finish();
        });
    }
}
