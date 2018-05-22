package com.trivediinfoway.demo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListviewScrollListenerActivity extends AppCompatActivity {

    ListView listView;
    String url = "http://www.visitmysmokies.com/vms-api/getattractions?page="+1;
    ArrayList<String> arraylist_dataclass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_scroll_listener);

        listView = (ListView)findViewById(R.id.listView);
        new LoadAttractionData(ListviewScrollListenerActivity.this).execute(url);

    }
    private class LoadAttractionData extends AsyncTask<String, Void, ArrayList<String>> {
        String attraction_title = "";
        String attraction_address = "";
        String attraction_photos = "";
        private View footer;
        private Activity activity;
        int total_rows;
        String attraction_slug;
        String attraction_id;
        String allow_ticket_sales;
        String reserve_api_id;

        private LoadAttractionData(Activity activity) {
            this.activity = activity;
          //  footer = activity.getLayoutInflater().inflate(R.layout.loadimagedata, null);
        }

        @Override
        protected void onPreExecute() {
       //     pd = ProgressDialog.show(ActivityAttractions.this, "", "Loading..", true);
            super.onPreExecute();
        }

        @Override
        protected ArrayList<String> doInBackground(String... params) {
            try {
                arraylist_dataclass = new ArrayList<String>();
                String authData = "Basic " + Base64.encodeToString(("imeg" + ":" + "?Mnb098!?").getBytes(), Base64.NO_WRAP);
                HttpClient httpclient = new DefaultHttpClient();
                HttpGet httpget = new HttpGet(params[0]);

                HttpParams httpParameters = httpget.getParams();

                httpget.setHeader("Authorization", authData);

                int timeoutConnection = 10000;
                HttpConnectionParams.setConnectionTimeout(httpParameters,
                        timeoutConnection);

                int timeoutSocket = 10000;
                HttpConnectionParams
                        .setSoTimeout(httpParameters, timeoutSocket);
                HttpResponse response = null;
                try {
                    response = httpclient.execute(httpget);
                    HttpEntity entity = response.getEntity();

                    if (entity != null) {
                        String s = EntityUtils.toString(entity);

                        Log.e(": API response ", s + "");
                        JSONObject jsonobject = new JSONObject(s);
                        total_rows = jsonobject.getInt("total_rows");
                        String property = jsonobject.getString("attractions");
                        JSONArray jsonArray_property = new JSONArray(property);

                        for (int i = 0; i < jsonArray_property.length(); i++) {

                            jsonobject = jsonArray_property.getJSONObject(i);

                            attraction_id = jsonobject.getString("attraction_id");
                            attraction_title = jsonobject.getString("attraction_title");
                            attraction_address = jsonobject.getString("attraction_address");
                            attraction_photos = jsonobject.getString("attraction_photos");

                            String str = attraction_photos;
                            List<String> attraction_photos_list = Arrays.asList(str.split(","));
                            attraction_photos = attraction_photos_list.get(0);

                            attraction_slug = jsonobject.getString("attraction_slug");
                            allow_ticket_sales = jsonobject.getString("allow_ticket_sales");
                            reserve_api_id = jsonobject.getString("reserve_api_id");

                            arraylist_dataclass.add(attraction_title);
                        }
                    }

                } catch (Exception e) {
                    // Auto-generated catch block
                    Log.e(": Error...", e.getMessage() + "");
                    e.printStackTrace();
                } finally {
                }

            } catch (Exception e) {
                e.printStackTrace();
                Log.e(" :In Catch block...", e.getMessage() + "");
                return null;
            }
            return arraylist_dataclass;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            super.onPostExecute(result);

            if (result != null) {
                try {
                    Log.e(" :NAME>>>>...", result + "");
                   ArrayAdapter adapter = new ArrayAdapter(ListviewScrollListenerActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,result);
                    listView.setAdapter(adapter);

                    int reminder = total_rows % 10;
                    final int addition_row;
                    if (reminder != 0) {
                        addition_row = 1;
                    } else {
                        addition_row = 0;
                    }
                } catch (Exception e) {
                    Log.e(" :Post method...", e.getMessage() + "");
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(ListviewScrollListenerActivity.this, "No internet connection or Some error occured.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
