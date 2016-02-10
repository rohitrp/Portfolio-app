package io.github.rohitrp.portfolio;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final String[] appsName = {
                "Spotify Streamer",
                "Scores App",
                "Library App",
                "Build It Bigger",
                "XYZ Reader",
                "Capstone: My Own App"};

        List<String> appsNameList = new ArrayList<String>(
                Arrays.asList(appsName));

        ArrayAdapter<String> appsAdapter = new ArrayAdapter<String>(
                this.getContext(),
                R.layout.app_list,
                R.id.app_list_button,
                appsNameList);

        ListView listView = (ListView) rootView.findViewById(R.id.apps_listview);
        listView.setAdapter(appsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String appName = appsName[position];

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                    Toast.makeText(getContext(), appName, Toast.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(view, appName, Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }
}
