package com.joaquinalan.petagram.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.joaquinalan.petagram.R;
import com.joaquinalan.petagram.model.Email;

public class ContactActivity extends AppCompatActivity {
    private TextInputLayout tilName;
    private TextInputLayout tilEmail;
    private TextInputLayout tilComment;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        tilName = (TextInputLayout) findViewById(R.id.textinputlayout_contact_name);
        tilEmail = (TextInputLayout) findViewById(R.id.textinputlayout_contact_email);
        tilComment = (TextInputLayout) findViewById(R.id.textinputlayout_contact_comment);
        btnSend = (Button) findViewById(R.id.button_contact_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
        initializeToolbar();
    }

    private void initializeToolbar() {
        Toolbar tbMyActionBar = (Toolbar) findViewById(R.id.toolbar_contact);
        setSupportActionBar(tbMyActionBar);
        getSupportActionBar().setTitle(getString(R.string.contact_toolbartitle));
        getSupportActionBar().setIcon(R.drawable.ic_contact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void sendEmail() {
        //Getting content for email
        String email = tilEmail.getEditText().getText().toString().trim();
        String subject = tilName.getEditText().getText().toString().trim();
        String message = tilComment.getEditText().getText().toString().trim();

        //Creating SendMail object
        Email sm = new Email(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }
}
