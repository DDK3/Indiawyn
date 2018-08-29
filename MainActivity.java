package dipesh.com.indiawyn;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
        public int i = 0;
        public int j = 0;
        public int index = 0;
    LayoutInflater inflater;
        TextView tvnumber;
        CountDownTimer timer;
    private LinearLayout lvnumber;
    private RelativeLayout reltop;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            initialization();

            spinningNumber();

        }

    private void initialization() {
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        lvnumber = (LinearLayout) findViewById(R.id.lvnumber);
        reltop = (RelativeLayout) findViewById(R.id.reltop);
    }

    private void spinningNumber() {
        for (int i = 0; i < 5; i++) {
            final View myView_inflat = inflater.inflate(R.layout.row_rotate, null);
            tvnumber = (TextView) myView_inflat.findViewById(R.id.tvnumber);
            lvnumber.addView(tvnumber);
        }


        timer = new CountDownTimer(110, 110) {
            @Override
            public void onTick(long millisUntilFinished) {

                if (i != 5) {
                    View view = lvnumber.getChildAt(index);
                    if (view != null) {
                        tvnumber = (TextView) view.findViewById(R.id.tvnumber);
                        if (i == 0) {
                            index = i + 1;
                            i++;
                            tvnumber.setText(R.string.static_value);

                        } else if (j == 9) {
                            index = i + 1;
                            j = 0;
                            i++;
                        } else {
                            j++;
                            tvnumber.setText("" + j);
                        }


                    }
                }
                if (i == 5) {
                    if (timer != null) {
                        timer.cancel();
                    }

                    Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_up);
                    animZoomOut.setFillAfter(true);
                    reltop.startAnimation(animZoomOut);

                }

            }

            @Override
            public void onFinish() {
                timer.start();

            }
        }.start();
    }
}
