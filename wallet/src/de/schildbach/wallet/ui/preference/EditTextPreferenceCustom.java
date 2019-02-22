package de.schildbach.wallet.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import de.schildbach.wallet_test.R;

public class EditTextPreferenceCustom extends EditTextPreference {
    public EditTextPreferenceCustom(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public EditTextPreferenceCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextPreferenceCustom(Context context) {
        super(context);
    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);

        final Resources res = getContext().getResources();
        final Window window = getDialog().getWindow();

        // Title
        final int titleId = res.getIdentifier("alertTitle", "id", "android");
        final View title = window.findViewById(titleId);
        if (title != null) {
            if (((TextView) title).getText().toString().equals(res.getString(R.string.preferences_trusted_peer_title)))
                ((TextView) title).setText(res.getText(R.string.preferences_trusted_peer_title_));
            else
                ((TextView) title).setText(res.getText(R.string.preferences_own_name_title_));
        }

        //OK button
        final View okButton = window.findViewById(android.R.id.button1);
        if (okButton != null)
            ((Button) okButton).setTextColor(res.getColor(R.color.bg_nav));

        //Cancel button
        final View cancelButton = window.findViewById(android.R.id.button2);
        if (cancelButton != null)
            ((Button) cancelButton).setTextColor(res.getColor(R.color.bg_nav));
    }
}
