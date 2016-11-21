package chellin.com.learpopup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by chellin on 18/11/16.
 */

public class BootReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Intent myIntent = new Intent(context, MainActivity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(myIntent);
    }

}
