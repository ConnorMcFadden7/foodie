package com.connormcfadden.foodie.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.connormcfadden.foodie.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ReusableDialog extends Dialog {

    @InjectView(R.id.text_cancel_dialog)
    TextView mCancelDialog;

    @InjectView(R.id.text_add_dialog)
    TextView mInviteDialog;

    @InjectView(R.id.edit_text_meal)
    EditText mEmail;

    private List<EditText> mListOfEmails;
    private StringBuilder mStringBuilder;

    public ReusableDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_add_meal);
        ButterKnife.inject(this);
        setUpActionButtons();
        mStringBuilder = new StringBuilder();
        mListOfEmails = new ArrayList<EditText>();
        mListOfEmails.add(mEmail);
    }

    private void setUpActionButtons() {
        mCancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });

        mInviteDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo add to db and calendar
            }
        });
    }
}