package ro.pub.cs.systems.eim.Colocviu1_1;

public interface Constants {

    final public static int buttonIds[] = {
            R.id.north,
            R.id.south,
            R.id.east,
            R.id.west,
    };

    final public static String TAG = "colocviu";
    final public static String PRESS_COUNT   = "press_count";
    final public static int MAIN_REQUEST_CODE = 96;
    final public static int MY_STRING_KEY = 97;
    final public static int MY_RETURN_KEY = 98;
    final public static int BROADCAST_MSG = 99;

    final public static String ACTION_STRING = "ro.pub.cs.systems.eim.Colocviu1_1.Colocviu1_1Service.string";
    final public static String DATA = "ro.pub.cs.systems.eim.Colocviu1_1.Colocviu1_1Service.data";

    final public static long SLEEP_TIME = 5000;
}
