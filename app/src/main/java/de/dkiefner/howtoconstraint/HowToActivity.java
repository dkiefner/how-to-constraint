package de.dkiefner.howtoconstraint;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HowToActivity extends AppCompatActivity {

    private static final String EXTRA_LAYOUT_RES_ID = "layoutResIdToShow";

    public static Intent makeIntent(Context context, @LayoutRes int layoutResIdToShow) {
        if (layoutResIdToShow < 1) {
            throw new IllegalStateException("Specified layout res id " + layoutResIdToShow + " is not valid.");
        }
        Intent intent = new Intent(context, HowToActivity.class);
        intent.putExtra(EXTRA_LAYOUT_RES_ID, layoutResIdToShow);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int layoutResIdToShow = intent.getIntExtra(EXTRA_LAYOUT_RES_ID, Constants.INVALID_ID);
        setContentView(layoutResIdToShow);
    }

    public void onToggleVisibility(View view) {
        View groupTexts = findViewById(R.id.group_texts);
        if (groupTexts.getVisibility() == View.GONE) {
            groupTexts.setVisibility(View.VISIBLE);
        } else {
            groupTexts.setVisibility(View.GONE);
        }
    }

    public void onHideViewClick(View view) {
        view.setVisibility(View.GONE);
    }
}
