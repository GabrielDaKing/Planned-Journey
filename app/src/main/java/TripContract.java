import android.provider.BaseColumns;

/**
 * Created by gncis on 14-Mar-18.
 *
 * int type,party;
 String name,hotel;
 Date start,end;
 */

public class TripContract {

    public static final class TripEntry implements BaseColumns{

        public static final String TABLE_NAME = "trips";

    }
}
