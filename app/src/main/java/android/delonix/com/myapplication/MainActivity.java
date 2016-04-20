package android.delonix.com.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

         @Override
         protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                 setContentView(R.layout.activity_main);

                // Add act1.xml to the layout of mainactivity.xml
                 Act1 fragment1 = new Act1();
                 FragmentManager manager = getSupportFragmentManager();
                 FragmentTransaction transaction = manager.beginTransaction();

                 transaction.add(R.id.ll_main, fragment1);
                 transaction.commit();
         }
}

