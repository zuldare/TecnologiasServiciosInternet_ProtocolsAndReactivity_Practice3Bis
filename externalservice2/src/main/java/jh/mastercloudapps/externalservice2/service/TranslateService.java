package jh.mastercloudapps.externalservice2.service;

import jh.mastercloudapps.externalservice2.model.Translation;
import jh.mastercloudapps.externalservice2.model.TranslationDto;
import jh.mastercloudapps.externalservice2.repository.TranslationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;

@Service
@Slf4j
public class TranslateService {

    private static final String UNKNOWN = "unknown";
    private TranslationRepository translationRepository;

    public TranslateService(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public Mono<TranslationDto> getTranslation(String word) {
        log.info("Getting translation for word: {}", word);

        return this.translationRepository.findByIdIgnoreCase(word)
                .delayElement(Duration.ofSeconds(1))
                .map(translation -> TranslationDto.builder()
                        .id(translation.getId())
                        .translation(translation.getTranslation())
                        .build())
                .switchIfEmpty(Mono.just(TranslationDto.builder()
                        .id(word)
                        .translation(UNKNOWN)
                        .build()));

    }

}
