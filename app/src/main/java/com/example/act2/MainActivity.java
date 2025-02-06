package com.example.act2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        EditText nameTextField = findViewById(R.id.nameTextField);
        Button okButton = findViewById(R.id.okButton);
        TextView outputLabel = findViewById(R.id.outputLabel);
        Button quitButton = findViewById(R.id.quitButton);

        //Makes sure the label doesn't have any text after the view loads
        outputLabel.setText("");

        //Listener for the button
        okButton.setOnClickListener(new View.OnClickListener() {

            //Removes the warning of hardcoded text
            @SuppressLint("SetTextI18n")

            @Override
            public void onClick(View view) {

                try {

                    //Hides the keyboard after pressing the button
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                    String name = nameTextField.getText().toString();

                    outputLabel.setVisibility(View.VISIBLE);
                    outputLabel.setText("Hola "+name+"!");

                } catch (Exception e) {

                    throw new RuntimeException(e);

                }
            }
        });

        //Button to quit the app
        quitButton.setOnClickListener(view -> finish());

    }
}