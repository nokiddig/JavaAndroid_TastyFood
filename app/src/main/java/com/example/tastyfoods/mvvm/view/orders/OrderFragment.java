package com.example.tastyfoods.mvvm.view.orders;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tastyfoods.R;

public class OrderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_orderfragment, container, false);
        Button btnHitory =view.findViewById(R.id.btnHitory);
        Button btnDelivery =view.findViewById(R.id.btnDelivery);
        btnHitory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnHitory.setBackground(new ColorDrawable(Color.rgb(255, 204, 153)));
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction =getChildFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_main, new HitoryFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDelivery.setBackground(new ColorDrawable(Color.rgb(255, 204, 153)));
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_main, new Delivery());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}