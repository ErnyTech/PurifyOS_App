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


public class kernel_art extends AppCompatActivity {

    private static CoordinatorLayout coordinatorLayout;
    Button kernel3, kernel3t, kernel, artspeed, artbalance, artcompile, artint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kernel_art);
        kernel3 = (Button) findViewById(R.id.kernel3);
        kernel3t = (Button) findViewById(R.id.kernel3t);
        kernel = (Button) findViewById(R.id.kernel);
        artspeed = (Button) findViewById(R.id.artspeed);
        artbalance = (Button) findViewById(R.id.artbalance);
        artcompile = (Button) findViewById(R.id.artcompile);
        artint = (Button) findViewById(R.id.artint);

        kernel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tre = new Intent(kernel_art.this, kernel3.class);
                startActivity(tre);
            }
        });
        kernel3t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tret = new Intent(kernel_art.this, kernel3t.class);
                startActivity(tret);
            }
        });
        kernel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kernel = new Intent();
                kernel.setComponent(new ComponentName("com.grarak.kerneladiutor", "com.grarak.kerneladiutor.MainActivity"));
                startActivity(kernel);
            }
        });
        artspeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process as = Runtime.getRuntime().exec("su -c runl set_file_prop dalvik.vm.image-dex2oat-filter speed magisk/runtime-optimization/system.prop");
                    as.waitFor();
                    Process as1 = Runtime.getRuntime().exec("su -c rm -rf /data/dalvik-cache");
                    as1.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                reboot();
            }
        });
        artbalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process ab = Runtime.getRuntime().exec("su -c runl set_file_prop dalvik.vm.image-dex2oat-filter balanced magisk/runtime-optimization/system.prop");
                    ab.waitFor();
                    Process ab1 = Runtime.getRuntime().exec("su -c rm -rf /data/dalvik-cache");
                    ab1.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                reboot();
            }
        });
        artcompile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process ac = Runtime.getRuntime().exec("su -c runl set_file_prop dalvik.vm.image-dex2oat-filter everything magisk/runtime-optimization/system.prop");
                    ac.waitFor();
                    Process ac1 = Runtime.getRuntime().exec("su -c rm -rf /data/dalvik-cache");
                    ac1.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                reboot();
            }
        });
        artint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process ai = Runtime.getRuntime().exec("su -c runl set_file_prop dalvik.vm.image-dex2oat-filter interpret-only everything magisk/runtime-optimization/system.prop");
                    ai.waitFor();
                    Process ai1 = Runtime.getRuntime().exec("su -c rm -rf /data/dalvik-cache");
                    ai1.waitFor();
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

}