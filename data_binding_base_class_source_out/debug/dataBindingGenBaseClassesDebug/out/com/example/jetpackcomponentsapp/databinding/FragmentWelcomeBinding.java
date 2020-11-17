// Generated by data binding compiler. Do not edit!
package com.example.jetpackcomponentsapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.jetpackcomponentsapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentWelcomeBinding extends ViewDataBinding {
  @NonNull
  public final Button bot;

  protected FragmentWelcomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button bot) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bot = bot;
  }

  @NonNull
  public static FragmentWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentWelcomeBinding>inflateInternal(inflater, R.layout.fragment_welcome, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWelcomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentWelcomeBinding>inflateInternal(inflater, R.layout.fragment_welcome, null, false, component);
  }

  public static FragmentWelcomeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentWelcomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentWelcomeBinding)bind(component, view, R.layout.fragment_welcome);
  }
}
