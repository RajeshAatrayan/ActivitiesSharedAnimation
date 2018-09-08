package com.ibrickedlabs.activitiessharedanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private CircleImageView circleImageView;
    private TextView nameView;
    private  TextView descView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=(RelativeLayout)findViewById(R.id.upperRel);
        circleImageView=(CircleImageView)findViewById(R.id.rajeshPic);
        nameView=(TextView)findViewById(R.id.name);
        descView=(TextView)findViewById(R.id.loremIps);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SharedActivity.class);
                /**
                 *Since we have more views to get the transition we are making an array of those pair and we pass it in the ActivityOptions in order to get animated
                 *
                 * and we must give the same names for the views in the activitymain.xml and shareactivity.xml bcz they themselves needs to get positioned so
                 */

                Pair[] pair =new Pair[3];
                pair[0]=new Pair(circleImageView,"imageTransition");
                pair[1]=new Pair(nameView,"nameTransition");
                pair[2]=new Pair(descView,"descTransition");
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pair);
                startActivity(intent,options.toBundle());
            }
        });
    }
}
