package com.example.jetpackcomponentsapp.databinding;
import com.example.jetpackcomponentsapp.R;
import com.example.jetpackcomponentsapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CustomBinderImpl extends CustomBinder  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.constraint_guideline_marginStart, 2);
        sViewsWithIds.put(R.id.constraint_guideline_marginEnd, 3);
        sViewsWithIds.put(R.id.constraint_guideline_marginTop, 4);
        sViewsWithIds.put(R.id.constraint_guideline_marginBottom, 5);
        sViewsWithIds.put(R.id.card_view, 6);
        sViewsWithIds.put(R.id.constraint_guideline_start, 7);
        sViewsWithIds.put(R.id.constraint_guideline_lead_quarter_vertical, 8);
        sViewsWithIds.put(R.id.constraint_guideline_trail_quarter_vertical, 9);
        sViewsWithIds.put(R.id.constraint_guideline_end, 10);
        sViewsWithIds.put(R.id.constraint_guideline_top, 11);
        sViewsWithIds.put(R.id.constraint_guideline_center_vertical, 12);
        sViewsWithIds.put(R.id.constraint_guideline_bottom, 13);
        sViewsWithIds.put(R.id.flag2, 14);
        sViewsWithIds.put(R.id.button_delete, 15);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener textViewandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of customModel.name
            //         is customModel.setName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(textView);
            // localize variables for thread safety
            // customModel.name
            java.lang.String customModelName = null;
            // customModel != null
            boolean customModelJavaLangObjectNull = false;
            // customModel
            com.example.jetpackcomponentsapp.model.CustomModel customModel = mCustomModel;



            customModelJavaLangObjectNull = (customModel) != (null);
            if (customModelJavaLangObjectNull) {




                customModel.setName(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public CustomBinderImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private CustomBinderImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[15]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (androidx.constraintlayout.widget.Guideline) bindings[13]
            , (androidx.constraintlayout.widget.Guideline) bindings[12]
            , (androidx.constraintlayout.widget.Guideline) bindings[10]
            , (androidx.constraintlayout.widget.Guideline) bindings[8]
            , (androidx.constraintlayout.widget.Guideline) bindings[5]
            , (androidx.constraintlayout.widget.Guideline) bindings[3]
            , (androidx.constraintlayout.widget.Guideline) bindings[2]
            , (androidx.constraintlayout.widget.Guideline) bindings[4]
            , (androidx.constraintlayout.widget.Guideline) bindings[7]
            , (androidx.constraintlayout.widget.Guideline) bindings[11]
            , (androidx.constraintlayout.widget.Guideline) bindings[9]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.TextView) bindings[1]
            );
        this.constraintLayoutMain.setTag(null);
        this.textView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.customModel == variableId) {
            setCustomModel((com.example.jetpackcomponentsapp.model.CustomModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCustomModel(@Nullable com.example.jetpackcomponentsapp.model.CustomModel CustomModel) {
        this.mCustomModel = CustomModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.customModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String customModelName = null;
        com.example.jetpackcomponentsapp.model.CustomModel customModel = mCustomModel;

        if ((dirtyFlags & 0x3L) != 0) {



                if (customModel != null) {
                    // read customModel.name
                    customModelName = customModel.getName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView, customModelName);
        }
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textView, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textViewandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): customModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}