package com.sanoshchenko.converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Converter extends Activity {
    private EditText mEditField;
    private Button mButton;
    private TextView mTextResult;
    private Converter_rate converter_rate = new Converter_rate();
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private String base_url = "https://currency-api.appspot.com/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        mEditField = (EditText)findViewById(R.id.valueEditText);
        mButton = (Button) findViewById(R.id.startButton);
        mTextResult = (TextView)findViewById(R.id.textView);
        spinnerFrom = (Spinner) findViewById(R.id.ComboboxFrom);
        spinnerTo = (Spinner) findViewById(R.id.ComboboxTo);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.planets_array1, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        spinnerFrom.setAdapter(adapter1);
        spinnerTo.setAdapter(adapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditField.getText().toString().length() <=0){
                    Toast.makeText(Converter.this,"You have to input number",Toast.LENGTH_LONG).show();
                }
                String name = mEditField.getText().toString();
                final double value = Double.valueOf(name);
                int currTo = spinnerTo.getSelectedItemPosition();

                Rates[] ratesArray = Rates.values();
                Rates cur = ratesArray[currTo];
                mTextResult.setText(String.valueOf(cur.rate * value));
            }
        });


    }

}
