package edu.temple.lab3;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

// extends BaseAdapter to get all standard Adapter methods
// implements SpinnerAdapter to use getDropDownView() - exclusive to Spinner
public class ImageAdapter extends BaseAdapter implements SpinnerAdapter {

    Context context;
    ArrayList<String> names;
    int[] images;

    // constructor
    public ImageAdapter (Context context, ArrayList names, int[] images) {

        this.context = context;
        this.names = names;
        this.images = images;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // getView is what shows on the Spinner before the user clicks it
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout linear;

        TextView nameText;

        nameText = new TextView(context);
        nameText.setText("Select a cat:");

        return nameText;
    }

    // getDropDownView is the list of dropdown options
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LinearLayout linear;
        TextView name;
        ImageView image;


        // custom layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.spinner_layout, null);

        name = (TextView) view.findViewById(R.id.text);
        image = (ImageView) view.findViewById(R.id.image);

        name.setText(names.get(position));
        image.setImageResource(images[position]);

        return view;

    }

}
