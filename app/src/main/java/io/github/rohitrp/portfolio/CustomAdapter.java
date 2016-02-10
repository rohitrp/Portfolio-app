package io.github.rohitrp.portfolio;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

/**
 * Created by Rohit on 10-02-2016.
 */
public class CustomAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] appsName;
    private final Integer[] imgIds;

    public CustomAdapter(Activity context, String[] appsName, Integer[] imgIds) {
        super(context, R.layout.app_list, appsName);

        this.context = context;
        this.appsName = appsName;
        this.imgIds = imgIds;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.app_list, null, true);

        Button button = (Button) rowView.findViewById(R.id.app_list_button);
        button.setText(appsName[position]);
        button.setBackgroundResource(imgIds[position]);

        return rowView;
    }
}
