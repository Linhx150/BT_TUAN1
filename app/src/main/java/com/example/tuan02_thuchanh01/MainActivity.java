package com.example.tuan02_thuchanh01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText hoten, tuoi;
    Button xacnhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        hoten = findViewById(R.id.edtname);
        tuoi = findViewById(R.id.edttuoi);
        xacnhan = findViewById(R.id.btncheck);

        xacnhan.setOnClickListener(view -> handlecheck());

    }

    void handlecheck() {
        String name = hoten.getText().toString().trim();
        String ageStr = tuoi.getText().toString().trim();

        if (name.isEmpty() || ageStr.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ họ tên và tuổi.", Toast.LENGTH_SHORT).show();
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Tuổi phải là một số hợp lệ.", Toast.LENGTH_SHORT).show();
            return;
        }

        String category;
        if (age < 2) {
            category = "em bé";
        } else if (age <= 6) {
            category = "trẻ em";
        } else if (age <= 65) {
            category = "người lớn";
        } else {
            category = "người già";
        }

        String message = name + " là " + category;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}