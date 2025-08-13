package com.stepup.useragent.browser;

public interface BrowserParser {
    boolean matches(String userAgent);
    BrowserInfo parse(String userAgent);
}
