package com.example.antepimentel.eng4000.Items;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.antepimentel.eng4000.Model;
import com.example.antepimentel.eng4000.R;

public class ItemView extends AppCompatActivity {

    ListView listView;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);
        getSupportActionBar().setTitle(getString(R.string.items_title));

        listView = (ListView)findViewById(R.id.list_view);
        adapter = new ItemAdapter(ItemView.this, Model.items);

        listView.setAdapter(adapter);
    }
}
