package utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class UnicodeManager {
    public String getUnicodeIcon(String code) {
        Charset defaultCharset = Charset.defaultCharset();
        byte[] sourceBytes = code.getBytes(StandardCharsets.UTF_8);

        try {
            return new String(sourceBytes, defaultCharset.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";
    }
}
