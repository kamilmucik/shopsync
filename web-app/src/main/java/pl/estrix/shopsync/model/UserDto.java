package pl.estrix.shopsync.model;

import lombok.*;
import pl.estrix.shopsync.commons.annotation.RemapId;
import pl.estrix.shopsync.commons.entity.BaseEntityDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto extends BaseEntityDto<String> {
    @RemapId(value = "productId", useSalt = false)
    private String id;

    @RemapId(value = "productId", useSalt = false)
    private String idMap;

    @NotNull
    @Size(min=2, max=30)
    private String userName;

    private String userLastname;

    @NotNull
    @Size(min=2, max=30)
    private String email;

    @NotNull
    @Size(min=2, max=30)
    private String password;

    private String role;

    private boolean enabled;

    private boolean locked;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto that = (UserDto) o;
        return Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userName);
    }
}
