package com.anees.sorting;

import java.util.Arrays;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button sort;
    EditText text;
    TextView tvResult;
    String ss;
    int a[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	initVars();
	sort.setOnClickListener(new View.OnClickListener() {

	    @Override
	    public void onClick(View arg0) {
		tvResult.setText("");
		ss = text.getText().toString().trim();
		if (ss.length() != 0 && ss != null) {
		    performParsingAndSorting();
		}
	    }

	    private void performParsingAndSorting() {
		String[] strInts = ss.split(",");
		a = new int[strInts.length];
		Log.d("Lengths", "Str Length : " + strInts.length + "and Int Length: " + a.length);
		boolean flag = true;
		for (int i = 0; i < strInts.length; i++) {
		    try {
			a[i] = Integer.parseInt(strInts[i]);
		    } catch (Exception e) {
			flag = false;
			e.printStackTrace();
		    }

		}
		if (flag) {
		    // Perform Sort Here
		    /*
		     * Arrays.sort(a);
		     */
		    for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
			    if (a[i] > a[j]) {
				a[i] = a[i] + a[j];
				a[j] = a[i] - a[j];
				a[i] = a[i] - a[j];
			    }
			}
		    }

		    Log.d("output:", Arrays.toString(a));
		    tvResult.setText(Arrays.toString(a));

		} else {
		    Toast.makeText(getApplicationContext(), "Input Contains Invalid Integers!", Toast.LENGTH_SHORT).show();
		}

	    }
	});
    }

    private void initVars() {
	text = (EditText) findViewById(R.id.etNumbers);
	sort = (Button) findViewById(R.id.btnSort);
	tvResult = (TextView) findViewById(R.id.tvResult);
    }
}
