package com.oocl.manlimeng.androidstudyproject.UIActivity.SaveStudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.oocl.manlimeng.androidstudyproject.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SaveStudyFileActivity extends Activity {

    final String File_Name="crazyit.bin";
    EditText editText1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_study_file);
        editText1= (EditText) findViewById(R.id.SaveFileET1);
        editText2= (EditText) findViewById(R.id.SaveFileET2);
    }



    public  void WriteFunction(View view)
    {
         write(editText1.getText().toString());
         editText1.setText("");
         System.out.println(getFilesDir().getAbsolutePath());
    }
    public void ReadFunction(View view)
    {
        editText2.setText(read());
    }

    private String read()
    {
        try {
            FileInputStream fis=openFileInput(File_Name);
            byte[] buff=new byte[1024];
            int hasRead=0;
            StringBuilder sb=new StringBuilder("");
            while((hasRead=fis.read(buff))>0)
            {
                sb.append(new String(buff,0,hasRead));
            }
            fis.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    private void write(String content)
    {
        try {
            FileOutputStream fos=openFileOutput(File_Name,MODE_APPEND);
            PrintStream ps=new PrintStream(fos);
            ps.println(content);
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save_study_file, menu);
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
