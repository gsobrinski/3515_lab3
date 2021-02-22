package edu.temple.lab3;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

    // constructor
    public ImageAdapter (Context context, ArrayList names) {
        this.context = context;
        this.names = names;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout linear;

        TextView nameText;

        // if there is no view to reuse
        if (convertView == null) {
            // create new layout and set it to vertical orientation
            linear = new LinearLayout(context);
            linear.setOrientation(LinearLayout.VERTICAL);

            nameText = new TextView(context);

            // attach the view to the layout as a child
            linear.addView(nameText);

        } else {
            linear = (LinearLayout) convertView;
            nameText = (TextView) linear.getChildAt(0);
        }

        nameText.setText(names.get(position));

        return linear;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
