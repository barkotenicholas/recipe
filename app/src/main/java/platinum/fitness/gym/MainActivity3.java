package platinum.fitness.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;

public class MainActivity3 extends AppCompatActivity {

    public ImageView imageView;
    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private Button button;
    private BillingProcessor billingProcessor;
    private static final String TAG = "InAppBilling";
    static final String ITEM_SKU_ADREMOVAL = "recipe";

    private String mAdRemovalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textView = findViewById(R.id.ttt1);
        textView1 = findViewById(R.id.ttt2);
        textView2 = findViewById(R.id.ttt3);
        imageView = findViewById(R.id.image);
        button = findViewById(R.id.but);
        Intent intent = getIntent();

        int price = intent.getIntExtra("PRICE", 0);
        int u = intent.getIntExtra("IMAGE", 0);
        String type = intent.getStringExtra("TYPE");
        String menuitem = intent.getStringExtra("MENUITEM");


        imageView.setImageResource(u);
        textView1.setText(menuitem);
        textView2.setText(type);
        textView.setText(String.valueOf(price));


        billingProcessor = new BillingProcessor(this,"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAs3Tsf5E38471a5L+VuTu3iUBift3723nwZGxsPJO18kaLEE/QDH38l3sjSUMuhxWVCd8FBhoQnI3Z2STudqttd4BHzomVNzHNhIWyxio5+CrKhvVElwMAx0C9IlJQRGXd27FGEl3pio1Cr3D5TBqCASg2cyIs2oG8dmbgsJZcE8dxYekA7fhxtjTO8dpyNlGf9/mibweubAetQh3hyKtjbJAc71H/OSz6fjVxv5+KohdW75m/DQxqf9UsTNTWv18PCLxBi8sv1kdQgvufLAkybM3FrbU7BsHh99kY3JfARdS0jUZyfw+Cvoc3HErLuRDyuaJL890Xyytr4/PFQNPOwIDAQAB" , null, new BillingProcessor.IBillingHandler() {
            @Override
            public void onProductPurchased(String productId, TransactionDetails details) {
                Toast.makeText(MainActivity3.this,"purchased",Toast.LENGTH_LONG);

            }

            @Override
            public void onPurchaseHistoryRestored() {

            }

            @Override
            public void onBillingError(int errorCode, Throwable error) {

            }

            @Override
            public void onBillingInitialized() {

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this,"asdfghj",Toast.LENGTH_SHORT);
                billingProcessor.subscribe(MainActivity3.this,"platinum_gym");
            }
        });


    }


}