package pl.estrix.shopsync.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VersionSearchCriteriaDto {

    private String platform;

    private String search;

}
