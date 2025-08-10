package com.stepup.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    private static final Pattern IP_PATTERN = Pattern.compile("^(?<ip>\\S+)");
    private static final Pattern TIMESTAMP_PATTERN = Pattern.compile("\\[(?<timestamp>[^\\]]+)\\]");
    private static final Pattern REQUEST_PATTERN = Pattern.compile("\"(?<request>[^\"]*)\"");
    private static final Pattern STATUS_CODE_PATTERN = Pattern.compile("(?<statusCode>\\d+)");
    private static final Pattern CONTENT_LENGTH_PATTERN = Pattern.compile("(?<contentLength>\\d+)");
    private static final Pattern REFERER_PATTERN = Pattern.compile("\"(?<referer>[^\"]*)\"");
    private static final Pattern USER_AGENT_PATTERN = Pattern.compile("\"(?<userAgent>[^\"]*)\"$");

    public LogEntry parseLogLine(String logLine) {
        try {
            // Парсим IP
            Matcher ipMatcher = IP_PATTERN.matcher(logLine);
            if (!ipMatcher.find()) throw new IllegalArgumentException("Не найден IP в строке: " + logLine);
            String ip = ipMatcher.group("ip");

            // Пропускаем два поля (user и session)
            String remainingLine = logLine.substring(ipMatcher.end()).trim();

            // Парсим timestamp
            Matcher timestampMatcher = TIMESTAMP_PATTERN.matcher(remainingLine);
            if (!timestampMatcher.find()) throw new IllegalArgumentException("Не найден timestamp в строке: " + logLine);
            String timestamp = timestampMatcher.group("timestamp");

            // Обновляем оставшуюся строку
            remainingLine = remainingLine.substring(timestampMatcher.end()).trim();

            // Парсим request
            Matcher requestMatcher = REQUEST_PATTERN.matcher(remainingLine);
            if (!requestMatcher.find()) throw new IllegalArgumentException("Не найден request в строке: " + logLine);
            String request = requestMatcher.group("request");

            // Обновляем оставшуюся строку
            remainingLine = remainingLine.substring(requestMatcher.end()).trim();

            // Парсим statusCode
            Matcher statusCodeMatcher = STATUS_CODE_PATTERN.matcher(remainingLine);
            if (!statusCodeMatcher.find()) throw new IllegalArgumentException("Не найден statusCode в строке: " + logLine);
            int statusCode = Integer.parseInt(statusCodeMatcher.group("statusCode"));

            // Обновляем оставшуюся строку
            remainingLine = remainingLine.substring(statusCodeMatcher.end()).trim();

            // Парсим contentLength
            Matcher contentLengthMatcher = CONTENT_LENGTH_PATTERN.matcher(remainingLine);
            if (!contentLengthMatcher.find()) throw new IllegalArgumentException("Не найден contentLength в строке: " + logLine);
            long contentLength = Long.parseLong(contentLengthMatcher.group("contentLength"));

            // Обновляем оставшуюся строку
            remainingLine = remainingLine.substring(contentLengthMatcher.end()).trim();

            // Парсим referer
            Matcher refererMatcher = REFERER_PATTERN.matcher(remainingLine);
            if (!refererMatcher.find()) throw new IllegalArgumentException("Не найден referer в строке: " + logLine);
            String referer = refererMatcher.group("referer");

            // Обновляем оставшуюся строку
            remainingLine = remainingLine.substring(refererMatcher.end()).trim();

            // Парсим userAgent
            Matcher userAgentMatcher = USER_AGENT_PATTERN.matcher(remainingLine);
            if (!userAgentMatcher.find()) throw new IllegalArgumentException("Не найден userAgent в строке: " + logLine);
            String userAgent = userAgentMatcher.group("userAgent");

            return new LogEntry(
                    ip,
                    timestamp,
                    request,
                    statusCode,
                    contentLength,
                    referer,
                    userAgent
            );
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка парсинга строки лога: " + logLine, e);
        }
    }
}
