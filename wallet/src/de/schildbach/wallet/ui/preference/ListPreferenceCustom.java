package de.schildbach.wallet.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import de.schildbach.wallet_test.R;

public class ListPreferenceCustom extends ListPreference {
    public ListPreferenceCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListPreferenceCustom(Context context) {
        super(context);
    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);

        final Resources res = getContext().getResources();
        final Window window = getDialog().getWindow();

        final int titleId = res.getIdentifier("alertTitle", "id", "android");
        final View title = window.findViewById(titleId);
        if (title != null) {
            ((TextView) title).setText(res.getText(R.string.preferences_precision_title_));
        }

        //OK button
        final View okButton = window.findViewById(android.R.id.button2);
        if (okButton != null)
            ((Button) okButton).setTextColor(res.getColor(R.color.bg_nav));
    }
}
