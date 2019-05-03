package com.example.hp.createfolder;


import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public void  Folder(View v)

    {
        File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "Setting/System_Files/data/details/");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("App", "failed to create directory");

            }
            Toast.makeText(MainActivity.this, "Directory Created Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    public void DeleteFolder(View vi)
    {
        File dir = new File(Environment.getExternalStorageDirectory(), "Setting");
        DeleteRecursive(dir);



    }
    void DeleteRecursive(File dir)
    {
        Log.d("DeleteRecursive", "DELETEPREVIOUS TOP" + dir.getPath());
        if (dir.isDirectory())
        {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++)
            {
                File temp = new File(dir, children[i]);
                if (temp.isDirectory())
                {
                    Log.d("DeleteRecursive", "Recursive Call" + temp.getPath());
                    DeleteRecursive(temp);
                }
                else
                {
                    Log.d("DeleteRecursive", "Delete File" + temp.getPath());
                    boolean b = temp.delete();
                    if (b == false)
                    {
                        Log.d("DeleteRecursive", "DELETE FAIL");
                    }
                }
            }

        }
        dir.delete();
        Toast.makeText(MainActivity.this, "Directory Deleted Successfully!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
