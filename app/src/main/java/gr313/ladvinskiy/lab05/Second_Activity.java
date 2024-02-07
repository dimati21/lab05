package gr313.ladvinskiy.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class Second_Activity extends AppCompatActivity {

    EditText txt;
    Switch Sw1;
    Switch Sw2;
    EditText Txt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);
            Sw1=findViewById(R.id.SwtL);
            Sw2= findViewById(R.id.SwtR);
            Txt2= findViewById(R.id.SecondTXTInput);
            Boolean c1=getIntent().getBooleanExtra("CBox1",false);
            Boolean c2 =getIntent().getBooleanExtra("CBox2",false);
            String t1= getIntent().getStringExtra("Text1");
            Sw1.setChecked(c1);
            Sw2.setChecked(c2);
            Txt2.setText(t1);
        }
        catch (Exception ignored){}
    }

    public void on_cancel_click(View v){
        setResult(RESULT_CANCELED);
        finish();
    }

    public void on_ok_click(View v){
        try {
            setResult(RESULT_OK);
            finish();
            Txt2=findViewById(R.id.SecondTXTInput);
            Sw1 = findViewById(R.id.SwtL);
            Sw2 = findViewById(R.id.SwtR);
            String t2= Txt2.getText().toString();
            Intent intent = new Intent(Second_Activity.this, MainActivity.class);
            intent.putExtra("switch1", Sw1.isChecked());
            intent.putExtra("switch2", Sw2.isChecked());
            intent.putExtra("Text2",t2);
            startActivity(intent);
        }
        catch (Exception ignored){}
    }
}