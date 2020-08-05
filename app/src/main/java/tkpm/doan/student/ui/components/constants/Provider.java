package tkpm.doan.student.ui.components.constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Provider {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    public static DateFormat getDateFormat() {
        return dateFormat;
    }
}
