package com.stepup.patterns;

//класс обёртка
public class LogEntry {
    private String ip;
    private String timestamp;
    private String request;
    private int statusCode;
    private long contentLength;
    private String referer;
    private String userAgent;

    public LogEntry(String ip, String timestamp, String request, int statusCode,
                    long contentLength, String referer, String userAgent) {
        this.ip = ip;
        this.timestamp = timestamp;
        this.request = request;
        this.statusCode = statusCode;
        this.contentLength = contentLength;
        this.referer = referer;
        this.userAgent = userAgent;
    }

    // Геттеры
    public String getIp() { return ip; }
    public String getTimestamp() { return timestamp; }
    public String getRequest() { return request; }
    public int getStatusCode() { return statusCode; }
    public long getContentLength() { return contentLength; }
    public String getReferer() { return referer; }
    public String getUserAgent() { return userAgent; }
}
