package br.com.icaropinhoe.carros.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.icaropinhoe.carros.R;
import br.com.icaropinhoe.carros.fragment.CarrosFragment;

/**
 * Created by icaro on 27/12/2017.
 */

public class TabsAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public TabsAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return mContext.getString(R.string.classicos);
        }else if(position == 1){
            return mContext.getString(R.string.esportivos);
        }
        return mContext.getString(R.string.luxo);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        if(position == 0){
            frag = CarrosFragment.newInstance(R.string.classicos);
        }else if(position == 1){
            frag = CarrosFragment.newInstance(R.string.esportivos);
        }else{
            frag = CarrosFragment.newInstance(R.string.luxo);
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
