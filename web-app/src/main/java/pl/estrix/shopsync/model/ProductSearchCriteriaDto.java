package pl.estrix.shopsync.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSearchCriteriaDto {

    private String search;
}
