package com.stepup.patterns;

import com.stepup.useragent.base.UserAgent;
import com.stepup.useragent.base.UserAgentInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//класс обёртка
public class LogEntry {


    private final int lineNumber;
    private final String ipAddr;
    private final String LocalDateTime;
    private final HttpMethod method;
    private final String requestPath;
    private final int responseCode;
    private final long responseSize;
    private final String referer;
    private final UserAgentInfo userAgentInfo ;

    public LogEntry(String logLine) {
        // Регулярное выражение для парсинга строки лога
        String pattern = "^(\\d+) (\\S+) (\\S+ \\S+) (\\S+) (\\S+) (\\d+) (\\d+) (\\S+) \"([^\"]+)\"$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(logLine);

        if (m.find()) {
            UserAgent userAgentParser = new UserAgent();
            this.lineNumber = Integer.parseInt(m.group(1));
            this.ipAddr  = m.group(2);
            this.LocalDateTime  = m.group(3);
            this.method = HttpMethod.valueOf(m.group(4).toUpperCase());
            this.requestPath = m.group(5);
            this.responseCode= Integer.parseInt(m.group(6));
            this.responseSize = Long.parseLong(m.group(7));
            this.referer= m.group(8);
            this.userAgentInfo = userAgentParser.parse(m.group(9));

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
    public UserAgentInfo getUserAgent() { return userAgentInfo; }
    public int getResponseCode() { return responseCode; }
    public String getRequestPath() {return requestPath;}
    public int getLineNumber() {return lineNumber;}
}
