package com.stepup.patterns;

import com.stepup.useragent.UserAgent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//класс обёртка
public class LogEntry {

    private final String ipAddr;
    private final String LocalDateTime;
    private final HttpMethod method;
    private final String requestPath;
    private final int responseCode;
    private final long responseSize;
    private final String referer;
    private final UserAgent userAgent;

    public LogEntry(String logLine) {
        // Регулярное выражение для парсинга строки лога
        String pattern = "^(\\S+) (\\S+ \\S+) (\\S+) (\\S+) (\\d+) (\\d+) (\\S+) \"([^\"]+)\"$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(logLine);

        if (m.find()) {
            this.ipAddr  = m.group(1);
            this.LocalDateTime  = m.group(2);
            this.method = HttpMethod.valueOf(m.group(3).toUpperCase());
            this.requestPath = m.group(4);
            this.responseCode= Integer.parseInt(m.group(5));
            this.responseSize = Long.parseLong(m.group(6));
            this.referer= m.group(7);
            this.userAgent = new UserAgent(m.group(8));
        } else {
            throw new IllegalArgumentException("Неверный формат строки лога");
        }
    }

    // Геттеры
    public String getIp() { return ipAddr; }
    public String getTimestamp() { return LocalDateTime; }
    public HttpMethod getRequest() { return method; }
    public long getContentLength() { return responseSize; }
    public String getReferer() { return referer; }
    public UserAgent getUserAgent() { return userAgent; }
    public int getResponseCode() { return responseCode; }
    public String getRequestPath() {return requestPath;}
}
