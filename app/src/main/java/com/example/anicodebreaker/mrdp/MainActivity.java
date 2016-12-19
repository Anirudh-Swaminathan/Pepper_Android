package com.example.anicodebreaker.mrdp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anicodebreaker.mrdp.model.RoboCall;
import com.example.anicodebreaker.mrdp.rest.ApiClient;
import com.example.anicodebreaker.mrdp.rest.ApiInterface;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final int SPEECH_REQUEST_CODE = 0;
    private TextView speechInput;
    private TextView apiOutput;

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speechInput = (TextView) findViewById(R.id.speechIn);
        apiOutput = (TextView) findViewById(R.id.speechOut);

        apiService = ApiClient.getClient().create(ApiInterface.class);

        ((Button) findViewById(R.id.speechBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySpeechRecognizer();
            }
        });
    }

    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        // Start the activity, the intent will be populated with the speech text
        try {
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(MainActivity.this, "Sorry, But no speech today!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            // Do something with spokenText
            speechInput.setText(spokenText);

            String encodedQuery = "";

            try {
                encodedQuery = URLEncoder.encode(spokenText, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            //Send the spoken text to the api
            String sessId = randomString(24);
            Map<String, String> query = new HashMap<>();
            query.put("v", "20150910");
            query.put("lang", "en");
            query.put("query", encodedQuery);
            query.put("sessionId", sessId);

            Call<RoboCall> call = apiService.callRobot(query);

            call.enqueue(new Callback<RoboCall>() {
                @Override
                public void onResponse(Call<RoboCall> call, Response<RoboCall> response) {
                    if (response.body().getStatus().getCode() == 200) {
                        String action = response.body().getResult().getAction();
                        if (action.equals("input.unknown")) {
                            Toast.makeText(MainActivity.this, "Could not resolve the query", Toast.LENGTH_SHORT).show();
                            apiOutput.setText("");
                        } else {
                            Toast.makeText(MainActivity.this, "Action to be taken is " + action, Toast.LENGTH_SHORT).show();
                            String speechOut = response.body().getResult().getFulfillment().getSpeech();
                            apiOutput.setText(speechOut);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Error is: " + response.body().getStatus().getErrorType(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<RoboCall> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "In Error.Message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
