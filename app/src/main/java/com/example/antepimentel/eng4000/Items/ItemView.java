package com.example.antepimentel.eng4000.Items;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.antepimentel.eng4000.Data.Model;
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

        // Setup the adapter
        adapter = new ItemAdapter(ItemView.this, Model.getItems());
        listView.setAdapter(adapter);

        // Setup the on click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int posSelected = position;
                Item itemSelected = Model.getItems().get(posSelected);

                if(itemSelected.isObtained()){
                    if(itemSelected.getImage() == Model.getSlots().get(itemSelected.getType())){
                        // Item is already equip
                        Model.getSlots().put(itemSelected.getType(), -1);
                        Toast.makeText(getApplicationContext(), itemSelected.getName()+" has been removed", Toast.LENGTH_SHORT).show();
                    } else {
                        // Item is owned, users wants to equip
                        Model.getSlots().put(itemSelected.getType(), itemSelected.getImage());
                        Toast.makeText(getApplicationContext(), itemSelected.getName()+" has been equip", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Do not own item
                    Toast.makeText(getApplicationContext(), "You do not own this item", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onStop(){
        super.onStop();
        Model.saveData(getFilesDir());
    }
}
