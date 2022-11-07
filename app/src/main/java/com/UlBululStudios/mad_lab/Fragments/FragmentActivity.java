package com.UlBululStudios.mad_lab.Fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.UlBululStudios.mad_lab.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends AppCompatActivity implements FragmentInterface{

    private FragmentManager fragmentManager;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        fragmentManager = getSupportFragmentManager();

        // Adding first fragment manually, no need to do this if you have added through xml directly
        /*FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentAdapter fragmentAdapter = new FragmentAdapter();
        fragmentTransaction.add(fragmentContainer.getId(), fragmentAdapter);
        fragmentTransaction.commit();*/

    }

    @Override
    public void OnFragmentItemClick(String name) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("ItemName", name);

        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fl_fragment_container, detailFragment);
        fragmentTransaction.commit();

        if(toast == null){
            toast = Toast.makeText(this, "Clicked " + name, Toast.LENGTH_SHORT);
        }else {
            toast.cancel();
            toast = Toast.makeText(this, "Clicked " + name, Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}