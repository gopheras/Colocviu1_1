package ro.pub.cs.systems.eim.Colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviu1_1MainActivity extends AppCompatActivity {

    public Button buttonCardinalDirection;
    public Button buttonNavigate;
    public TextView stringText;
    public Integer pressCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_1_main);

        if (savedInstanceState == null) {
            Log.d(Constants.TAG, "onCreate() method was invoked without a previous state");
            pressCount = 0;
        } else {
            Log.d(Constants.TAG, "onCreate() method was invoked with a previous state");
            if (savedInstanceState.containsKey(Constants.PRESS_COUNT)) {
                pressCount = savedInstanceState.getInt(Constants.PRESS_COUNT);
            } else {
                pressCount = 0;
            }
        }

        stringText = (TextView)findViewById(R.id.textPressed);

        for (int index = 0; index < Constants.buttonIds.length; index++) {
            buttonCardinalDirection = (Button) findViewById(Constants.buttonIds[index]);
            buttonCardinalDirection.setOnClickListener(genericButtonClickListener);
        }
    }

    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            stringText.setText(stringText.getText().toString() + ((Button)view).getText().toString() + ", ");
            pressCount += 1;
            Log.d(Constants.TAG, pressCount.toString());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(Constants.PRESS_COUNT, pressCount);
    }
}