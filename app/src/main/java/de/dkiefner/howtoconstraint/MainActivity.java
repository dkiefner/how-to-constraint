package de.dkiefner.howtoconstraint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        int layoutResIdToShow = resolveLayoutToShow(view);

        Intent howToActivityIntent = HowToActivity.makeIntent(this, layoutResIdToShow);
        startActivity(howToActivityIntent);
    }

    private int resolveLayoutToShow(View view) {
        switch (view.getId()) {
            case R.id.constraints_parent:
                return R.layout.activity_constraints_parent;
            case R.id.constraints_views:
                return R.layout.activity_constraints_views;
            case R.id.bias:
                return R.layout.activity_bias;
            case R.id.ratio:
                return R.layout.activity_ratio;
            case R.id.guideline:
                return R.layout.activity_guideline;
            case R.id.chains:
                return R.layout.activity_chains;
            case R.id.groups:
                return R.layout.activity_beta_groups;
            case R.id.percent:
                return R.layout.activity_beta_percent;
            case R.id.barriers:
                return R.layout.activity_beta_barriers;
            default:
                return Constants.INVALID_ID;
        }
    }
}
