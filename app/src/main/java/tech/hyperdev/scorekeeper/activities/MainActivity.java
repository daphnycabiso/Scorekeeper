package tech.hyperdev.scorekeeper.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    int styleId = R.style.AppTheme;

    FrameLayout container1;
    FrameLayout container2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            styleId = savedInstanceState.getInt("Theme");
        }
        setTheme(styleId);

        setContentView(R.layout.activity_main);


        if(savedInstanceState == null) {

            container1 = (FrameLayout) findViewById(R.id.team1Container);
            container2 = (FrameLayout) findViewById(R.id.team2Container);

            Fragment score_one = ScoreFragment.newInstance("Team 1");
            Fragment score_two = ScoreFragment.newInstance("Team 2");

            FragmentTransaction one = getSupportFragmentManager().beginTransaction();
            one.add(R.id.team1Container, score_one).commit();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.team2Container, score_two).commit();

        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.theme_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Theme", styleId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.day_mode:
                styleId = R.style.AppTheme;
                recreate();
                break;
            case R.id.night_mode:
                styleId = R.style.AppTheme_Night;
                recreate();
                break;
        }

        return true;
    }





}
