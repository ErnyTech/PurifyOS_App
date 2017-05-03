package purifyos.settings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class GeneralActivity extends AppCompatActivity {

    Button selinuxenable, selinuxdisable, artenable, artdisable, youtubeenable, youtubedisable, perm, startup, log, band, stat, lab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        selinuxenable = (Button) findViewById(R.id.selinuxenable);
        selinuxdisable = (Button) findViewById(R.id.selinuxdisable);
        artenable = (Button) findViewById(R.id.artenable);
        artdisable = (Button) findViewById(R.id.artdisable);
        youtubeenable = (Button) findViewById(R.id.youtubeenable);
        youtubedisable = (Button) findViewById(R.id.youtubedisable);
        startup = (Button) findViewById(R.id.startup);
        perm = (Button) findViewById(R.id.perm);
        log = (Button) findViewById(R.id.log);
        band = (Button) findViewById(R.id.band);
        stat = (Button) findViewById(R.id.stat);
        lab = (Button) findViewById(R.id.lab);

        selinuxenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 1", Toast.LENGTH_LONG).show();//display the text of button1
            }
        });
        selinuxdisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });
        artenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });
        artenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });
        artenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });
        artenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });
        artenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });
        artenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });
        artenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });
        artenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });
        artenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });
        artenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });
    }


}