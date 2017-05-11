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


public class GeneralActivity extends AppCompatActivity {

    private static CoordinatorLayout coordinatorLayout;
    Button selinuxenable, selinuxdisable, artenable, artdisable, youtubeenable, youtubedisable, perm, startup, log, band, stat, lab;

    public GeneralActivity() throws IOException {
    }

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
                try {
                    Process se = Runtime.getRuntime().exec("su -c rm /magisk/selinux/disable");
                    se.waitFor();
                    Process se1 = Runtime.getRuntime().exec("su -c setenforce 0");
                    se1.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        selinuxdisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process sd = Runtime.getRuntime().exec("su -c touch /magisk/selinux/disable");
                    sd.waitFor();
                    Process sd1 = Runtime.getRuntime().exec("su -c setenforce 1");
                    sd1.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        artenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process ae = Runtime.getRuntime().exec("su -c rm /magisk/selinux/disable");
                    ae.waitFor();
                    Process ae1 = Runtime.getRuntime().exec("su -c rm -rf /data/dalvik-cache");
                    ae1.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                reboot();
            }
        });
        artdisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process ad = Runtime.getRuntime().exec("su -c touch /magisk/selinux/disable");
                    ad.waitFor();
                    Process ad1 = Runtime.getRuntime().exec("su -c rm -rf /data/dalvik-cache");
                    ad1.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                reboot();
            }
        });
        youtubeenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process ye = Runtime.getRuntime().exec("su -c rm /magisk/youtube/disable");
                    ye.waitFor();
                    Process ye1 = Runtime.getRuntime().exec("su -c rm -rf /data/dalvik-cache");
                    ye1.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                reboot();
            }
        });
        youtubedisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process yd = Runtime.getRuntime().exec("su -c touch /magisk/youtube/disable");
                    yd.waitFor();
                    Process yd1 = Runtime.getRuntime().exec("su -c rm -rf /data/dalvik-cache");
                    yd1.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                reboot();
            }
        });
        startup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.oneplus.security", "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity"));
                startActivity(intent);
            }
        });
        perm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent perm = new Intent();
                perm.setComponent(new ComponentName("com.oneplus.security", "com.oneplus.security.defaultapp.DefaultAppListActivity"));
                startActivity(perm);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log = new Intent();
                log.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$NotificationStationActivity"));
                startActivity(log);
            }
        });
        band.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent band = new Intent();
                band.setComponent(new ComponentName("com.android.settings", "com.android.settings.RadioInfo"));
                startActivity(band);
            }
        });
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stat = new Intent();
                stat.setComponent(new ComponentName("com.android.settings", "com.android.settings.UsageStatsActivity"));
                startActivity(stat);
            }
        });
        lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lab = new Intent();
                lab.setComponent(new ComponentName("com.android.systemui", "com.android.systemui.DemoMode"));
                startActivity(lab);
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