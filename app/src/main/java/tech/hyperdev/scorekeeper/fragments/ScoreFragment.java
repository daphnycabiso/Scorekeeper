package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {


    public View view;
    public String name;
    public int fscore;
    public String arg;


    public ScoreFragment() {
        // Required empty public constructor
    }

    ImageButton btnAdd, btnSub;
    Spinner spinner;
    int score;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_score, container, false);
        readBundle(getArguments());

        TextView tvname = (TextView) view.findViewById(R.id.tvTeamName);
        tvname.setText(name + "");


        btnAdd = (ImageButton) view.findViewById(R.id.btnPlus);
        btnSub = (ImageButton) view.findViewById(R.id.btnMinus);

        final TextView tvScore = (TextView) view.findViewById(R.id.textScore);
        score = Integer.parseInt(tvScore.getText().toString());
        if(savedInstanceState!=null){
            score = savedInstanceState.getInt("Score",score);
            tvScore.setText(""+score);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"Add"+score,Toast.LENGTH_SHORT).show();
                ++score;
                tvScore.setText(" "+score);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"Minus"+score, Toast.LENGTH_SHORT).show();
                --score;
                tvScore.setText(" "+score);

            }
        });


        return view;

    }




    public static ScoreFragment newInstance(String name){
        Bundle bundle = new Bundle();
        bundle.putString("name",name);

        ScoreFragment fragment = new ScoreFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            name = bundle.getString("name");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Score",score);
    }


}
