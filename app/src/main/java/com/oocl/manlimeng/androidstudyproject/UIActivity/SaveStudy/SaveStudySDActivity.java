package com.oocl.manlimeng.androidstudyproject.UIActivity.SaveStudy;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.oocl.manlimeng.androidstudyproject.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class SaveStudySDActivity extends Activity {

    final String File_Name="/SDtest1.bin";
    EditText editText1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_study_sd);
        editText1= (EditText) findViewById(R.id.SaveSDET1);
        editText2= (EditText) findViewById(R.id.SaveSDET2);
    }

    public void WriteFunction(View view)
    {
        write(editText1.getText().toString());
        editText1.setText("");
    }

    public void ReadFunction(View view)
    {
        editText2.setText(read());
    }
    private void write(String content)
    {
        try {
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                //获取SD卡的目录
                File sdCardDir = Environment.getExternalStorageDirectory();
                File targetFileFolder=new File(sdCardDir.getCanonicalPath() + "/AndroidStudy");

                File targetFile = new File(targetFileFolder.getCanonicalPath() + File_Name);
                if(!targetFile.exists())
                {
                    targetFileFolder.mkdirs();
                }
                //以指定文件创建RandomAccessFile对象
                RandomAccessFile raf = new RandomAccessFile(targetFile, "rw");
                //将文件记录指针移动到最后
                raf.seek(targetFile.length());
                //输出文件内容
                raf.write(content.getBytes());
                raf.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String read()
    {
        try {
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                //获得SD卡对应的存储目录
                File sdCardDir = Environment.getExternalStorageDirectory();
                //获取指定文件对应的输入流
                FileInputStream fis = new FileInputStream(sdCardDir.getCanonicalPath()+ "/AndroidStudy" + File_Name);
                //将指定输入流包装成BufferReader
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                StringBuilder sb = new StringBuilder("");
                String line = null;
                //循环读取文件内容
                while((line = br.readLine()) != null){
                    sb.append(line);
                }
                br.close();
                return sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save_study_sd, menu);
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
