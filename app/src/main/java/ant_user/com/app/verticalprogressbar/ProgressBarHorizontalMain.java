package ant_user.com.app.verticalprogressbar;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import ant_user.com.app.verticalprogressbar.adapter.MyPagerAdapter;

public class ProgressBarHorizontalMain extends FragmentActivity {

    private int progressStatus = 0;
    private Handler handler = new Handler();
    Runnable runnable ;

    ViewPager pager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        final ProgressBar pb = findViewById(R.id.pb);
        pager = findViewById(R.id.viewPager);
        final ProgressBar vprogressbar = findViewById(R.id.vprogressbar);

//        Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
        runnable = new Runnable() {
            @Override
            public void run() {
                progressStatus++;
//              pb.setProgress(progressStatus);
                vprogressbar.setProgress(progressStatus);
                if (progressStatus<101){
                    handler.postDelayed(runnable,20);
                }
                else {
                    handler.removeCallbacks(runnable);
                }
            }
        };

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressStatus = 0;
                handler.postDelayed(runnable,20);
//                Toast.makeText(ProgressBarHorizontalMain.this, "DONE", Toast.LENGTH_SHORT).show();
//                Toast.makeText(ProgressBarHorizontalMain.this, "DONE", Toast.LENGTH_SHORT).show();
            }
        });
        setviewpager();
    }

    private void setviewpager() {
        pager.setOffscreenPageLimit(0);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), 2,this));
    }
}
