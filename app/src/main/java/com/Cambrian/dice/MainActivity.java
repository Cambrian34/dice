package com.Cambrian.dice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

/**
 * @author Alistair Chambers
 * hi there
 */
public class MainActivity extends AppCompatActivity {
    private ImageView diceImage;

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
        Button rollButton = findViewById(R.id.roll_button);
        diceImage = findViewById(R.id.dice_image);

        rollButton.setOnClickListener(v -> rollDice());
    }
    private void rollDice() {

        int randomNum = (int) (Math.random() * 6) + 1;

        int drawableResource = getResources().getIdentifier("die_" + randomNum, "drawable", getPackageName());

        // Use Glide to load the image efficiently
        Glide.with(this)
                .load(drawableResource)
                .fitCenter()
                .into(diceImage);
    }

}