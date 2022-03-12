package pl.estrix.shopsync.model;

import lombok.*;
import pl.estrix.shopsync.commons.entity.BaseEntityDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SettingDto that = (SettingDto) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
