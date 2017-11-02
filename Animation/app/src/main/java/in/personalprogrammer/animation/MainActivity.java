package in.personalprogrammer.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mohit on 31/10/2017.
 */

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    TextView txtMessage;
    Button btnStart;
    Animation animFadein, animFadeout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessage= (TextView) findViewById(R.id.txtMessage);
        btnStart= (Button) findViewById(R.id.btnstart);

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animFadeout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);

        animFadein.setAnimationListener(this);

        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                txtMessage.setVisibility(View.VISIBLE);
                txtMessage.startAnimation(animFadein);
            }
        });
    }

    @Override
     public void onAnimationEnd(Animation animation)
    {
        if (animation == animFadein) {
            Toast.makeText(getApplicationContext(), "Animator Stop",
                    Toast.LENGTH_SHORT).show();
            txtMessage.startAnimation(animFadeout);
            animFadeout.start();
        }


    }

    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }
}
