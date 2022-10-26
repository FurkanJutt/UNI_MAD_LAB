package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class FragmentActivity extends AppCompatActivity implements FragmentInterface{

    private FrameLayout fragmentContainer;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        fragmentContainer = findViewById(R.id.fl_fragment_container);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentAdapter fragmentAdapter = new FragmentAdapter();
        fragmentTransaction.add(fragmentContainer.getId(), fragmentAdapter);
        fragmentTransaction.commit();

    }

    @Override
    public void OnFragmentItemClick(String name) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("ItemName", name);

        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fl_fragment_detail_container, detailFragment);
        fragmentTransaction.commit();

        Toast.makeText(this, "Clicked " + name, Toast.LENGTH_SHORT).show();
    }
}