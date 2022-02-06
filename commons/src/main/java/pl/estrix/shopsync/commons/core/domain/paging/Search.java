package pl.estrix.shopsync.commons.core.domain.paging;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Search {

    private String value;
    private String regexp;
}