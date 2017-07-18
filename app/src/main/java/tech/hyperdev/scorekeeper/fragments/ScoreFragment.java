package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    public static ScoreFragment newInstance() {
        return new ScoreFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_score, container, false);
        readBundle(getArguments());

        TextView tvname = (TextView) view.findViewById(R.id.tvTeamName);
        tvname.setText(name + "");

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


}
