package com.zkcloud.api.dbs.common.profile;

public class ClientProfile {
    private HttpProfile httpProfile;
    private Language language;

    public HttpProfile getHttpProfile() {
        return httpProfile;
    }

    public void setHttpProfile(HttpProfile httpProfile) {
        this.httpProfile = httpProfile;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public ClientProfile(HttpProfile httpProfile) {
        this(httpProfile, Language.EN);
    }

    public ClientProfile(HttpProfile httpProfile, Language language) {
        this.httpProfile = httpProfile;
        this.language = language;
    }

    public ClientProfile() {
        this(new HttpProfile());
    }
}
