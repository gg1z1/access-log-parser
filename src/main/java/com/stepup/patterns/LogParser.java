package com.stepup.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    private static final Pattern IP_PATTERN =
            Pattern.compile("^(?<ip>\\S+)");
    private static final Pattern TIMESTAMP_PATTERN =
            Pattern.compile("\\[(?<timestamp>[^]]+)]");
    private static final Pattern REQUEST_PATTERN
            =  Pattern.compile("\"(?<request>[^\"]*)\"");
    private static final Pattern STATUS_CODE_PATTERN =
            Pattern.compile("(?<responseCode>\\d+)");
    private static final Pattern CONTENT_LENGTH_PATTERN =
            Pattern.compile("(?<responseSize>\\d+)");
    private static final Pattern REFERER_PATTERN =
            Pattern.compile("\"(?<referer>[^\"]*)\"");
    private static final Pattern USER_AGENT_PATTERN =
            Pattern.compile("\"(?<userAgent>[^\"]*)\"$");

    public LogEntry parseLogLine(String logLine) {
        try {
            String remainingLine = logLine;
            Integer lineNumber = Integer.parseInt(remainingLine.substring(0, remainingLine.indexOf(':')).trim());
            remainingLine = remainingLine.substring(remainingLine.indexOf(':') + 2).trim();

            // Парсим IP
            Matcher ipMatcher = IP_PATTERN.matcher(logLine);
            if (!ipMatcher.find()) throw new IllegalArgumentException("Не найден IP в строке: " + logLine);
            String ip = ipMatcher.group("ip");

            // Пропускаем два поля (user и session)
            remainingLine = remainingLine.substring(ipMatcher.end()).trim();

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

            String[] parts = request.split(" ");
            String methodString = parts[0];    // GET
            String requestPath = parts[1];     // путь
            String protocol = parts[2];    // HTTP/1.0

            // Преобразуем метод в enum
            HttpMethod method = HttpMethod.valueOf(methodString.toUpperCase());

            // Обновляем оставшуюся строку
            remainingLine = remainingLine.substring(requestMatcher.end()).trim();

            // Парсим responseCode
            Matcher statusCodeMatcher = STATUS_CODE_PATTERN.matcher(remainingLine);
            if (!statusCodeMatcher.find()) throw new IllegalArgumentException("Не найден responseCode в строке: " + logLine);
            int responseCode = Integer.parseInt(statusCodeMatcher.group("responseCode"));

            // Обновляем оставшуюся строку
            remainingLine = remainingLine.substring(statusCodeMatcher.end()).trim();

            // Парсим responseSize
            Matcher contentLengthMatcher = CONTENT_LENGTH_PATTERN.matcher(remainingLine);
            if (!contentLengthMatcher.find()) throw new IllegalArgumentException("Не найден responseSize в строке: " + logLine);
            long responseSize = Long.parseLong(contentLengthMatcher.group("responseSize"));

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

            return new LogEntry(String.format(
                    """
                            %d %s %s %s %s %d %d %s "%s\"""",
                    lineNumber,
                    ip,
                    timestamp,
                    method,
                    requestPath,
                    responseCode,
                    responseSize,
                    referer,
                    userAgent
            ));

//            return new LogEntry();
        } catch (IllegalArgumentException e) {
            // Перебрасываем конкретное сообщение об ошибке
            throw e;
        } catch (Exception e) {
            // Для других исключений добавляем контекст
            throw new IllegalArgumentException("Ошибка парсинга строки лога: " + logLine, e);
        }
    }
}
