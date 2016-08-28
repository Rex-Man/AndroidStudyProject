package com.oocl.manlimeng.androidstudyproject.servicestudy;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

public class BindServiceActivity extends Activity {

    MyBindService myBindService;
    MyBindService.MyBinder myBinder;
    TextView service_showcity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        service_showcity= (TextView) findViewById(R.id.service_showcity);
    }

    private ServiceConnection mConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder=(MyBindService.MyBinder)service;
            myBindService=((MyBindService.MyBinder) service).getService();
            System.out.println("==================onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("==================onServiceDisconnected");
        }
    };




    public void StartBindService(View view)
    {
        Intent intent = new Intent(this, MyBindService.class);
        intent.putExtra("city", "ZHU HAI");
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);

    }
    public void testFunction(View view)
    {
        myBinder.showMessage(3);

        service_showcity.setText(myBindService.testFunctionInService()+" count: "+myBinder.getCount());
    }
    public void StopBindService(View view)
    {
        unbindService(mConnection);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bind, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
