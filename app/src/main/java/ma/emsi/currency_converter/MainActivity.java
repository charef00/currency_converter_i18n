package ma.emsi.currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Spinner from,to;
    EditText amount;
    Button convert;
    TextView result;
    String[] currencies={"MAD","USD","EUR"};
    ArrayAdapter<String> model1;
    ArrayAdapter<CharSequence> model2;

    double[][] xchange=
            {                // j=0   j=1  j=2
                    /* i= 0 */ {1.0, 0.099,0.091},
                    /* i= 1 */ {10.09 ,1.0,0.92},
                    /* i= 2 */ {10.98 , 1.09,1.0},
            };
    String[] symbol ={"DH","$","€"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model1=new ArrayAdapter<String>(this, R.layout.item_file,currencies);
        from=findViewById(R.id.spinner_from);
        from.setAdapter(model1);
        model2=ArrayAdapter.createFromResource(this,R.array.currencies,android.R.layout.simple_list_item_1);
        to=findViewById(R.id.spinner_to);
        to.setAdapter(model2);
        amount=findViewById(R.id.amount);
        convert=findViewById(R.id.convert);
        result=findViewById(R.id.result);
        convert.setOnClickListener(e->{
            int i =from.getSelectedItemPosition();
            int j =to.getSelectedItemPosition();
            double mnt=Double.parseDouble(amount.getText().toString());
            double rslt=mnt*xchange[i][j];
            result.setText(rslt+" "+symbol[j]);
        });
        findViewById(R.id.next).setOnClickListener(
                e->{
                    Intent i=new Intent(this,NextActivity.class);
                    i.putExtra("amount",amount.getText().toString());
                    i.putExtra("symbol",symbol);
                    startActivity(i);
                }
        );


    }
}