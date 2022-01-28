package pl.estrix.shopsync.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.estrix.shopsync.commons.entity.BaseEntityDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
//@EqualsAndHashCode(callSuper = true)
@ToString
public class SettingDto extends BaseEntityDto<Long> {

    private String name;
    private String type;
    private String code;
    private String value;

    @Builder
    public SettingDto(Long id, String label, LocalDate dateCreate, LocalTime timeCreate, LocalDateTime lastUpdated, String name, String type, String code, String value) {
        super(id, label, dateCreate, timeCreate, lastUpdated);
        this.name = name;
        this.type = type;
        this.code = code;
        this.value = value;
    }
}
