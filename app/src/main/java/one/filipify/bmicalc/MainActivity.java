package one.filipify.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Error detected";
    EditText height;
    EditText weight;
    Button calculate;
    Double a;
    Double b;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.et_height);
        weight = (EditText) findViewById(R.id.et_weight);
        calculate = (Button) findViewById(R.id.bt_calc);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(height.getText().toString().isEmpty() || weight.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter values", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "Height / Weight Value is missing.");
                } else {
                    a = Double.parseDouble(String.valueOf(height.getText()));
                    b = Double.parseDouble(String.valueOf(weight.getText()));
                    Double c = b / ((a / 100) * (a / 100));

                    if(c < 18.5){
                        result = "Underweight";
                    } else if (c >= 18.5 || c < 25) {
                        result = "Healthy Weight";
                    } else if (c >= 25 || c < 30) {
                        result = "Overweight";
                    } else {
                        result = "Obese";
                    }

                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                    height.getText().clear();
                    weight.getText().clear();
                }

            }
        });
    }
}