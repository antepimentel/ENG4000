package com.example.antepimentel.eng4000.Goals;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.antepimentel.eng4000.Model;
import com.example.antepimentel.eng4000.R;
import java.util.ArrayList;

/**
 * Created by Ante Pimentel on 11/20/2017.
 *
 * Customer Array Adapter class for displaying a list of Goals
 */

public class GoalAdapter extends ArrayAdapter<Goal>{

    public GoalAdapter(Context context, ArrayList<Goal> goals){
        super(context, 0, goals);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final Goal goal = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.goal_layout, parent, false);
        }

        ImageView icon = (ImageView)convertView.findViewById(R.id.imageView);
        TextView title = (TextView)convertView.findViewById(R.id.title_view);
        TextView points = (TextView)convertView.findViewById(R.id.points_view);
        CheckBox cb = (CheckBox)convertView.findViewById(R.id.checkBox);

        final int index = position; // This isn't really needed

        // Set the proper icon for the goal type
        switch(Model.sGoals.get(index).getID()){

            case Goal.TYPE_ELEC:
                icon.setImageResource(R.mipmap.lightning2);
                break;

            case Goal.TYPE_WATER:
                icon.setImageResource(R.mipmap.water_colour);
                break;

            case Goal.TYPE_GAS:
                // No icon for this
                break;

            default:
                break;
        }


        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Model.sGoals.get(index).setCOMPLETE(isChecked);
                System.out.println(Model.print());
            }
        });

        // Note: These 3 lines need to be AFTER the setOnChecked listener or the checkboxes will always reset on scrolling
        cb.setChecked(Model.sGoals.get(position).isCOMPLETE());
        title.setText(Model.sGoals.get(position).getTITLE());
        points.setText("Value: " + Integer.toString(Model.sGoals.get(position).getVALUE()));

        return convertView;
    }
}
