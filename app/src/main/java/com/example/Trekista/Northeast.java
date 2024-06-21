package com.example.Trekista;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

//Create LodgeFragment
public class Northeast extends Fragment {
    //Create LodgeFragment constructor
    public Northeast() {
        //empty constructor
    }

    //Override onStart method
    @Override
    public void onStart() {
        super.onStart();
    }

    //Override onCreateView method
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //First, create a rootView and inflate layout from item_listview
        View rootView = inflater.inflate(R.layout.item_listview, container, false);

        //Create a ArrayList of Item
        final ArrayList<Item> items = new ArrayList<Item>();

        //Add list data
        items.add(new Item(getString(R.string.Punji),
                R.drawable.cherapunji,
                getString(R.string.Fairmont_location)));

        items.add(new Item(getString(R.string.Ibis_title),
                R.drawable.dzukouvalley,
                getString(R.string.Ibis_location)));

        items.add(new Item(getString(R.string.goechala),
                R.drawable.goechala,
                getString(R.string.Radission_location)));

        items.add(new Item(getString(R.string.Fall),
                R.drawable.nuranangfall,
                getString(R.string.Meridian__location)));

        items.add(new Item(getString(R.string.Selapass),
                R.drawable.selapass,
                getString(R.string.Oberoi_Palace_location)));

        items.add(new Item(getString(R.string.Rajasthan_Palace_title),
                R.drawable.singalila,
                getString(R.string.Rajasthan_Palace_location)));

        //Create an ItemAdapter
        final ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        //Get list view
        ListView listView = rootView.findViewById(R.id.list);

        //Bind with adapter
        listView.setAdapter(adapter);

        //Create a onClickLIstener when listview item clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Get current item index
                Item currentItem = items.get(i);

                //Create an Intent
                Intent itemDetailIntent = new Intent(getContext(), Karnataka.class);

                //Add an extra var; ITEM_TITEL so we can reference in the placeDetail activity
                itemDetailIntent.putExtra(getString(R.string.intent_extra_item_title), currentItem.getTitle());

                //Start the intent
                startActivity(itemDetailIntent);
            }
        });

        //Return the view
        return rootView;
    }
}