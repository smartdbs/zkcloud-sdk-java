package com.zkcloud.api.dbs.common.profile;

import cn.hutool.core.util.StrUtil;

public enum Language {
    ZH_CN("zh-CN"),
    EN("en");

    private final String lang;

    Language(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return this.lang;
    }

    public String getValue() {
        return this.lang;
    }

    public static Language getByLang(String lang) {
        if (StrUtil.isBlank(lang)) {
            return null;
        }
        for (Language language : values()) {
            if (language.getValue().equalsIgnoreCase(lang)) {
                return language;
            }
        }
        return null;
    }

}
