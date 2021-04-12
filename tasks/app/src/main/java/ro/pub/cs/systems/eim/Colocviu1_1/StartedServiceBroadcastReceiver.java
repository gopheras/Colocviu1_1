package ro.pub.cs.systems.eim.Colocviu1_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    public StartedServiceBroadcastReceiver() {
        this.messageTextView = null;
    }

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        String data = intent.getStringExtra(Constants.DATA);

        Log.d(Constants.TAG, data);
    }
}
