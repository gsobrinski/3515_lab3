package edu.temple.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    int[] catImages;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create ArrayList of names
        ArrayList cats = new ArrayList<String>();
        cats.add("peaceful cat");
        cats.add("very cute cat");
        cats.add("relaxing cat");
        cats.add("watchful cat");

        catImages = new int[]{R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4};

        // create the custom adapter
        ImageAdapter adapter = new ImageAdapter(this, cats);

        spinner.setAdapter(adapter);
    }
}