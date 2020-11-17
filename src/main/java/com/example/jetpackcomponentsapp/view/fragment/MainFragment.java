package com.example.jetpackcomponentsapp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetpackcomponentsapp.MainViewModel;
import com.example.jetpackcomponentsapp.R;
import com.example.jetpackcomponentsapp.databinding.MainBinder;
import com.example.jetpackcomponentsapp.model.CustomModel;
import com.example.jetpackcomponentsapp.view.CustomListeners;
import com.example.jetpackcomponentsapp.view.MainActivity;
import com.example.jetpackcomponentsapp.view.adapter.CustomAdapter;

import java.util.List;

public class MainFragment extends Fragment implements CustomListeners {

    public MainFragment() {
    }

    public static MainFragment  newInstance() {
        return new MainFragment();
    }

    private MainBinder binding;
    private MainViewModel viewModel;
    private CustomAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        setRecyclerView();
        setFloatingActionButton();
    }

    private void setRecyclerView() {
        adapter = new CustomAdapter(getContext(),this);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        binding.recyclerView.setAdapter(adapter);

        viewModel.getItems().observe(getViewLifecycleOwner(), new Observer<List<CustomModel>>() {
            @Override
            public void onChanged(List<CustomModel> list) {
                binding.recyclerView.removeAllViews();
                adapter.setItems(list);
                adapter.notifyDataSetChanged();
            }
        });

        binding.recyclerView.setHasFixedSize(true);
    }

    private void setFloatingActionButton() {
        binding.floatingActionButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAdd();
            }
        });
    }

    private void onAdd() {
        ((MainActivity)getActivity()).callAddFragment();
    }


    @Override
    public void onDelete(CustomModel item, int position) {
        viewModel.deleteItem(item);
    }
}
