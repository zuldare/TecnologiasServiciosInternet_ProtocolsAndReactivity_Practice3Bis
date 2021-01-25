package jh.mastercloudapps.externalservice2.controller;

import jh.mastercloudapps.externalservice2.model.TranslationDto;
import jh.mastercloudapps.externalservice2.service.TranslateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/translation")
public class TranslateController {

    private TranslateService translateService;

    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @GetMapping("/{word}")
    public Mono<TranslationDto> getTranslation(@PathVariable String word){
        return translateService.getTranslation(word);
    }
}
