package ro.pub.cs.systems.eim.Colocviu1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_1SecondaryActivity extends AppCompatActivity {

    public TextView stringText;
    public Button registerButton;
    public Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_1_secondary);

        stringText = (TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        if (intent != null) {
            String instructions = intent.getStringExtra("ro.pub.cs.systems.eim.Colocviu1_1.MY_STRING_KEY");
            if (instructions != null) {
                stringText.setText(instructions);
            }
        }

        cancelButton = (Button)findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(anyButtonClickListener);

        registerButton = (Button)findViewById(R.id.buttonRegister);
        registerButton.setOnClickListener(anyButtonClickListener);
    }

    private AnyButtonClickListener anyButtonClickListener = new AnyButtonClickListener();
    private class AnyButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String myValue = "";

            switch (view.getId()) {
                case R.id.buttonCancel:
                    myValue = "Cancel";
                    break;
                case R.id.buttonRegister:
                    myValue = "Register";
                    break;
            }

            Intent intentToParent = new Intent();
            intentToParent.putExtra("ro.pub.cs.systems.eim.Colocviu1_1.MY_RETURN_KEY", myValue);
            setResult(RESULT_OK, intentToParent);

            finish();
        }
    }
}
