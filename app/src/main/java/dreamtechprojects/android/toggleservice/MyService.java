package dreamtechprojects.android.toggleservice;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by v-manjra on 9/27/2015.
 */
public class MyService extends Service {

    private static MyService myServiceInstance; // Get the instance of the service
    private static boolean serviceState; // Tracks if the service is active or stopped

    // write a constructor to name the thread


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        serviceState = true;
        Toast.makeText(getApplicationContext(),"Service says HI", Toast.LENGTH_SHORT).show();
        return START_STICKY;

    }


    public boolean getServiceState(){
        return serviceState;
    }

    public boolean isServiceCreated(){
        return myServiceInstance != null;
    }

    @Override
    public void onCreate() {

        myServiceInstance = this;
    }

    @Override
    public void onDestroy() {

        myServiceInstance = null;
        serviceState = false;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
