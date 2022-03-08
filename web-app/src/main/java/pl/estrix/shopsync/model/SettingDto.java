package pl.estrix.shopsync.model;

import lombok.*;
import pl.estrix.shopsync.commons.entity.BaseEntityDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class SettingDto extends BaseEntityDto<Long> {

    private String name;
    private String type;
    private String code;
    @NotNull
    @Size(min=1)
    private String value;

}
