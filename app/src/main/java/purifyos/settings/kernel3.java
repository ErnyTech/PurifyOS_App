package purifyos.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class kernel3 extends AppCompatActivity {

    private static CoordinatorLayout coordinatorLayout;
    Button pextreme, performance, balanced, battery, bextreme, disable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kernel3);
        pextreme = (Button) findViewById(R.id.pextreme);
        performance = (Button) findViewById(R.id.performance);
        balanced = (Button) findViewById(R.id.balanced);
        battery = (Button) findViewById(R.id.battery);
        bextreme = (Button) findViewById(R.id.bextreme);
        disable = (Button) findViewById(R.id.disable);

        pextreme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process pextreme = Runtime.getRuntime().exec("su -c sh /magisk/AKT/script/pextreme.sh");
                    pextreme.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                ok();
            }
        });
        performance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process performance = Runtime.getRuntime().exec("su -c sh /magisk/AKT/script/performance.sh");
                    performance.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                ok();
            }
        });
        balanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process balanced = Runtime.getRuntime().exec("su -c sh /magisk/AKT/script/balanced.sh");
                    balanced.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                ok();
            }
        });
        battery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process battery = Runtime.getRuntime().exec("su -c sh /magisk/AKT/script/battery.sh");
                    battery.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                ok();
            }
        });
        bextreme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process bextreme = Runtime.getRuntime().exec("su -c sh /magisk/AKT/script/bextreme.sh");
                    bextreme.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                ok();
            }
        });
        disable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process disable = Runtime.getRuntime().exec("su -c cat /magisk/akt/system/etc/AKT/DisableInitd > /magisk/akt/system/etc/init.d/99AKT");
                    disable.waitFor();
                    Process disable1 = Runtime.getRuntime().exec("su -c cat /magisk/akt/system/etc/AKT/DisableInitd > /magisk/akt/system/su.d/99AKT");
                    disable1.waitFor();
                    Process disable2 = Runtime.getRuntime().exec("su -c chmod 644 /magisk/akt/system/etc/init.d/99AKT");
                    disable2.waitFor();
                    Process disable3 = Runtime.getRuntime().exec("su -c chmod 644 /magisk/akt/system/su.d/99AKT");
                    disable3.waitFor();
                    Process disable4 = Runtime.getRuntime().exec("su -c chmod 777 /system/etc/AKT/Stock");
                    disable4.waitFor();
                    Process disable5 = Runtime.getRuntime().exec("su -c sh /system/etc/AKT/Stock");
                    disable5.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                ok();
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