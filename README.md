# RunAfterBoot

Learn how to build Android Apps that run automatically when device booting is completed (Android)

## Getting Started

These app will automatically run when phone boot process is completed, it will run without clicked on its app icon. To allow this action we need to add some permition in android manifest and create some class BootReceiver to receive first command after boot process and create intent to another class. 

### Code

add this permission to your AndroidManifest.xml

```
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
```
the create class named BootReceiver and add this  
```
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
```

dont forget to set BootReceiver class intent filter in android manifest
```
<receiver android:name=".BootReceiver">
    <intent-filter >
        <action android:name="android.intent.action.BOOT_COMPLETED"/>
    </intent-filter>
</receiver>
```

## Built With

* IDE - Android Studio 2.1.3
* Operating System - Ubuntu

## Authors

* **Marchellin Antonia**

## Screenshot

![alt tag](https://cloud.githubusercontent.com/assets/12492522/18807712/c651f348-8278-11e6-8496-a00a3e864b45.png)

