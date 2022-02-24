package pl.estrix.shopsync.model;

import lombok.*;
import pl.estrix.shopsync.commons.annotation.RemapId;
import pl.estrix.shopsync.commons.entity.BaseEntityDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto extends BaseEntityDto<Long> {

    private Long id;

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

}
