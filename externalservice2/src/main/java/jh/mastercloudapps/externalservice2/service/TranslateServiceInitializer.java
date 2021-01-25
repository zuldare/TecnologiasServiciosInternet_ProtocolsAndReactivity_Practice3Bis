package jh.mastercloudapps.externalservice2.service;

import jh.mastercloudapps.externalservice2.model.Translation;
import jh.mastercloudapps.externalservice2.repository.TranslationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class TranslateServiceInitializer {

    private TranslationRepository translationRepository;

    public TranslateServiceInitializer(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    @PostConstruct
    public void populateService(){
        log.info("Deleting previous database information");
        this.translationRepository.deleteAll();

        Flux<Translation> translations = Flux.just(
                Translation.builder().id("hola").translation("hi").build(),
                Translation.builder().id("adios").translation("bye").build(),
                Translation.builder().id("suerte").translation("luck").build(),
                Translation.builder().id("cielo").translation("sky").build()
        );

        translations
                .flatMap(t-> this.translationRepository.save(t))
                .blockLast();
        log.info("Database populated with data");
    }
}
