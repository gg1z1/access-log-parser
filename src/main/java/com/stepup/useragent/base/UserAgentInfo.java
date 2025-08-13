package com.stepup.useragent.base;

import com.stepup.useragent.bot.BotInfo;
import com.stepup.useragent.browser.BrowserInfo;

public class UserAgentInfo {
    private final BrowserInfo browserInfo;
    private final BotInfo botInfo;

    public UserAgentInfo(BrowserInfo browserInfo, BotInfo botInfo) {
        this.browserInfo = browserInfo;
        this.botInfo = botInfo;
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public BotInfo getBotInfo() {
        return botInfo;
    }

    public boolean hasBrowser() {
        return browserInfo != null;
    }

    public boolean hasBot() {
        return botInfo != null;
    }

    public boolean isUnknown() {
        return browserInfo == null && botInfo == null;
    }
}
