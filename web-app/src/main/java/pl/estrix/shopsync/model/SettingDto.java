package pl.estrix.shopsync.model;

import lombok.*;
import pl.estrix.shopsync.commons.entity.BaseEntityDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SettingDto extends BaseEntityDto<Long> {

    private String name;
    private String type;
    private String code;
    @NotNull
    @Size(min=1)
    private String value;

    @Builder
    public SettingDto(Long id, String label, LocalDate dateCreate, LocalTime timeCreate, LocalDateTime lastUpdated, String name, String type, String code, String value) {
//        super(id, label, dateCreate, timeCreate, lastUpdated);
        this.name = name;
        this.type = type;
        this.code = code;
        this.value = value;
    }
}
