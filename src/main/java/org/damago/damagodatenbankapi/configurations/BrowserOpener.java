package org.damago.damagodatenbankapi.configurations;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BrowserOpener {
    private final AppProperties appProperties;

    public BrowserOpener(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void openBrowser() {
        if (appProperties.isOpenBrowserAtStartup()) {
            String url = "http://localhost:8080/swagger-ui.html";
            Runtime rt = Runtime.getRuntime();
            try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
