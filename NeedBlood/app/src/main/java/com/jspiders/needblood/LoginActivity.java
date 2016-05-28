package com.jspiders.needblood;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;


/**
 * Created by mhs on 4/29/2016.
 */
public class LoginActivity extends AppCompatActivity {


    @Bind(R.id.buttonlogin)
    protected Button loginbutton;

    @Bind(R.id.buttonregister)
    protected Button registerbutton;

    @Bind(R.id.editTextusername)
    protected EditText emaileditext;

    @Bind(R.id.editTextpassword)
    protected EditText passwordedittext;

    boolean status;

    String email, password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login_page);
        ButterKnife.bind(this);


        if (!isNetworkAvailable()) {
            new AlertDialog.Builder(LoginActivity.this)


                    .setTitle("NO Network Avilable")
                    .setMessage("Please enable Internet and GPS  and try again")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setIcon(R.drawable.no)
                    .setCancelable(false)
                    .show();
        }


    }

    @OnClick(R.id.buttonlogin)
    public void login() {
        email = emaileditext.getText().toString();
        password = passwordedittext.getText().toString();

        if (email.length() == 0 || password.length() == 0) {
            emaileditext.setError("enter username");
            passwordedittext.setError("enter password");
        } else {

            String loginurl1 = Uri.parse("http://temple-appv3.rhcloud.com/templeApp/user/login/")
                    .buildUpon()
                    .appendQueryParameter("email", email).appendQueryParameter("password", password)
                    .build().toString();
            Log.d("SATUSCODE", loginurl1);

            AsyncHttpClient client = new AsyncHttpClient();
            client.post(loginurl1, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    Log.d("SATUSCODE", "" + statusCode);
                    if (statusCode == 200) {
                   /* status = true;
                    Intent intent = new Intent(LoginActivity.this, MapsActivity.class);
                    startActivity(intent);*/
                        Log.d("DEBUG", "onSuccess: " + "Login OK");

                    } else {

                        Log.d("SATUSCODE", "status = false; ");
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    status = false;
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Invalid username or password")
                            .setCancelable(true)
                            .setMessage("Please enter valid username and password")
                            .setIcon(R.drawable.no)
                            .show();
                }
            });

            Log.d("SATUSCODE", "finished userlogintask " + status);
        }

    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}





