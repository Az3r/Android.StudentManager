package tkpm.doan.student.ui.components.constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Provider {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    public static String Format(String format, Date date)
    {
        return new SimpleDateFormat(format,Locale.getDefault()).format(date);
    }
    public static DateFormat getDateFormat() {
        return dateFormat;
    }
}
