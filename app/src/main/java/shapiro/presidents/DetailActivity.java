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

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ArrayList<President> presidents = (ArrayList<President>) getIntent().getSerializableExtra("PRESIDENTS");
        PresidentPagerAdapter adapter = new PresidentPagerAdapter(new PresidentList(presidents));
        viewPager.setAdapter(adapter);

        int position = getIntent().getIntExtra("POSITION", 0);

        viewPager.setCurrentItem(position);

    }
}
