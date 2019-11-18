package com.example.lawyerrecommender;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import common.Common;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    TextInputEditText txt_name,txt_email,txt_contact;
    TextView test;
    public ProfileFragment() {
        // Required empty public constructor
    }
    Common common=new Common();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        txt_name=view.findViewById(R.id.name);
        txt_contact=view.findViewById(R.id.contact);
        txt_email=view.findViewById(R.id.email);

        txt_name.setText( common.currentUser.getName());
        txt_email.setText(common.currentUser.getEmail());
        txt_contact.setText(common.currentUser.getContact());
        return view;

    }

}
