package org.damago.damagodatenbankapi.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component @ConfigurationProperties("app")
@Getter
@Setter
public class AppProperties {
    private boolean openBrowserAtStartup;
}