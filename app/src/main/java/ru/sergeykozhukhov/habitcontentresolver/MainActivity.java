package ru.sergeykozhukhov.habitcontentresolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView loadTextView;
    private Button loadButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadTextView = findViewById(R.id.load_text_view);
        loadButton = findViewById(R.id.load_button);

        initListeners();

    }


    private void initListeners(){
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTextView.setText(loadHabits());
            }
        });
    }



    private CharSequence loadHabits() {

        StringBuilder stringBuilder = new StringBuilder();

        try (Cursor cursor = getContentResolver().query(HabitsModel.Columns.URI, null, null, null, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    stringBuilder.append(getString(R.string.test_load_1));
                    stringBuilder.append(cursor.getString(cursor.getColumnIndex(HabitsModel.Columns.ID)));
                    stringBuilder.append(getString(R.string.test_load_2));
                    stringBuilder.append(cursor.getString(cursor.getColumnIndex(HabitsModel.Columns.TITLE)));
                    stringBuilder.append(getString(R.string.test_load_3));
                    stringBuilder.append(cursor.getString(cursor.getColumnIndex(HabitsModel.Columns.DESCRIPTION)));
                    stringBuilder.append("\n");
                } while (cursor.moveToNext());
            }
        }
        return stringBuilder;
    }
}
