package com.example.Trekista;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Objects;

public class Karnataka extends AppCompatActivity {
    final ArrayList<Item> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // Ensure ActionBar is not null
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        String itemTitle = getIntent().getStringExtra(getString(R.string.intent_extra_item_title));

        // Ensure itemTitle is not null
        if (itemTitle == null) {
            finish(); // End the activity if the title is null to avoid crashes
            return;
        }

        setTitle(itemTitle);

        initItems(mItems);
        int currentPlaceIndex = getItemIndexByTitle(itemTitle);

        // Check if a valid index is found
        if (currentPlaceIndex == -1) {
            finish(); // End the activity if the item is not found to avoid crashes
            return;
        }

        inflateLayout(currentPlaceIndex);

        Button mapsButton = findViewById(R.id.maps_button);
        Button restaurantsButton = findViewById(R.id.restaurants_button);
        Button lodgingButton = findViewById(R.id.lodging_button);

        // Ensure buttons are not null
        if (mapsButton != null && restaurantsButton != null && lodgingButton != null) {
            mapsButton.setOnClickListener(v -> openMaps(mItems.get(currentPlaceIndex).getLocation()));
            restaurantsButton.setOnClickListener(v -> searchRestaurants(mItems.get(currentPlaceIndex).getLocation()));
            lodgingButton.setOnClickListener(v -> searchLodging(mItems.get(currentPlaceIndex).getLocation()));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

    private void inflateLayout(int index) {
        ImageView placeImage = findViewById(R.id.item_image);
        placeImage.setImageResource(mItems.get(index).getImageResourceId());

        TextView placeName = findViewById(R.id.item_title);
        placeName.setText(mItems.get(index).getTitle());

        TextView placeLocation = findViewById(R.id.item_location);
        placeLocation.setText(mItems.get(index).getLocation());

        TextView placeProvider = findViewById(R.id.item_provider);
        placeProvider.setText(mItems.get(index).getProvider());

        TextView placeHighlight = findViewById(R.id.item_hightlights);
        String[] highlights = mItems.get(index).getHighlights();
        StringBuilder highlightsText = new StringBuilder();
        for (String highlight : highlights) {
            highlightsText.append("* ").append(highlight).append("\n\n");
        }
        placeHighlight.setText(highlightsText.toString());
    }

    private int getItemIndexByTitle(String title) {
        for (int i = 0; i < mItems.size(); i++) {
            if (mItems.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    private void initItems(ArrayList<Item> place) {
        // Initialize items as in your original code
        place.add(new Item(getString(R.string.Shiva_moga),
                R.drawable.shimoga,
                getString(R.string.World_Trade_Park_location),
                getResources().getStringArray(R.array.World_Trade_Park_highlights),
                getString(R.string.World_Trade_Park_provider)));

        place.add(new Item(getString(R.string.Yana),
                R.drawable.yana,
                getString(R.string.Abhaneri_Stepwall_location),
                getResources().getStringArray(R.array.Abhaneri_Stepwall_highlights),
                getString(R.string.Abhaneri_Stepwall_provider)));

        place.add(new Item(getString(R.string.Agumbe),
                R.drawable.agumbe,
                getString(R.string.Galta_ji_location),
                getResources().getStringArray(R.array.Galta_ji_highlights),
                getString(R.string.Galta_ji_provider)));

        place.add(new Item(getString(R.string.Kudre),
                R.drawable.kudre,
                getString(R.string.birla_Mandir_location),
                getResources().getStringArray(R.array.birla_Mandir_highlights),
                getString(R.string.vu)));

        place.add(new Item(getString(R.string.Kumara),
                R.drawable.kumaraparvatha,
                getString(R.string.Akshardham_location),
                getResources().getStringArray(R.array.Akshardham_highlights),
                getString(R.string.Akshardham_provider)));

        place.add(new Item(getString(R.string.Dagge),
                R.drawable.kottegadde,
                getString(R.string.Central_Park_location),
                getResources().getStringArray(R.array.Central_Park_highlights),
                getString(R.string.Central_Park_provider)));

        place.add(new Item(getString(R.string.beaskund),
                R.drawable.beaskund,
                getString(R.string.Rajasthani_Food_location),
                getResources().getStringArray(R.array.Rajasthani_Food_highlights),
                getString(R.string.Hampta)));

        place.add(new Item(getString(R.string.Hampta),
                R.drawable.hampta,
                getString(R.string.BBQ_Nation_location),
                getResources().getStringArray(R.array.BBQ_Nation_highlights),
                getString(R.string.BBQ_Nation_provider)));

        place.add(new Item(getString(R.string.Pin),
                R.drawable.pinparvati,
                getString(R.string.Virasat_location),
                getResources().getStringArray(R.array.Virasat_highlights),
                getString(R.string.Virasat_provider)));

        place.add(new Item(getString(R.string.Chandra),
                R.drawable.chandrataal,
                getString(R.string.Jaipur_Adda_location),
                getResources().getStringArray(R.array.Jaipur_Adda_highlights),
                getString(R.string.Jaipur_Adda_provider)));

        place.add(new Item(getString(R.string.Bhirgu),
                R.drawable.bhirgu,
                getString(R.string.ZoloCrust_location),
                getResources().getStringArray(R.array.ZoloCrust_highlights),
                getString(R.string.ZoloCrust_provider)));

        place.add(new Item(getString(R.string.Triund),
                R.drawable.triund,
                getString(R.string.Rajput_Room_location),
                getResources().getStringArray(R.array.Rajput_Room_highlights),
                getString(R.string.Rajput_Room_provider)));

        place.add(new Item(getString(R.string.Punji),
                R.drawable.cherapunji,
                getString(R.string.Fairmont_location),
                getResources().getStringArray(R.array.Fairmont_highlights),
                getString(R.string.Fairmont_provider)));

        place.add(new Item(getString(R.string.Ibis_title),
                R.drawable.dzukouvalley,
                getString(R.string.Ibis_location),
                getResources().getStringArray(R.array.Ibis_highlights),
                getString(R.string.Ibis_provider)));

        place.add(new Item(getString(R.string.goechala),
                R.drawable.goechala,
                getString(R.string.Radission_location),
                getResources().getStringArray(R.array.Radission_highlights),
                getString(R.string.Radission_provider)));

        place.add(new Item(getString(R.string.Fall),
                R.drawable.nuranangfall,
                getString(R.string.Meridian__location),
                getResources().getStringArray(R.array.Meridian__highlights),
                getString(R.string.Meridian__provider)));

        place.add(new Item(getString(R.string.Selapass),
                R.drawable.selapass,
                getString(R.string.Oberoi_Palace_location),
                getResources().getStringArray(R.array.Oberoi_Palace_highlights),
                getString(R.string.Oberoi_Palace_provider)));

        place.add(new Item(getString(R.string.Rajasthan_Palace_title),
                R.drawable.singalila,
                getString(R.string.Rajasthan_Palace_location),
                getResources().getStringArray(R.array.Rajasthan_Palace_highlights),
                getString(R.string.Rajasthan_Palace_provider)));

        place.add(new Item(getString(R.string.Ayyanar),
                R.drawable.ayyanar,
                getString(R.string.Hawamahel_location),
                getResources().getStringArray(R.array.uv),
                getString(R.string.Hawamahel_provider)));

        place.add(new Item(getString(R.string.Kodai),
                R.drawable.kodaikanal,
                getString(R.string.Albert_hall_location),
                getResources().getStringArray(R.array.Albert_hall_highlights),
                getString(R.string.Albert_hall_provider)));

        place.add(new Item(getString(R.string.Kolli),
                R.drawable.kollihills,
                getString(R.string.Amber_Fort_location),
                getResources().getStringArray(R.array.Amber_Fort_highlights),
                getString(R.string.Amber_Fort_provider)));

        place.add(new Item(getString(R.string.Kolukkumalai),
                R.drawable.kolukkumalai,
                getString(R.string.Nahargarh_Fort_location),
                getResources().getStringArray(R.array.Nahargarh_Fort_highlights),
                getString(R.string.uv)));

        place.add(new Item(getString(R.string.Meghamalai),
                R.drawable.meghamalai,
                getString(R.string.Ab),
                getResources().getStringArray(R.array.Jantar_Mantar_highlights),
                getString(R.string.UV)));

        place.add(new Item(getString(R.string.Yercaud),
                R.drawable.yercaud,
                getString(R.string.Jal_Mahel_location),
                getResources().getStringArray(R.array.Jal_Mahel_highlights),
                getString(R.string.Jal_Mahel_provider)));
    }

    private void openMaps(String location) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(location));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    private void searchRestaurants(String location) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=restaurants near " + Uri.encode(location));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    private void searchLodging(String location) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=lodging near " + Uri.encode(location));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
