package shapiro.presidents;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        PresidentDetailFragment fragment =
                (PresidentDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);

        ArrayList<President> presidents = (ArrayList<President>) getIntent().getSerializableExtra("PRESIDENTS");
        int[] images = getIntent().getIntArrayExtra("PRES_IMAGES");
        int position = getIntent().getIntExtra("POSITION", 0);

        fragment.showPresidentDetail(presidents, images, position);
    }
}
