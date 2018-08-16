package ant_user.com.app.verticalprogressbar

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var progressStatus = 0
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the widgets reference from XML layout
        val rl = findViewById<View>(R.id.rl) as RelativeLayout
        val btn = findViewById<View>(R.id.btn) as Button
        val tv = findViewById<View>(R.id.tv) as TextView
        val pb = findViewById<View>(R.id.pb) as ProgressBar

        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                // Set the progress status zero on each button click
                progressStatus = 0

                // Start the lengthy operation in a background thread
                Thread(Runnable {
                    while (progressStatus < 100) {
                        // Update the progress status
                        progressStatus += 1

                        // Try to sleep the thread for 20 milliseconds
                        try {
                            Thread.sleep(20)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }

                        // Update the progress bar
                        handler.post(Runnable {
                            pb.progress = progressStatus
                            // Show the progress on TextView
                            tv.text = progressStatus.toString() + ""
                            // If task execution completed
                            if (progressStatus == 100) {
                                // Set a message of completion
                                tv.text = "Operation completed."
                            }
                        })
                    }
                }).start() // Start the operation
            }
        })
    }
}
