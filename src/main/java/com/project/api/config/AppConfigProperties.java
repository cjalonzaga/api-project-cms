package com.project.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.project.api.props")
public class AppConfigProperties {

    private JwtConfig jwt;
    private CookieConfig cookie;

    public JwtConfig getJwt() {
        return jwt;
    }

    public void setJwt(JwtConfig jwt) {
        this.jwt = jwt;
    }

    public CookieConfig getCookie() {
        return cookie;
    }

    public void setCookie(CookieConfig cookie) {
        this.cookie = cookie;
    }

    public static class JwtConfig{
        private String secret;
        private Long expiresIn;

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public Long getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Long expiresIn) {
            this.expiresIn = expiresIn;
        }
    }

    public static class CookieConfig{
        private String name;
        private Long expiresIn;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Long expiresIn) {
            this.expiresIn = expiresIn;
        }
    }


}
