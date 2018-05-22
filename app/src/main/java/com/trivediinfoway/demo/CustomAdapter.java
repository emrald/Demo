package com.trivediinfoway.demo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TI A1 on 12-04-2018.
 */

public class CustomAdapter extends BaseAdapter {

    ArrayList<Match> listMatch;
    private LayoutInflater inflater;
    private Activity activity;

    public CustomAdapter(Activity activity, ArrayList<Match> listMatch) {
        this.activity = activity;
        this.listMatch = listMatch;
    }

    @Override
    public int getCount() {
        return listMatch.size();
    }

    @Override
    public Object getItem(int i) {
        return listMatch.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.list_row, null);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        TextView textView2 = (TextView) view.findViewById(R.id.textView2);
        TextView textView3 = (TextView) view.findViewById(R.id.textView3);
        TextView textView4 = (TextView) view.findViewById(R.id.textView4);
        TextView textView5 = (TextView) view.findViewById(R.id.textView5);
        TextView textView6 = (TextView) view.findViewById(R.id.textView6);
        TextView textView7 = (TextView) view.findViewById(R.id.textView7);
        TextView textView8 = (TextView) view.findViewById(R.id.textView8);
        TextView textView9 = (TextView) view.findViewById(R.id.textView9);
        TextView textView10 = (TextView) view.findViewById(R.id.textView10);
        TextView textView11 = (TextView) view.findViewById(R.id.textView11);
        TextView textView12 = (TextView) view.findViewById(R.id.textView12);
        TextView textView13 = (TextView) view.findViewById(R.id.textView13);
        TextView textView14 = (TextView) view.findViewById(R.id.textView14);
        TextView textView15 = (TextView) view.findViewById(R.id.textView15);
        TextView textView16 = (TextView) view.findViewById(R.id.textView16);
        TextView textView17 = (TextView) view.findViewById(R.id.textView17);
        TextView textView18 = (TextView) view.findViewById(R.id.textView18);
        TextView textView19 = (TextView) view.findViewById(R.id.textView19);
        TextView textView20 = (TextView) view.findViewById(R.id.textView20);

        Match mData = listMatch.get(i);
        textView.setText("ID = " + mData.getId());
        textView2.setText("type = " + mData.getType());
        textView3.setText("srs = " + mData.getSrs());
        textView4.setText("mchDesc = " + mData.getMchDesc());
        textView5.setText("mnum = " + mData.getMnum());
        textView6.setText("vcity = " + mData.getVcity());
        textView7.setText("vcountry = " + mData.getVcountry());
        textView8.setText("grnd = " + mData.getGrnd());
        textView9.setText("inngCnt = " + mData.getInngCnt());
        textView10.setText("datapath = " + mData.getDatapath());
        textView11.setText("mchState = " + mData.getStateList().get(i).getMchState());
        textView12.setText("status = " + mData.getStateList().get(i).getStatus());
        textView13.setText("Tw = " + mData.getStateList().get(i).getTW());
        textView14.setText("decisn = " + mData.getStateList().get(i).getDecisn());
        textView15.setText("addnStatus = " + mData.getStateList().get(i).getAddnStatus());
        textView16.setText("splStatus = " + mData.getStateList().get(i).getSplStatus());

        textView17.setText("id = " + mData.getTmList().get(i).getId());
        textView18.setText("Name = " + mData.getTmList().get(i).getName());
        textView19.setText("sName = " + mData.getTmList().get(i).getsName());
        textView20.setText("flag = " + mData.getTmList().get(i).getFlag());


        return view;
    }
}
