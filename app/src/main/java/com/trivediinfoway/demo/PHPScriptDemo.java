package com.trivediinfoway.demo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PHPScriptDemo extends AppCompatActivity {

    EditText edtfname,edtlname,edtmarks;
    Button btnadd;
    String fname="",lname="",marks="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phpscript_demo);

        edtfname = (EditText)findViewById(R.id.edtfname);
        edtlname = (EditText)findViewById(R.id.edtlname);
        edtmarks = (EditText)findViewById(R.id.edtmarks);

        btnadd = (Button)findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname = edtfname.getText().toString();
                lname = edtlname.getText().toString();
                marks = edtmarks.getText().toString();

                InsertData(fname,lname,marks);
            }
        });
    }
    public void InsertData(final String fname, final String lname,final String marks){

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String Holderfname = fname ;
                String Holderlname = lname ;
                String Holdermarks = marks;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("fname", Holderfname));
                nameValuePairs.add(new BasicNameValuePair("lname", Holderlname));
                nameValuePairs.add(new BasicNameValuePair("marks", Holdermarks));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost("http://192.168.0.19/api/student.php");

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Inserted Successfully";
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

                Toast.makeText(PHPScriptDemo.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }
        }
        new SendPostReqAsyncTask().execute(fname,lname,marks);
    }
}
