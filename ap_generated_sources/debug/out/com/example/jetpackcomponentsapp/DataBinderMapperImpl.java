package com.example.jetpackcomponentsapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.jetpackcomponentsapp.databinding.AddBinderImpl;
import com.example.jetpackcomponentsapp.databinding.CustomBinderImpl;
import com.example.jetpackcomponentsapp.databinding.FragmentWelcomeBindingImpl;
import com.example.jetpackcomponentsapp.databinding.MainBinderImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ADDFRAGMENT = 1;

  private static final int LAYOUT_FRAGMENTWELCOME = 2;

  private static final int LAYOUT_ITEMSAMPLE = 3;

  private static final int LAYOUT_MAINFRAGMENT = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.jetpackcomponentsapp.R.layout.add_fragment, LAYOUT_ADDFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.jetpackcomponentsapp.R.layout.fragment_welcome, LAYOUT_FRAGMENTWELCOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.jetpackcomponentsapp.R.layout.item_sample, LAYOUT_ITEMSAMPLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.jetpackcomponentsapp.R.layout.main_fragment, LAYOUT_MAINFRAGMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ADDFRAGMENT: {
          if ("layout/add_fragment_0".equals(tag)) {
            return new AddBinderImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for add_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWELCOME: {
          if ("layout/fragment_welcome_0".equals(tag)) {
            return new FragmentWelcomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_welcome is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMSAMPLE: {
          if ("layout/item_sample_0".equals(tag)) {
            return new CustomBinderImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_sample is invalid. Received: " + tag);
        }
        case  LAYOUT_MAINFRAGMENT: {
          if ("layout/main_fragment_0".equals(tag)) {
            return new MainBinderImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for main_fragment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "customModel");
      sKeys.put(2, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/add_fragment_0", com.example.jetpackcomponentsapp.R.layout.add_fragment);
      sKeys.put("layout/fragment_welcome_0", com.example.jetpackcomponentsapp.R.layout.fragment_welcome);
      sKeys.put("layout/item_sample_0", com.example.jetpackcomponentsapp.R.layout.item_sample);
      sKeys.put("layout/main_fragment_0", com.example.jetpackcomponentsapp.R.layout.main_fragment);
    }
  }
}
