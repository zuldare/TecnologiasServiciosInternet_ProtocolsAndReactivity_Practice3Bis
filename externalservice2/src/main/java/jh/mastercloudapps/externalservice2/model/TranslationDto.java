package jh.mastercloudapps.externalservice2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslationDto {

    private String id;
    private String translation;
}
