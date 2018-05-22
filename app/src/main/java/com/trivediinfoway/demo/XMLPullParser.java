package com.trivediinfoway.demo;

import android.content.res.XmlResourceParser;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class XMLPullParser extends AppCompatActivity {

    ListView listview;
    LinearLayout ll1;
    // private static final String xmlUrl = "http://dl.dropbox.com/u/7215751/JavaCodeGeeks/AndroidFullAppTutorialPart03/Transformers+2007.xml";

    private static final String xmlUrl = "http://synd.cricbuzz.com/j2me/1.0/livematches.xml";

    private static final String xmlUrl_commntry = "http://synd.cricbuzz.com/j2me/1.0/match/2018/IPL_2018/RCB_RR_APR15/commentary.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlpull_parser);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        listview = (ListView) findViewById(R.id.listview);
        ll1 = (LinearLayout)findViewById(R.id.ll1);

        try {
            //   parseFromUrl1();
            parseFromCommnetary();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseFromCommnetary() throws Exception {

        ArrayList<Match> matchList = null;

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(false);
        XmlPullParser xpp = factory.newPullParser();

        URL url = new URL(xmlUrl_commntry);
        URLConnection ucon = url.openConnection();
        InputStream is = ucon.getInputStream();

        xpp.setInput(is, null);

        matchList = parseMovieaCommntry(xpp);
        Log.e("matchList", matchList.size() + "...........");
        //   CustomAdapter adapter = new CustomAdapter(XMLPullParser.this, matchList);
        //     listview.setAdapter(adapter);
    }

    private ArrayList<Match> parseMovieaCommntry(XmlPullParser parser) throws Exception {

        Match movie = new Match();
        state state = new state();
        Tm tm = new Tm();
        Tme tme = new Tme();
        blgTm BLG = new blgTm();
        ArrayList<Match> moviesList = null;
        List<state> stateList = null;
        List<Tm> tmList = null;
        List<Tme> tmeList = null;
        Inngs inngs = new Inngs();
        ArrayList<Inngs> inngslist = null;

        //   Log.d("TAG", "parseMovie tag1111111111 " + parser.getName());

        int eventType = parser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name = null;

            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    moviesList = new ArrayList<Match>();
                    stateList = new ArrayList<state>();
                    tmList = new ArrayList<Tm>();
                    tmeList = new ArrayList<Tme>();
                    inngslist = new ArrayList<Inngs>();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (parser.getName().equals("match")) {
                        movie.id = parser.getAttributeValue(null, "id");
                        movie.type = parser.getAttributeValue(null, "type");
                        movie.srs = parser.getAttributeValue(null, "srs");
                        movie.mchDesc = parser.getAttributeValue(null, "mchDesc");
                        movie.mnum = parser.getAttributeValue(null, "mnum");
                        movie.vcity = parser.getAttributeValue(null, "vcity");
                        movie.vcountry = parser.getAttributeValue(null, "vcountry");
                        movie.grnd = parser.getAttributeValue(null, "grnd");
                        movie.inngCnt = parser.getAttributeValue(null, "inngCnt");
                        movie.datapath = parser.getAttributeValue(null, "datapath");
                    }
                    if (parser.getName().equals("state")) {
                        state.mchState = parser.getAttributeValue(null, "mchState");
                        state.status = parser.getAttributeValue(null, "status");
                        state.TW = parser.getAttributeValue(null, "TW");
                        state.decisn = parser.getAttributeValue(null, "decisn");
                        state.addnStatus = parser.getAttributeValue(null, "addnStatus");
                        state.splStatus = parser.getAttributeValue(null, "splStatus");
                    }
                    if (parser.getName().equals("Tm")) {
                        for (int i = 0; i < parser.getName().length(); i++) {
                            tm.id = parser.getAttributeValue(i);
                            tm.Name = parser.getAttributeValue(i);
                            tm.sName = parser.getAttributeValue(i);
                            tm.flag = parser.getAttributeValue(i);
                        }
                    }
                    if (parser.getName().equals("Tme")) {
                        tme.Dt = parser.getAttributeValue(null, "Dt");
                        tme.stTme = parser.getAttributeValue(null, "stTme");
                        tme.enddt = parser.getAttributeValue(null, "enddt");
                    }
                    if (parser.getName().equals("btTm")) {
                        int eventType2 = parser.next();
                        Log.e("eventType2", eventType2 + " ???????");
                        while (eventType2 != XmlResourceParser.END_DOCUMENT) {
                            String tagName2 = parser.getName();
                            Log.e("tagName2_main", tagName2 + " ???????");
                            switch (eventType2) {
                                case XmlResourceParser.START_TAG:
                                    if (tagName2.equalsIgnoreCase("Inngs")) {
                                        Log.i("Inngs_btTm", "Inngs: " + parser.getAttributeValue(null, "desc"));
                                        Log.i("r_btTm", "r: " + parser.getAttributeValue(null, "r"));
                                        Log.i("Decl_btTm", "Decl: " + parser.getAttributeValue(null, "Decl"));
                                        Log.i("FollowOn_btTm", "FollowOn: " + parser.getAttributeValue(null, "FollowOn"));
                                        Log.i("ovrs_btTm", "ovrs: " + parser.getAttributeValue(null, "ovrs"));
                                        Log.i("wkts_btTm", "wkts: " + parser.getAttributeValue(null, "wkts"));
                                        inngs.desc = parser.getAttributeValue(null, "desc");
                                        inngs.r = parser.getAttributeValue(null, "r");
                                        inngs.Decl = parser.getAttributeValue(null, "Decl");
                                        inngs.FollowOn = parser.getAttributeValue(null, "FollowOn");
                                        inngs.ovrs = parser.getAttributeValue(null, "ovrs");
                                        inngs.wkts = parser.getAttributeValue(null, "wkts");
                                    }
                                    break;
                                case XmlResourceParser.TEXT:
                                    break;
                                case XmlPullParser.END_TAG:
                                    inngslist.add(inngs);
                                    Log.e("desc.......",inngslist.size()+">>>>>>>>>>>>>");
                                    if(parser.getName().equals("Inngs")) {
                                        TextView desc = new TextView(XMLPullParser.this);
                                        desc.setText(inngslist.get(0).desc);
                                        TextView wkts = new TextView(XMLPullParser.this);
                                        wkts.setText("Wicket : "+parser.getAttributeValue(null, "wkts"));
                                        TextView r = new TextView(XMLPullParser.this);
                                        r.setText("Runs : "+parser.getAttributeValue(null, "r"));
                                        TextView Decl = new TextView(XMLPullParser.this);
                                        Decl.setText(" Decl : "+parser.getAttributeValue(null, "Decl"));
                                        TextView FollowOn = new TextView(XMLPullParser.this);
                                        FollowOn.setText("FollowOn :"+parser.getAttributeValue(null, "FollowOn"));
                                        TextView ovrs = new TextView(XMLPullParser.this);
                                        ovrs.setText("ovrs :"+parser.getAttributeValue(null, "ovrs"));
                                        ll1.addView(r);
                                        ll1.addView(Decl);
                                        ll1.addView(FollowOn);
                                        ll1.addView(ovrs);
                                        ll1.addView(wkts);
                                    }
                                    break;
                            }
                            eventType2 = parser.next();
                            Log.e("eventType2", eventType2 + "...eventType2");
                            switch (eventType2) {
                                case XmlResourceParser.START_TAG:
                                    String tagName3 = parser.getName();
                                    if (tagName3.equalsIgnoreCase("Inngs")) {
                                        Log.i("Inngs", "Inngs: " + parser.getAttributeValue(null, "desc"));
                                        Log.i("r", "r: " + parser.getAttributeValue(null, "r"));
                                        Log.i("Decl", "Decl: " + parser.getAttributeValue(null, "Decl"));
                                        Log.i("FollowOn", "FollowOn: " + parser.getAttributeValue(null, "FollowOn"));
                                        Log.i("ovrs", "ovrs: " + parser.getAttributeValue(null, "ovrs"));
                                        Log.i("wkts", "wkts: " + parser.getAttributeValue(null, "wkts"));
                                        inngs.desc = parser.getAttributeValue(null, "desc");
                                        inngs.r = parser.getAttributeValue(null, "r");
                                        inngs.Decl = parser.getAttributeValue(null, "Decl");
                                        inngs.FollowOn = parser.getAttributeValue(null, "FollowOn");
                                        inngs.ovrs = parser.getAttributeValue(null, "ovrs");
                                        inngs.wkts = parser.getAttributeValue(null, "wkts");
                                    }
                                    break;
                                case XmlResourceParser.TEXT:
                                    break;
                                case XmlPullParser.END_TAG:
                                    inngslist.add(inngs);
                                    if(parser.getName().equals("Inngs")) {
                                        TextView desc = new TextView(XMLPullParser.this);
                                        desc.setText(inngslist.get(0).getDesc());
                                        TextView wkts = new TextView(XMLPullParser.this);
                                        wkts.setText("Wicket : "+parser.getAttributeValue(null, "wkts"));
                                        TextView r = new TextView(XMLPullParser.this);
                                        r.setText("Runs : "+parser.getAttributeValue(null, "r"));
                                        TextView Decl = new TextView(XMLPullParser.this);
                                        Decl.setText(" Decl : "+parser.getAttributeValue(null, "Decl"));
                                        TextView FollowOn = new TextView(XMLPullParser.this);
                                        FollowOn.setText("FollowOn :"+parser.getAttributeValue(null, "FollowOn"));
                                        TextView ovrs = new TextView(XMLPullParser.this);
                                        ovrs.setText("ovrs :"+parser.getAttributeValue(null, "ovrs"));
                                        ll1.addView(r);
                                        ll1.addView(Decl);
                                        ll1.addView(FollowOn);
                                        ll1.addView(ovrs);
                                        ll1.addView(wkts);
                                    }
                                    break;
                            }
                            eventType2 = parser.next();
                            Log.e("parser.getName()", eventType2 + "...name");
                        }
                        /*if (parser.getName().equals("Inngs")) {
                            inngs.desc = parser.getAttributeValue(null, "desc");
                            inngs.r = parser.getAttributeValue(null, "r");
                            inngs.Decl = parser.getAttributeValue(null, "Decl");
                            inngs.FollowOn = parser.getAttributeValue(null, "FollowOn");
                            inngs.ovrs = parser.getAttributeValue(null, "ovrs");
                            inngs.wkts = parser.getAttributeValue(null, "wkts");
                            Log.e("desc...btTm", inngs.desc + " ???????");
                            Log.e("r...btTm", inngs.r + " ???????");
                            Log.e("Decl...btTm", inngs.Decl + " ???????");
                            Log.e("FollowOn...btTm", inngs.FollowOn + " ???????");
                            Log.e("ovrs...btTm", inngs.ovrs + " ???????");
                            Log.e("wkts...btTm", inngs.wkts + " ???????");
                       }*/

                    }


                   /* if(parser.getName().equalsIgnoreCase("blgTm") && parser.getName()!=null) {
                        BLG.id = parser.getAttributeValue(null, "id");
                        BLG.sName = parser.getAttributeValue(null, "sName");
                        Log.e("BLG.id", BLG.id + " ???????");
                        Log.e("BLG.sName", BLG.sName + " ???????");
                  //      name = parser.getName();

                     //   Log.e("eventType", parser.getAttributeValue(null,"Inngs").length() + " ???????");
                        int eventType2 = parser.next();
                        Log.e("eventType2", eventType2 + " ???????");
                        while (eventType2 != XmlResourceParser.END_DOCUMENT) {
                            String tagName2 = parser.getName();
                            Log.e("tagName2_main", tagName2 + " ???????");
                            switch (eventType2) {
                                case XmlResourceParser.START_TAG:
                                    if (tagName2.equalsIgnoreCase("Inngs")) {
                                        Log.i("Inngs", "Inngs: " + parser.getAttributeValue(null, "desc"));
                                        Log.i("r", "r: " + parser.getAttributeValue(null, "r"));
                                        Log.i("Decl", "Decl: " + parser.getAttributeValue(null, "Decl"));
                                        Log.i("FollowOn", "FollowOn: " + parser.getAttributeValue(null, "FollowOn"));
                                        Log.i("ovrs", "ovrs: " + parser.getAttributeValue(null, "ovrs"));
                                        Log.i("wkts", "wkts: " + parser.getAttributeValue(null, "wkts"));

                                    }
                                    break;
                                case XmlResourceParser.TEXT:
                                    break;
                                case XmlPullParser.END_TAG:
                                    break;
                            }
eventType2 = parser.next();

                        }*/
                        /*if (parser.getName().equals("Inngs")) {
                            inngs.desc = parser.getAttributeValue(null, "desc");
                            inngs.r = parser.getAttributeValue(null, "r");
                            inngs.Decl = parser.getAttributeValue(null, "Decl");
                            inngs.FollowOn = parser.getAttributeValue(null, "FollowOn");
                            inngs.ovrs = parser.getAttributeValue(null, "ovrs");
                            inngs.wkts = parser.getAttributeValue(null, "wkts");
                            Log.e("desc...blgTm", inngs.desc + " ???????");
                            Log.e("r...blgTm", inngs.r + " ???????");
                            Log.e("Decl...blgTm", inngs.Decl + " ???????");
                            Log.e("FollowOn...blgTm", inngs.FollowOn + " ???????");
                            Log.e("ovrs...blgTm", inngs.ovrs + " ???????");
                            Log.e("wkts...blgTm", inngs.wkts + " ???????");
                        }*/
                      /*
                    }*/
                    break;
                case XmlPullParser.END_TAG:
                    if (parser.getName().equals("match")) {
                        moviesList.add(movie);
                    }
                    if (parser.getName().equals("state")) {
                        stateList.add(state);
                        movie.setStateList((ArrayList<com.trivediinfoway.demo.state>) stateList);
                    }
                    if (parser.getName().equals("Tm")) {
                        tmList.add(tm);
                        movie.setTmList((ArrayList<com.trivediinfoway.demo.Tm>) tmList);
                    }
                    if (parser.getName().equals("Tme")) {
                        tmeList.add(tme);
                        movie.setTmeList((ArrayList<com.trivediinfoway.demo.Tme>) tmeList);
                    }

                    if (parser.getName().equals("blgTm")) {
                        inngslist.add(inngs);

                    }
                    if (parser.getName().equals("Inngs")) {
                        inngslist.add(inngs);
                    }
                    break;
            }

            eventType = parser.next();
            Log.e("eventType", eventType + ":::eventType");
        }
        return moviesList;
    }

    private ArrayList<Inngs> parseCommnetary(XmlPullParser parser) throws Exception {
        Inngs movie = new Inngs();
        state state = new state();
        Tm tm = new Tm();
        Tme tme = new Tme();
        ArrayList<Inngs> moviesList = null;
        List<state> stateList = null;
        List<Tm> tmList = null;
        List<Tme> tmeList = null;
        Log.d("TAG", "parseMovie tag1111111111 " + parser.getName());

        int eventType = parser.getEventType();
        Log.d("TAG", "parseMovie tag1111111111 " + eventType);
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name = null;

            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    moviesList = new ArrayList<Inngs>();
                   /* stateList = new ArrayList<state>();
                    tmList = new ArrayList<Tm>();
                    tmeList = new ArrayList<Tme>();*/
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    Log.e("name...", name + " ???????");
                    if (parser.getName().equals("Inngs")) {
                        movie.desc = parser.getAttributeValue(null, "desc");
                        movie.r = parser.getAttributeValue(null, "r");
                        movie.Decl = parser.getAttributeValue(null, "Decl");
                        movie.FollowOn = parser.getAttributeValue(null, "FollowOn");
                        movie.ovrs = parser.getAttributeValue(null, "wkts");
                        movie.wkts = parser.getAttributeValue(null, "vcity");
                        Log.e("desc...", movie.desc + " ???????");
                        Log.e("r...", movie.r + " ???????");
                        Log.e("Decl...", movie.Decl + " ???????");
                        Log.e("FollowOn...", movie.FollowOn + " ???????");
                        Log.e("ovrs...", movie.ovrs + " ???????");
                        Log.e("wkts...", movie.wkts + " ???????");
                    }
                    /*if (parser.getName().equals("state")) {
                        state.mchState = parser.getAttributeValue(null, "mchState");
                        state.status = parser.getAttributeValue(null, "status");
                        state.TW = parser.getAttributeValue(null, "TW");
                        state.decisn = parser.getAttributeValue(null, "decisn");
                        state.addnStatus = parser.getAttributeValue(null, "addnStatus");
                        state.splStatus = parser.getAttributeValue(null, "splStatus");
                        //     Log.e("mchState...",state.mchState+" ???????");
                    }
                    if (parser.getName().equals("Tm")) {
                        Log.e("nameeeeeee", parser.getName().length() + "...length");
                        for (int i = 0; i < parser.getName().length(); i++) {
                            //    tm.id = parser.getAttributeValue(null, "id");
                            tm.id = parser.getAttributeValue(i);
                            tm.Name = parser.getAttributeValue(i);
                            tm.sName = parser.getAttributeValue(i);
                            tm.flag = parser.getAttributeValue(i);
                            //  Log.e("id...", tm.id + " ???????");
                            Log.e("id...", tm.id + " new...???????");
                            Log.e("Name...", tm.Name + " new...???????");
                            Log.e("sName...", tm.sName + " new...???????");
                            Log.e("flag...", tm.flag + " new...???????");
                        }
                        //    tmList.add(tm);
                        //   movie.setTmList((ArrayList<com.trivediinfoway.demo.Tm>) tmList);
                    }
                    if (parser.getName().equals("Tme")) {
                        tme.Dt = parser.getAttributeValue(null, "Dt");
                        tme.stTme = parser.getAttributeValue(null, "stTme");
                        tme.enddt = parser.getAttributeValue(null, "enddt");
                        //    Log.e("tme...",tme.Dt+" ???????");
                    }*/
                    break;
                case XmlPullParser.END_TAG:
                    if (parser.getName().equals("Inngs")) {
                        moviesList.add(movie);
                    }
                    /*if (parser.getName().equals("state")) {
                        stateList.add(state);
                        movie.setStateList((ArrayList<com.trivediinfoway.demo.state>) stateList);
                        //    Log.e("State.......",movie.getStateList().size()+"sssssssss......");
                    }
                    if (parser.getName().equals("Tm")) {
                        tmList.add(tm);
                        movie.setTmList((ArrayList<com.trivediinfoway.demo.Tm>) tmList);
                        //   Log.e("Tm.......",movie.getTmList().size()+"sssssssss......");
                    }
                    if (parser.getName().equals("Tme")) {
                        tmeList.add(tme);
                        movie.setTmeList((ArrayList<com.trivediinfoway.demo.Tme>) tmeList);
                        //     Log.e("Tme.......",movie.getTmeList().size()+"sssssssss......");
                    }*/
                    break;
            }

            eventType = parser.next();
        }
        return moviesList;
    }

    private void parseFromUrl1() throws Exception {

        ArrayList<Match> matchList = null;

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(false);
        XmlPullParser xpp = factory.newPullParser();

        URL url = new URL(xmlUrl);
        URLConnection ucon = url.openConnection();
        InputStream is = ucon.getInputStream();

        xpp.setInput(is, null);

        matchList = parseMoviea(xpp);
        Log.e("matchList", matchList.size() + "...........");
        CustomAdapter adapter = new CustomAdapter(XMLPullParser.this, matchList);
        listview.setAdapter(adapter);

    }

    private ArrayList<Match> parseMoviea(XmlPullParser parser) throws Exception {

        Match movie = new Match();
        state state = new state();
        Tm tm = new Tm();
        Tme tme = new Tme();
        ArrayList<Match> moviesList = null;
        List<state> stateList = null;
        List<Tm> tmList = null;
        List<Tme> tmeList = null;
        Log.d("TAG", "parseMovie tag1111111111 " + parser.getName());

        int eventType = parser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name = null;

            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    moviesList = new ArrayList<Match>();
                    stateList = new ArrayList<state>();
                    tmList = new ArrayList<Tm>();
                    tmeList = new ArrayList<Tme>();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    Log.e("name...", name + " ???????");
                    if (parser.getName().equals("match")) {
                        movie.id = parser.getAttributeValue(null, "id");
                        movie.type = parser.getAttributeValue(null, "type");
                        movie.srs = parser.getAttributeValue(null, "srs");
                        movie.mchDesc = parser.getAttributeValue(null, "mchDesc");
                        movie.mnum = parser.getAttributeValue(null, "mnum");
                        movie.vcity = parser.getAttributeValue(null, "vcity");
                        movie.vcountry = parser.getAttributeValue(null, "vcountry");
                        movie.grnd = parser.getAttributeValue(null, "grnd");
                        movie.inngCnt = parser.getAttributeValue(null, "inngCnt");
                        movie.datapath = parser.getAttributeValue(null, "datapath");
                        Log.e("id...", movie.id + " ???????");
                        Log.e("type...", movie.type + " ???????");
                        Log.e("srs...", movie.srs + " ???????");
                        Log.e("mchDesc...", movie.mchDesc + " ???????");
                        Log.e("mnum...", movie.mnum + " ???????");
                        Log.e("vcity...", movie.vcity + " ???????");
                    }
                    if (parser.getName().equals("state")) {
                        state.mchState = parser.getAttributeValue(null, "mchState");
                        state.status = parser.getAttributeValue(null, "status");
                        state.TW = parser.getAttributeValue(null, "TW");
                        state.decisn = parser.getAttributeValue(null, "decisn");
                        state.addnStatus = parser.getAttributeValue(null, "addnStatus");
                        state.splStatus = parser.getAttributeValue(null, "splStatus");
                        //     Log.e("mchState...",state.mchState+" ???????");
                    }
                    if (parser.getName().equals("Tm")) {
                        Log.e("nameeeeeee", parser.getName().length() + "...length");
                        for (int i = 0; i < parser.getName().length(); i++) {
                            //    tm.id = parser.getAttributeValue(null, "id");
                            tm.id = parser.getAttributeValue(i);
                            tm.Name = parser.getAttributeValue(i);
                            tm.sName = parser.getAttributeValue(i);
                            tm.flag = parser.getAttributeValue(i);
                            //  Log.e("id...", tm.id + " ???????");
                            Log.e("id...", tm.id + " new...???????");
                            Log.e("Name...", tm.Name + " new...???????");
                            Log.e("sName...", tm.sName + " new...???????");
                            Log.e("flag...", tm.flag + " new...???????");
                        }
                        //    tmList.add(tm);
                        //   movie.setTmList((ArrayList<com.trivediinfoway.demo.Tm>) tmList);
                    }
                    if (parser.getName().equals("Tme")) {
                        tme.Dt = parser.getAttributeValue(null, "Dt");
                        tme.stTme = parser.getAttributeValue(null, "stTme");
                        tme.enddt = parser.getAttributeValue(null, "enddt");
                        //    Log.e("tme...",tme.Dt+" ???????");
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if (parser.getName().equals("match")) {
                        moviesList.add(movie);
                    }
                    if (parser.getName().equals("state")) {
                        stateList.add(state);
                        movie.setStateList((ArrayList<com.trivediinfoway.demo.state>) stateList);
                        //    Log.e("State.......",movie.getStateList().size()+"sssssssss......");
                    }
                    if (parser.getName().equals("Tm")) {
                        tmList.add(tm);
                        movie.setTmList((ArrayList<com.trivediinfoway.demo.Tm>) tmList);
                        //   Log.e("Tm.......",movie.getTmList().size()+"sssssssss......");
                    }
                    if (parser.getName().equals("Tme")) {
                        tmeList.add(tme);
                        movie.setTmeList((ArrayList<com.trivediinfoway.demo.Tme>) tmeList);
                        //     Log.e("Tme.......",movie.getTmeList().size()+"sssssssss......");
                    }
                    break;
            }

            eventType = parser.next();
        }
        return moviesList;
    }

    private com.trivediinfoway.demo.Image parseImage(XmlPullParser parser) throws XmlPullParserException, IOException {

        com.trivediinfoway.demo.Image image = new com.trivediinfoway.demo.Image();
        Log.d("TAG", "parseImage tag " + parser.getName());

        while (parser.nextTag() == XmlPullParser.START_TAG) {

            if (parser.getName().equals("image")) {
                image.type = parser.getAttributeValue(null, "type");
                image.url = parser.getAttributeValue(null, "url");
                image.size = parser.getAttributeValue(null, "size");
                image.width = Integer.parseInt(parser.getAttributeValue(null, "width"));
                image.height = Integer.parseInt(parser.getAttributeValue(null, "height"));
            }
            parser.next();

        }

        return image;


    }

    class XMLPullParserAsync extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {
            try {
                parseFromUrl1();
            } catch (Exception e) {
                Log.e("TAG", "Error while parsing", e);
            }
            return 0;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);

        }
    }
}
