package eecs1022.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab2Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
    }

    private void setTextViewById(int ID, String text) {
        TextView view = (TextView) findViewById(ID);
        view.setText(text);
    }

    private String getInputById(int ID) {
        EditText view = (EditText) findViewById(ID);
        return view.getText().toString();
    }

    private String getItemSelectedById(int ID) {
        Spinner spinner = (Spinner) findViewById(ID);
        return spinner.getSelectedItem().toString();
    }

    public void computeTaxButtonClicked(View view) {
        // get user informations
        String name = getInputById(R.id.inputName);
        double income = Double.parseDouble(getInputById(R.id.inputIncome));
        String status = getItemSelectedById(R.id.spinnerStatus);

        // calculate with model
        TaxPayer user = new TaxPayer(name, income, status);

        // show result
        setTextViewById(R.id.labelAnswer, user.toString());
    }
}