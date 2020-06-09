package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;


public class Logout extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    //////////////////////////////////////upload image
    private CircleImageView ProfileImage;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;
    Bitmap bitmap;
    boolean firsttime = false;
    /////////////////////////////////////////
    public void logoutclicked(View view) {
        MediaPlayer mediaPlayer=MySingleton.getInstance();
        if(mediaPlayer!=null)
            mediaPlayer.pause();
        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(intent);
        sharedPreferences = getSharedPreferences("spotify", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("firsttime", false);
        editor.commit();

    }
    public void anotheraccclicked(View view) {

        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
        sharedPreferences = getSharedPreferences("spotify", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("firsttime", false);
        editor.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        if (firsttime) {
            sharedPreferences = getSharedPreferences("spotify", MODE_PRIVATE);
            String img = sharedPreferences.getString("profilepicture", "Data not found");
            imageUri = Uri.parse(img);
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                ProfileImage = (CircleImageView) findViewById(R.id.profile_image);
                ProfileImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ProfileImage = (CircleImageView) findViewById(R.id.profile_image);
        ProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery, "Sellect Picture"), PICK_IMAGE);
            }
        });
    }
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
                imageUri = data.getData();
                sharedPreferences = getSharedPreferences("spotify", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("profilepicture", imageUri.toString());
                editor.putBoolean("test", true);
                editor.commit();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                    ProfileImage.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                TextView news=(TextView)findViewById(R.id.news);
                news.setVisibility(View.INVISIBLE);
            }
        }
    }






