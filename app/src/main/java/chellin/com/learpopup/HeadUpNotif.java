package chellin.com.learpopup;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

/**
 * Created by chellin on 18/11/16.
 */

public class HeadUpNotif extends Activity {
    Button btnClose;
    Button btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = (Button) findViewById(R.id.button1);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                sendNotification();
            }
        });

    }

    private void sendNotification() {
        System.out.println("masuk sendNotif");
        //set intents and pending intents to call service on click of "dismiss" action button of notification
        Intent dismissIntent = new Intent(this, HeadUpNotif.class);
//        dismissIntent.setAction(ACTION_DISMISS);
        PendingIntent piDismiss = PendingIntent.getService(this, 0, dismissIntent, 0);

        //set intents and pending intents to call service on click of "snooze" action button of notification
        Intent snoozeIntent = new Intent(this, HeadUpNotif.class);
//        snoozeIntent.setAction(ACTION_SNOOZE);
        PendingIntent piSnooze = PendingIntent.getService(this, 0, snoozeIntent, 0);

        //build notification
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setContentTitle("Ping Notification")
                        .setContentText("Tomorrow will be your birthday.")
                        .setDefaults(Notification.DEFAULT_ALL) // must requires VIBRATE permission
                        .setPriority(NotificationCompat.PRIORITY_HIGH) //must give priority to High, Max which will considered as heads-up notification
                        .addAction(0, "dismiss", piDismiss)
                        .addAction(0, "snooze", piSnooze);





// Gets an instance of the NotificationManager service
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//to post your notification to the notification bar with a id. If a notification with same id already exists, it will get replaced with updated information.
        notificationManager.notify(0, builder.build());
    }
}
