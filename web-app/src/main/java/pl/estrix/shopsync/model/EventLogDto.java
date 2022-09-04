package pl.estrix.shopsync.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.estrix.shopsync.commons.entity.BaseEntityDto;

import java.util.Objects;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class EventLogDto extends BaseEntityDto<Long> {

    private String lastupdate;

    private String type;

    private String log;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventLogDto that = (EventLogDto) o;
        return Objects.equals(log, that.log);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), log);
    }
}
