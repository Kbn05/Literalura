package com.kbnproject.literalura.model;

import java.util.List;

public enum ELanguage {
    ENGLISH("en"),
    SPANISH("es"),
    FRENCH("fr"),
    HUNGARIAN("hu"),
    FINLAND("fi"),
    CATALAN("ca");

    private String language;

    ELanguage(String language){
        this.language = language;
    }

    public static ELanguage fromJson(String language) {
        for (ELanguage eLanguage : ELanguage.values()) {
            if (eLanguage.language.equalsIgnoreCase(language)) {
                return eLanguage;
            }
        }
        throw new IllegalArgumentException("Language not found: " + language);
//        return null;
    }
}
