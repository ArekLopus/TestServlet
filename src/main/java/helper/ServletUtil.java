package helper;

import java.io.IOException;

import javax.servlet.ServletResponse;

public class ServletUtil {
    public static void writeResponse(ServletResponse response, String text) {
        try {
            response.getWriter().write(text);
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}