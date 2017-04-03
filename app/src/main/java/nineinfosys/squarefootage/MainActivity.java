package nineinfosys.squarefootage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView lengthTextview,widthTextview,radiusTextview;
    EditText lengthEditText,widthEditText,radiusEdittext;
Spinner areaField;
    TextView squareFootageValue;
    sqrFoot squareFootage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lengthTextview=(TextView)findViewById(R.id.textViewLength);
        widthTextview=(TextView)findViewById(R.id.textViewWidth);
        lengthEditText=(EditText)findViewById(R.id.editTextLength);
        widthEditText=(EditText)findViewById(R.id.editTextWidth);
        radiusEdittext=(EditText)findViewById(R.id.editTextRadius);


        squareFootageValue=(TextView)findViewById(R.id.textViewSquareFootageValue);
        radiusTextview=(TextView)findViewById(R.id.textViewRadius);
        Button buttonCalculte=(Button) findViewById(R.id.buttonCalculate);
        Button buttonClear=(Button) findViewById(R.id.buttonClear);
        areaField = (Spinner) findViewById(R.id.spinnerArea);

        ArrayList area = new ArrayList();
        area.add("Square");
        area.add("Triangle");
        area.add("Rectangle");
        area.add("Circle");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaField.setAdapter(dataAdapter);

        buttonCalculte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqrFoot Calculator = new sqrFoot();
                if (lengthEditText.getText().toString().trim().equals("")) {
                    lengthEditText.setError("Enter Length");
                } else if (widthEditText.getText().toString().trim().equals("")) {
                    widthEditText.setError("Enter Width");

                } else {
                    String spinnerArea = areaField.getSelectedItem().toString().trim();

                    final double lengthValue = Double.parseDouble(lengthEditText.getText().toString().trim());
                    final double widthValue = Double.parseDouble(widthEditText.getText().toString().trim());


                    if (areaField.getSelectedItem().toString().trim().equals("Triangle")) {

                        radiusTextview.setVisibility(View.INVISIBLE);
                        radiusEdittext.setVisibility(View.INVISIBLE);

                        lengthTextview.setVisibility(View.VISIBLE);
                        lengthEditText.setVisibility(View.VISIBLE);
                        widthTextview.setVisibility(View.VISIBLE);
                        widthEditText.setVisibility(View.VISIBLE);

                        double resultgrossDomesticProductValue = Calculator.triangle(lengthValue, widthValue);
                        squareFootageValue.setText("Square Footage Value:" + resultgrossDomesticProductValue);

                    }else if (areaField.getSelectedItem().toString().trim().equals("Circle")) {

                        radiusTextview.setVisibility(View.VISIBLE);
                        radiusEdittext.setVisibility(View.VISIBLE);

                        lengthTextview.setVisibility(View.INVISIBLE);
                        lengthEditText.setVisibility(View.INVISIBLE);
                        widthTextview.setVisibility(View.INVISIBLE);
                        widthEditText.setVisibility(View.INVISIBLE);

                      if (radiusEdittext.getText().toString().trim().equals("")) {
                            radiusEdittext.setError("Enter Radius");

                        }
                      else {
                          double radiusValue = Double.parseDouble(radiusEdittext.getText().toString().trim());

                          double resultgrossDomesticProductValue = Calculator.circle(radiusValue);
                          squareFootageValue.setText("Square Footage Value:" + resultgrossDomesticProductValue);
                      }

                    }else if (areaField.getSelectedItem().toString().trim().equals("Rectangle")) {
                        radiusTextview.setVisibility(View.INVISIBLE);
                        radiusEdittext.setVisibility(View.INVISIBLE);

                        lengthTextview.setVisibility(View.VISIBLE);
                        lengthEditText.setVisibility(View.VISIBLE);
                        widthTextview.setVisibility(View.VISIBLE);
                        widthEditText.setVisibility(View.VISIBLE);

                        double resultgrossDomesticProductValue = Calculator.rectangle(lengthValue, widthValue);
                        squareFootageValue.setText("Square Footage Value:" + resultgrossDomesticProductValue);
                    }
                    else if (areaField.getSelectedItem().toString().trim().equals("Square")) {

                        widthTextview.setVisibility(View.INVISIBLE);
                        widthEditText.setVisibility(View.INVISIBLE);
                        radiusTextview.setVisibility(View.INVISIBLE);
                        radiusEdittext.setVisibility(View.INVISIBLE);

                        lengthTextview.setVisibility(View.VISIBLE);
                        lengthEditText.setVisibility(View.VISIBLE);

                        double resultgrossDomesticProductValue = Calculator.square(lengthValue);
                        squareFootageValue.setText("Square Footage Value:" + resultgrossDomesticProductValue);
                    }
                    else{

                    }
                }
            }


        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                lengthEditText.getText().clear();
                widthEditText.getText().clear();
                squareFootageValue.setText("");
                radiusEdittext.getText().clear();

            }
        });

    }
}
