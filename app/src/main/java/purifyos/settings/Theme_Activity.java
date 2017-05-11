package purifyos.settings;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class Theme_Activity extends AppCompatActivity {

    private static CoordinatorLayout coordinatorLayout;
    Button ozone, clock, sub, black, dark, disabletheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kernel3t);
        ozone = (Button) findViewById(R.id.ozone);
        clock = (Button) findViewById(R.id.clock);
        sub = (Button) findViewById(R.id.sub);
        black = (Button) findViewById(R.id.black);
        dark = (Button) findViewById(R.id.dark);
        disabletheme = (Button) findViewById(R.id.disabletheme);

        ozone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ozone = new Intent();
                ozone.setComponent(new ComponentName("com.ungeeked.ozone", "com.ungeeked.ozone.substratum.theme.template.SubstratumLauncher"));
                startActivity(ozone);
            }
        });
        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clock = new Intent();
                clock.setComponent(new ComponentName("com.kpchuck.kkclock", "com.kpchuck.kkclock.substratum.theme.template.SubstratumLauncher"));
                startActivity(clock);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sub = new Intent();
                sub.setComponent(new ComponentName("projekt.substratum", "projekt.substratum.MainActivity"));
                startActivity(sub);
            }
        });
        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process black = Runtime.getRuntime().exec("su -c rm /magisk/black/disable");
                    black.waitFor();
                    Process black1 = Runtime.getRuntime().exec("su -c rm -rf /data/dalvik-cache");
                    black1.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                reboot();
            }
        });
        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process dark = Runtime.getRuntime().exec("su -c rm /magisk/dark/disable");
                    dark.waitFor();
                    Process dark1 = Runtime.getRuntime().exec("su -c rm -rf /data/dalvik-cache");
                    dark1.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                reboot();
            }
        });
        disabletheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process disabletheme = Runtime.getRuntime().exec("su -c touch /magisk/dark/disable");
                    disabletheme.waitFor();
                    Process disabletheme0 = Runtime.getRuntime().exec("su -c touch /magisk/black/disable");
                    disabletheme0.waitFor();
                    Process disabletheme1 = Runtime.getRuntime().exec("su -c rm -rf /data/dalvik-cache");
                    disabletheme1.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                reboot();
            }
        });
    }

    private void reboot() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Applica le impostazioni");
        helpBuilder.setMessage("Riavvia il sistema per applicare le impostazioni, il primo avvio sarà più lento");
        helpBuilder.setPositiveButton("Riavvia",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            Runtime.getRuntime().exec("su -c reboot");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
        helpBuilder.setNegativeButton("No riavviare adesso", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }

    private void ok() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Impostazioni applicate");
        helpBuilder.setMessage("Applicato !");
        helpBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            Runtime.getRuntime().exec("echo ok");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
        helpBuilder.setNegativeButton("No riavviare adesso", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }

}