package jh.mastercloudapps.externalservice2.repository;

import jh.mastercloudapps.externalservice2.model.Translation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TranslationRepository extends ReactiveCrudRepository<Translation, Long> {

    Mono<Translation> findByIdIgnoreCase(String id);
}
