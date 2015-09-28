package dreamtechprojects.android.toggleservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by v-manjra on 9/27/2015.
 */
public class ActivityStartService extends Activity {

    ToggleButton toggleButton;
    Intent intentStartService;
    Button statusButton, serviceCreateButton;
    MyService myServiceInstance  = new MyService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        // Instantiate the MyService class


        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        intentStartService = new Intent(this, MyService.class);
        statusButton = (Button) findViewById(R.id.statusButton);
        serviceCreateButton = (Button) findViewById(R.id.serviceCreateButton);


        serviceCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myServiceInstance.isServiceCreated()) Toast.makeText(getApplicationContext(),"Service is Already Created!!", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(),"Service is NOT Created!!", Toast.LENGTH_SHORT).show();

            }
        });



        // Event handling when the toggle button is clicked.
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Start/Stop the service when the toggle button is ON/OFF respectively. Also toasting appropriate messages to keep the user informed.
                if (toggleButton.isChecked()) {
                    Toast.makeText(getApplicationContext(),"Starting Service...",Toast.LENGTH_SHORT).show();
                    startService(intentStartService);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Stopping Service...",Toast.LENGTH_SHORT).show();
                    stopService(intentStartService);
                }

            }
        });


        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(myServiceInstance.getServiceState()) Toast.makeText(getApplicationContext(),"Service is STARTED!!", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(),"Service is STOPPED!!", Toast.LENGTH_SHORT).show();
            }
        });



    } // End of onCreate method


}
