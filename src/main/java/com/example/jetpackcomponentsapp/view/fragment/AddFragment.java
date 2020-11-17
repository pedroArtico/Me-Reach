package com.example.jetpackcomponentsapp.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.jetpackcomponentsapp.MainViewModel;
import com.example.jetpackcomponentsapp.R;
import com.example.jetpackcomponentsapp.databinding.AddBinder;
import com.example.jetpackcomponentsapp.model.CustomModel;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class AddFragment extends Fragment {
    public static AddFragment  newInstance() {
        return new AddFragment();
    }
    private AddBinder binding;
    private MainViewModel viewModel;
    private TextView texto;
    private ImageView imageView;
    private Fragment MainFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.
        ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        binding = DataBindingUtil.inflate(inflater, R.layout.add_fragment,container,false);
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.editText.requestFocus();
        showSoftKeyboard();
        imageView = binding.getRoot().findViewById(R.id.flag);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyURL(binding.editText.getText().toString())) {

                    try {
                        domain(binding.editText.getText().toString());
                        hideSoftKeyboard();
                        getActivity().getSupportFragmentManager().popBackStack();
                    } catch (ProtocolException e) {

                    } catch (MalformedURLException e) {
                    }
                } else {
                    Toast.makeText(getContext(), "URL invalido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    private void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    private void domain(String url) throws ProtocolException, MalformedURLException {


        URL ur = new URL( url );
        HttpURLConnection httpConn = null;
        try {
            httpConn = (HttpURLConnection)ur.openConnection();
        } catch (IOException e) {
        }
        httpConn.setInstanceFollowRedirects( false );
        httpConn.setRequestMethod( "HEAD" );
        try{
            httpConn.connect();
            if(httpConn.getResponseCode()>400)
            {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_flag_red_36dp));
                viewModel.insertItem(
                        new CustomModel(binding.editText.getText().toString()));
                                message("SERVIDOR INATIVO");

            }
            else
                {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_flag_green_36dp));
                    viewModel.insertItem(
                            new CustomModel(binding.editText.getText().toString()));
                                    message("SERVIDOR ATIVO");
                }

        }catch(java.net.ConnectException e){

        } catch (IOException e) {
        }
    }

    private boolean verifyURL(String url)
    {
        try {
            new URL(url).toURI();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    private void message(String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(message).setCancelable(false).setPositiveButton("OK", null).show();
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                };
    }
}
