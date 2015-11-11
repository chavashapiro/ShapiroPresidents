package shapiro.presidents;


import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PresidentPagerAdapter extends PagerAdapter {

    private PresidentList presidents;
    private int[] images;

    public PresidentPagerAdapter(PresidentList presidents, int[] images) {
        this.presidents = presidents;
        this.images = images;
    }

    @Override
    public int getCount() {
        return presidents.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.president_pager_item, null);
        //findViewById doesn't work by itself here b/c it's not part of PageAdapter

        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView number = (TextView) view.findViewById(R.id.number);
        TextView aliveYears = (TextView) view.findViewById(R.id.aliveYears);
        TextView officeYears = (TextView) view.findViewById(R.id.officeYears);
        TextView party = (TextView) view.findViewById(R.id.party);

        President president = presidents.get(position);
        image.setImageResource(images[position]);
        image.setAdjustViewBounds(true);
        name.setText(president.getPresident());
        number.setText(String.valueOf(president.getNumber()));
        if(president.getDeathYear() != null) {
            aliveYears.setText(String.valueOf(president.getBirthYear() + "-" + String.valueOf(president.getDeathYear())));
        } else {
            aliveYears.setText(String.valueOf(president.getBirthYear()));
        }
        if (president.getLeftOffice() != null) {
            officeYears.setText(president.getTookOffice() + "--" + president.getLeftOffice());
        } else {
            officeYears.setText(president.getTookOffice());
        }
        party.setText(president.getParty());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //this is view created in instantiate item
        container.removeView((View)object);
    }
}
