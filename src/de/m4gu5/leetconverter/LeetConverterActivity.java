package de.m4gu5.leetconverter;

import de.m4gu5.leetconverter.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;


public class LeetConverterActivity extends Activity {
	
	Convert2Leet c2l = new Convert2Leet();
	Resources resources;
	EditText output;
	EditText input;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		resources = this.getResources();
		setContentView(R.layout.main);
		
		input = (EditText)findViewById(R.id.input);
		output = (EditText)findViewById(R.id.output);
	}
	
	public void buttonOkClicked(View view) {
		String inputValue = input.getText().toString();
		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
		
		output.setText(c2l.convertIt(inputValue, resources));
	}
	
	public void buttonDeleteClicked(View view) {
		input.setText("");
		output.setText("");
	}
}