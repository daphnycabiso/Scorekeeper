package tech.hyperdev.scorekeeper.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    private ScoreFragment mScoreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_score);

        mScoreFragment = ScoreFragment.newInstance();
    }


}
