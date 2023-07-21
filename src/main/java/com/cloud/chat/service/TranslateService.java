package com.cloud.chat.service;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;

@Service
public class TranslateService {

    public String translateText(String text, String targetLanguage) {
        Translate translate = TranslateOptions.newBuilder().build().getService();
        Detection detection = translate.detect(text);
        String detectedLanguage = detection.getLanguage();
        Translation translation = translate.translate(
                text,
                Translate.TranslateOption.sourceLanguage(detectedLanguage),
                Translate.TranslateOption.targetLanguage(targetLanguage));
        return translation.getTranslatedText();
    }
}

