package pl.estrix.shopsync.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventLogSearchCriteriaDto {

    private String search;
}
