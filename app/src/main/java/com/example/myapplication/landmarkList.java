package com.example.myapplication;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class landmarkList extends AppCompatActivity {
    private Button getApiButton;
    private ImageView imageView;
    private EditText editTextNumber;
    private EditText editTextMultiLine;
    Call<Landmark> landmarkCall;
    Call<List<Landmark>> landmarklistCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landmark_list);

        getApiButton = (Button) findViewById(R.id.getApiButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        editTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        editTextNumber = findViewById(R.id.editTextNumber);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        LandmarkAPI landmarkAPI = RetrofitClient.getLandmarkAPI();

        getApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TAG = "랜드마크 API 실행";
                landmarkCall = landmarkAPI.getLandmarkInfo(String.valueOf(editTextNumber.getText()));
                //landmarklistCall = landmarkAPI.getLandmarkList();
                landmarkCall.clone().enqueue(new Callback<Landmark>() {
                    @Override
                    public void onResponse(Call<Landmark> call, Response<Landmark> response) {
                        if (response.isSuccessful()) {
                            editTextNumber.setText(response.body().getName());
                            String imageUrl = response.body().getPicture();
                            editTextMultiLine.setText(response.body().getPicture());
                            Glide.with(view)
                                    .load(imageUrl)
                                    .circleCrop()
                                    .into(imageView);
                            Log.d(TAG, "정상출력");
                        }
                    }

                    @Override
                    public void onFailure(Call<Landmark> call, Throwable t) {
                        Log.e("retrofit 연동", "실패");
                        t.printStackTrace();
                    }
                });
            }
        });

    }
}