package pl.estrix.shopsync.persist.user.model;
import lombok.*;
import pl.estrix.shopsync.persist.setting.model.AppSetting;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Comparator;

@Entity
@Table(name = "appuser",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id"}),
                @UniqueConstraint(columnNames = {"email"}, name = "uidx_user_email")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable,Comparable<User> {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 50)
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Size(min = 1, max = 50)
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Size(min = 1, max = 50)
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "password", length = 80)
    private String password;

    @Column(name = "is_enabled", columnDefinition="tinyint(1) default 1")
    private boolean enabled;

    @Column(name = "is_locked", columnDefinition="tinyint(1) default 1")
    private boolean locked;

    //    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", length = 20)
    private String role;

    @Override
    public int compareTo(@NonNull User o) {
        return Comparator.comparing(User::getFirstName)
                .thenComparing(User::getLastName)
                .thenComparing(User::getEmail)
                .thenComparing(User::getRole)
                .compare(this, o);
    }
}
