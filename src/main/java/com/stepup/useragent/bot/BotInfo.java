package com.stepup.useragent.bot;

public class BotInfo {
    private final String baseUserAgent;
    private final String botName;
    private final String botVersion;
    private final String botUrl;
    private final String description;

    public BotInfo(String baseUserAgent, String botName, String botVersion, String botUrl, String description) {
        this.baseUserAgent = baseUserAgent;
        this.botName = botName;
        this.botVersion = botVersion;
        this.botUrl = botUrl;
        this.description = description;
    }

    public String getBaseUserAgent() { return baseUserAgent; }
    public String getBotName() { return botName; }
    public String getBotVersion() { return botVersion; }

    @Override
    public String toString() {
        return String.format(
                """
                        UserAgent BOT:
                          Название бота: %s
                          Версия бота: %s
                          Исходная строка: %s
                        """,
                getBotName(),
                getBotVersion(),
                getBaseUserAgent()

        );
    }
}
