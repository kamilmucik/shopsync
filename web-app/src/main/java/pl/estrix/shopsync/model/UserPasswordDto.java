package pl.estrix.shopsync.model;

import lombok.*;
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
public class UserPasswordDto extends BaseEntityDto {

    private String login;

    @NotNull
    @Size(min=2, max=30)
    private String oldPassword;
    @NotNull
    @Size(min=2, max=30)
    private String newPassword;
    @NotNull
    @Size(min=2, max=30)
    private String repeatPassword;
}
