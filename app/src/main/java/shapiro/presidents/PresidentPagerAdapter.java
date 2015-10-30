package shapiro.presidents;


import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PresidentPagerAdapter extends PagerAdapter {

    private PresidentList presidents;

    public PresidentPagerAdapter(PresidentList presidents) {
        this.presidents = presidents;
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
        //findViewById doesn't work by itself here b/c it's not part of PageAdapte
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView number = (TextView) view.findViewById(R.id.number);

        President president = presidents.get(position);
        name.setText(president.getPresident());
        number.setText(String.valueOf(president.getNumber()));

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //this is view created in instantiate item
        container.removeView((View)object);
    }
}
