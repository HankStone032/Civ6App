package com.example.civ6app;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class WonderAdapter extends ArrayAdapter<Wonder> {


    private final Context context;      // The activity calling this adapter
    private WonderArrayList hrList;       // The object holding the arraylist of hear rates
    private String colorString;

    /**
     *
     * @param context The activity calling this adapter
     * @param rowLayout The xml file defining the layout for one item or row in the list
     * @param dummyTV the ID for a TextView in the row layout. Not used, but needed by the parent object
     * @param hrList The object holding the arraylist of hear rates
     */
    public WonderAdapter(Context context, int rowLayout, int dummyTV, WonderArrayList hrList) {
        super(context, rowLayout, dummyTV, hrList.getList());
        this.context = context;
        this.hrList = hrList;
    }


    /**
     * This is called automatically to display each item in the list.
     *    Here you must fill the layout for one row or item in the list
     *
     * @param position index in the list that is being selected
     * @param convertView
     * @param parent The parent layout this list is in
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_wonder_list, null);
        //get the heart rate we are displaying
        Wonder hr = hrList.getWonders(position);

        TextView tvWonder=(TextView)view.findViewById(R.id.textViewWonder);
        tvWonder.setText(hr.getWonder());

        return(view);
    }


}