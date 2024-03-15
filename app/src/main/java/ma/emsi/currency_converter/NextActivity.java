package ma.emsi.currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Intent data=getIntent();
        String amount=data.getExtras().getString("amount");
        TextView txt=findViewById(R.id.txt);
        txt.setText(amount);

    }
}