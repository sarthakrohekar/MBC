package com.example.simpleanimationpractice;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonTranslate;
    private Button buttonRotate;
    private Button buttonScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTranslate = findViewById(R.id.buttonTranslate);
        buttonRotate = findViewById(R.id.buttonRotate);
        buttonScale = findViewById(R.id.buttonScale);

        // Set click listeners for each button to trigger its respective animation
        buttonTranslate.setOnClickListener(view -> startTranslateAnimation());
        buttonRotate.setOnClickListener(view -> startRotateAnimation());
        buttonScale.setOnClickListener(view -> startScaleAnimation());
    }

    // Translate Animation
    private void startTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.ABSOLUTE, 0f, // From 0 to 500 pixels on X-axis
                Animation.ABSOLUTE, 500f, // Move 500 pixels on the X-axis
                Animation.ABSOLUTE, 0f, // No movement on the Y-axis
                Animation.ABSOLUTE, 0f); // No movement on the Y-axis

        translateAnimation.setDuration(1000); // Duration 1 second
        translateAnimation.setFillAfter(true); // Keep the final position of the animation
        buttonTranslate.startAnimation(translateAnimation); // Start animation on the button
    }

    // Rotate Animation
    private void startRotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(
                0f, 360f, // Rotate from 0 to 360 degrees
                Animation.RELATIVE_TO_SELF, 0.5f, // Rotate around the center of the button (X-axis)
                Animation.RELATIVE_TO_SELF, 0.5f); // Rotate around the center of the button (Y-axis)

        rotateAnimation.setDuration(1000); // Duration 1 second
        rotateAnimation.setRepeatCount(1); // Rotate once
        buttonRotate.startAnimation(rotateAnimation); // Start animation on the button
    }

    // Scale Animation
    private void startScaleAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 2f, // Scale from 1 to 2 (x-axis)
                1f, 2f, // Scale from 1 to 2 (y-axis)
                Animation.RELATIVE_TO_SELF, 0.5f, // Scale relative to the center (x-axis)
                Animation.RELATIVE_TO_SELF, 0.5f); // Scale relative to the center (y-axis)

        scaleAnimation.setDuration(1000); // Duration 1 second
        scaleAnimation.setRepeatMode(Animation.REVERSE); // Shrink back to original size
        scaleAnimation.setRepeatCount(1); // Repeat the shrinking once
        buttonScale.startAnimation(scaleAnimation); // Start animation on the button
    }
}
