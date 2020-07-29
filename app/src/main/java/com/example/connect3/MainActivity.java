package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int active=1;
    int state[]={2,2,2,2,2,2,2,2,2};
    int winpos[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view){
        ImageView counter=(ImageView) view;
        counter.setTranslationY(-1000f);
        int tagcounter=Integer.parseInt(view.getTag().toString());
        if(state[tagcounter]==2) {
            if (active == 1) {
                counter.setImageResource(R.drawable.yellow);
                state[tagcounter]=1;
                active = 0;
            } else {
                counter.setImageResource(R.drawable.red);
                state[tagcounter]=0;
                active = 1;
            }
            counter.animate().rotation(360).translationYBy(1000f).setDuration(300);
        }
        for(int [] wp:winpos){
            if(state[wp[0]]==state[wp[1]]&&state[wp[1]]==state[wp[2]]&&state[wp[1]]!=2){
                Toast toast = Toast.makeText(getApplicationContext(),"Victory\n",
                        Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
