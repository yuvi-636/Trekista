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

public class TamilNadu extends Fragment {
    public TamilNadu() {
    }


    @Override
    public void onStop() {
        super.onStop();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_listview, container, false);
        final ArrayList<Item> inner_Details = new ArrayList<>();

        inner_Details.add(new Item(getString(R.string.Ayyanar),
                R.drawable.ayyanar,
                getString(R.string.Hawamahel_location)));

        inner_Details.add(new Item(getString(R.string.Kodai),
                R.drawable.kodaikanal,
                getString(R.string.Albert_hall_location)));

        inner_Details.add(new Item(getString(R.string.Kolli),
                R.drawable.kollihills,
                getString(R.string.Amber_Fort_location)));

        inner_Details.add(new Item(getString(R.string.Kolukkumalai),
                R.drawable.kolukkumalai,
                getString(R.string.Nahargarh_Fort_location)));

        inner_Details.add(new Item(getString(R.string.Meghamalai),
                R.drawable.meghamalai,
                getString(R.string.Ab)));

        inner_Details.add(new Item(getString(R.string.Yercaud),
                R.drawable.yercaud,
                getString(R.string.Jal_Mahel_location)));

        final ItemAdapter adapter = new ItemAdapter(getActivity(), inner_Details);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item Current_list = inner_Details.get(i);

                Intent itemDetailIntent = new Intent(getContext(), Karnataka.class);

                itemDetailIntent.putExtra(getString(R.string.intent_extra_item_title),
                        Current_list.getTitle());

                startActivity(itemDetailIntent);
            }
        });
        return rootView;
    }
}