package pl.estrix.shopsync.model;

import lombok.*;
import pl.estrix.shopsync.commons.entity.BaseEntityDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
public class VersionDto extends BaseEntityDto {

    private Long id;

    @NotNull(message = "Choose the subject count you are going to study!")
    @Size(min=2, max=30)
    private String number;

    @NotNull
    @Size(min=2, max=30)
    private String enviroment;

    private Date date;

    @NotNull
    @Size(min=2, max=30)
    private String installer;

    @NotNull
    @Size(min=2, max=30)
    private String description;

    @NotNull
    @Size(min=2, max=30)
    private String platform;

    public VersionDto() {
        super();
    }

}
