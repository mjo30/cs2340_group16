package edu.gatech.group16.watersourcingproject.controller.login;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.content.Intent;

import edu.gatech.group16.watersourcingproject.R;
import edu.gatech.group16.watersourcingproject.model.Enums.AccountType;
import edu.gatech.group16.watersourcingproject.model.User;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class RegAccountTypeActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner accTypeSpinner;
    private User user = new User();
    private Toolbar toolbar;
    private Button cancelButton;
    private static final String TAG = "AccountTypeReg";

    /**
     * OnCreate method required to load activity and loads everything that
     * is needed for the page while setting the view.
     *
     *
     * @param savedInstanceState Takes in a bundle that may contain an object
     *                           for use within this class
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_account_type);

        accTypeSpinner = (Spinner) findViewById(R.id.reg_spin_acctype);
        cancelButton = (Button) findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(this);

        findViewById(R.id.reg_button_continue).setOnClickListener(this);
        ArrayAdapter<AccountType> adaptAcc
                = new ArrayAdapter(this, android.R.layout.simple_spinner_item, User.legalClass);
        accTypeSpinner.setAdapter(adaptAcc);
        toolbar = (Toolbar) findViewById(R.id.type_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegAccountTypeActivity.this, LoginActivity.class);
                intent.putExtra("USER", user);
                startActivity(intent);
            }
        });
    }

    /**
     * OnClick method that will listen for clicks on the
     * view that is taken in and proceed with actions.
     *
     *
     * @param v Takes in a view that will contain buttons
     *          for the onClick method to listen to.
     */
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.reg_button_continue) {
            user.setAccountType((AccountType) accTypeSpinner.getSelectedItem());
            Intent intent = new Intent(this, RegNameActivity.class);
            intent.putExtra("USER", user);
            startActivity(intent);
            this.finish();
        } else if (i == R.id.cancel_button) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("USER", user);
            startActivity(intent);
            this.finish();
        }
    }
}
