package shapiro.presidents;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

public class PresidentListFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_president_list, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        //or:
        //GsonBuilder builder = new GsonBuilder();
        //builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        //Gson gson = builder.create();
        InputStream in = getResources().openRawResource(R.raw.presidents);


        PresidentList presidents = gson.fromJson(new InputStreamReader(in), PresidentList.class);

        int[] images = {R.drawable.george_washington, R.drawable.john_adams,
                R.drawable.thomas_jefferson, R.drawable.james_madison,
                R.drawable.james_monroe, R.drawable.john_quincy_adams,
                R. drawable.andrew_jackson, R.drawable.martin_van_buren,
                R.drawable.william_henry_harrison, R.drawable.john_tyler,
                R.drawable.james_k_polk, R.drawable.zachary_taylor,
                R.drawable.millard_fillmore, R.drawable.franklin_pierce,
                R.drawable.james_buchanan, R.drawable.abraham_lincoln,
                R.drawable.andrew_johnson, R.drawable.ulysses_s_grant,
                R.drawable.rutherford_b_hayes, R.drawable.james_a_garfield,
                R.drawable.chester_a_arthur, R.drawable.grover_cleveland,
                R.drawable.benjamin_harrison, R.drawable.grover_cleveland,
                R.drawable.william_mckinley, R.drawable.theodore_roosevelt,
                R.drawable.william_howard_taft, R.drawable.woodrow_wilson,
                R.drawable.warren_g_harding, R.drawable.calvin_coolidge,
                R.drawable.herbert_hoover, R.drawable.franklin_d_roosevelt,
                R.drawable.harry_s_truman, R.drawable.dwight_d_eisenhower,
                R.drawable.john_f_kennedy, R.drawable.lyndon_b_johnson,
                R.drawable.richard_m_nixon, R.drawable.gerald_ford,
                R.drawable.jimmy_carter, R.drawable.ronald_reagan,
                R.drawable.george_h_w_bush, R.drawable.bill_clinton,
                R.drawable.george_w_bush, R.drawable.barack_obama};

        OnPresidentSelectedListener listener = (OnPresidentSelectedListener) getActivity();
        PresidentRecycleViewAdapter adapter = new PresidentRecycleViewAdapter(presidents, images, listener);
        recyclerView.setAdapter(adapter);

    }
}
