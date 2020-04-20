package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ArtistProfile extends AppCompatActivity {
    private String [] adamSongs={"sugar","maps"};
    private ImageView artistimage;
    private TextView artistname;
    private LinearLayout artistsongsLinearLayout;
    String artistName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_profile);
        artistname=(TextView) findViewById(R.id.artistnametextView);
        artistimage=(ImageView) findViewById(R.id.artistimageView);
        artistsongsLinearLayout=(LinearLayout) findViewById(R.id.artistsongsLinearLayout);
        whichArtist();
    }
    public void whichArtist()
    {
        System.out.println("HIBYE");
        artistName=getIntent().getStringExtra("artistName");
        if(artistName==null)
            return;
        if(artistName.equals("  Adam Levine"))
        {
            Drawable img=getResources().getDrawable(R.drawable.adamfull);
            img.setBounds(0,0,1040,520);
            artistimage.setImageDrawable(img);
            artistname.setText(artistName);
            fillartistsongs(adamSongs);
        }
    }
    public void fillartistsongs(String [] songs)
    {
        LinearLayout.LayoutParams k=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        k.setMargins(0,30,0,0);
        for(int i=0;i<songs.length;i++)
        {
            Button button = new Button(this);

            Drawable img=null;
            if(songs[i].equals("sugar"))
            {
                button.setText("  Sugar");
                img=getResources().getDrawable(R.drawable.sugar);
            }
            else if(songs[i].equals("maps"))
            {
                button.setText("  Maps");
                img=getResources().getDrawable(R.drawable.maps);
            }

            if(img==null)
                return;
            img.setBounds(0, 0, 200, 200);
            button.setTextSize(22);
            button.setPadding(40, 0, 0, 0);
            button.setAllCaps(false);

            button.setBackgroundColor(Color.BLACK);
            button.setCompoundDrawables(img, null, null, null);
            button.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opensongDetails(v);
                }
            });
            artistsongsLinearLayout.addView(button,k);
        }
    }
    public void opensongDetails(View view)
    {
        Button btn=(Button) view;
        String songName=btn.getText().toString();
        Intent intent=new Intent(this,SongDetails.class);
        intent.putExtra("songName",songName);
        startActivity(intent);

    }
}
