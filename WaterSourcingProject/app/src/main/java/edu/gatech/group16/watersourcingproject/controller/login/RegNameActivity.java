package edu.gatech.group16.watersourcingproject.controller.login;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.gatech.group16.watersourcingproject.R;
import edu.gatech.group16.watersourcingproject.controller.HomeActivity;
import edu.gatech.group16.watersourcingproject.model.User;

public class RegNameActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameField;
    private User user;
    private Toolbar toolbar;
    private Button cancelButton;

    /**
     * OnCreate method required to load activity and loads everything that
     * is needed for the page while setting the view.
     *
     *
     * @param savedInstanceState Takes in a bundle that may contain an object
     *                           for use within this class
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_name);

        nameField = (EditText) findViewById(R.id.reg_text_name);
        cancelButton = (Button) findViewById(R.id.cancel_button);

        cancelButton.setOnClickListener(this);
        findViewById(R.id.reg_button_continue).setOnClickListener(this);

        user = (User) getIntent().getSerializableExtra("USER");

        toolbar = (Toolbar) findViewById(R.id.name_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegNameActivity.this, RegAccountTypeActivity.class);
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
            if (validForm()) {
                user.setName(nameField.getText().toString());
                Intent intent = new Intent(this, RegEmailActivity.class);
                intent.putExtra("USER", user);
                startActivity(intent);
                this.finish();
            }
        } else if (i == R.id.cancel_button) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("USER", user);
            startActivity(intent);
            this.finish();
        }
    }

    /**
     * Checks if form is of valid syntax.
     *
     * @return valid true or false depending on if the form inputted is valid.
     */
    public boolean validForm() {
        boolean valid = true;
        String name = nameField.getText().toString();
        if (TextUtils.isEmpty(name)) {
            nameField.setError("Required.");
            valid = false;
        } else {
            nameField.setError(null);
        }
        return valid;
    }
}
