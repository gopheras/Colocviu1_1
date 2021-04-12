package ro.pub.cs.systems.eim.Colocviu1_1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ProcessingThread extends Thread {

    private Context context;
    public String message;

    public ProcessingThread(Context context, String message) {
        this.context = context;
        this.message = message;
    }

    public void run() {
        Log.d(Constants.TAG, "Thread.run() was invoked, PID: " + android.os.Process.myPid() + " TID: " + android.os.Process.myTid());
        sleep();
        sendMessage(message);
    }

    private void sendMessage(String message) {
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_STRING);
        intent.putExtra(Constants.DATA, message);
        Log.d(Constants.TAG, "Sending a message!");
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException interruptedException) {
            Log.e(Constants.TAG, interruptedException.getMessage());
            interruptedException.printStackTrace();
        }
    }

}
