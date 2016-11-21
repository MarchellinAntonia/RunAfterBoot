# RunAfterBoot

Learn how to build Android Apps that run automatically when device booting is completed (Android)

## Getting Started

These app will automatically run when phone boot process is completed, it will run without clicked on its app icon. To allow this action we need to add some permission in android manifest and create some class BootReceiver to receive first command after boot process and create intent to another class. 

### Code

add this permission to your AndroidManifest.xml

```
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
```
then create class named BootReceiver and add this  
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
* after boot device will show android home screen for a while <br />
![alt tag](https://cloud.githubusercontent.com/assets/12492522/20469490/c8fd0ac4-afd2-11e6-8d06-207cf4c5f4e8.png)
<br />
* and then this app will run automatically (after boot completed it takes some time to run this app, its depend on device processor) <br />
![alt tag](https://cloud.githubusercontent.com/assets/12492522/20469491/ceb0b150-afd2-11e6-8066-d59d0578f0a4.png)

