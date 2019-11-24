package comandydevo.wixsite.seemantshekhar43.volleyone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    /* first of all go to build.gradle(Module: app) and
     paste" compile 'com.android.volley:volley:1.0.0" in the dependencies.*/

    /* go to androidManifest and
     paste" <uses-permission android:name="android.permission.INTERNET"/>" */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //introduce a string that is the url  of the very site
        final String url = "http://www.hiteshchoudhary.com/";

        // find the button
        Button button = (Button) findViewById(R.id.button);

        // set the on click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling Request queue
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

                /*making a string request (it needs 4 parameters: method , url,
                response listener,error listener*/
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                            // lets watch the page in logcat
                                Log.i("Page","Your page is " + response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                // lets watch the error if any in logcat
                                Log.i("ERROR","ERROR");
                            }
                        });

                // lets run it
                requestQueue.add(stringRequest);
            }


        });

    }
}
