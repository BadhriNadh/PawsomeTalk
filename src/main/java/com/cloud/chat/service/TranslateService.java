package com.cloud.chat.service;

import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.springframework.stereotype.Service;

@Service
public class TranslateService {

    public String translateText(String text, String targetLanguage) {
        try {
            Translate translate = TranslateOptions.newBuilder().build().getService();
            Detection detection = translate.detect(text);
            String detectedLanguage = detection.getLanguage();
            Translation translation = translate.translate(
                    text,
                    Translate.TranslateOption.sourceLanguage(detectedLanguage),
                    Translate.TranslateOption.targetLanguage(targetLanguage));
            return translation.getTranslatedText();
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return text;
        }
    }
}

