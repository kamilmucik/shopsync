package pl.estrix.shopsync.model;

import lombok.*;
import pl.estrix.shopsync.commons.entity.BaseEntityDto;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlatformDto extends BaseEntityDto {

    private Long id;

    private String name;

    private String code;
}
