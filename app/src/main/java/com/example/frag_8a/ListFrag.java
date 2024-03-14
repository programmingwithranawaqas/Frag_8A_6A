package com.example.frag_8a;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;


public class ListFrag extends ListFragment {

    NameSelected parentActivity;

    public interface NameSelected{
        public void onNameClick(int position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        parentActivity = (NameSelected) context;

    }

    public ListFrag()
    {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Raza");
        names.add("Waqas");
        names.add("Farooq");

        setListAdapter(new ArrayAdapter<String>(requireActivity(), android.R.layout.simple_dropdown_item_1line, names));

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        parentActivity.onNameClick(position);
    }


}