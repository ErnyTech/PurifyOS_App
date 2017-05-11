package purifyos.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class kernel3t extends AppCompatActivity {

    private static CoordinatorLayout coordinatorLayout;
    Button pextremet, performancet, balancedt, batteryt, bextremet, disable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kernel3t);
        pextremet = (Button) findViewById(R.id.pextremet);
        performancet = (Button) findViewById(R.id.performancet);
        balancedt = (Button) findViewById(R.id.balancedt);
        batteryt = (Button) findViewById(R.id.batteryt);
        bextremet = (Button) findViewById(R.id.bextremet);
        disable = (Button) findViewById(R.id.disable);

        pextremet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process pextremet = Runtime.getRuntime().exec("su -c sh /magisk/AKT/script/pextremet.sh");
                    pextremet.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                ok();
            }
        });
        performancet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process performancet = Runtime.getRuntime().exec("su -c sh /magisk/AKT/script/performancet.sh");
                    performancet.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                ok();
            }
        });
        balancedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process balancedt = Runtime.getRuntime().exec("su -c sh /magisk/AKT/script/balancedt.sh");
                    balancedt.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                ok();
            }
        });
        batteryt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process batteryt = Runtime.getRuntime().exec("su -c sh /magisk/AKT/script/batteryt.sh");
                    batteryt.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                ok();
            }
        });
        bextremet.setOnClickListener(new View.OnClickListener() {
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