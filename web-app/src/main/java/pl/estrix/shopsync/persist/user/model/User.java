package pl.estrix.shopsync.persist.user.model;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "app_user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id"}),
                @UniqueConstraint(columnNames = {"email"}, name = "uidx_user_email")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

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

    @Column(name = "is_enabled")
    private boolean enabled;

    @Column(name = "is_locked")
    private boolean locked;

    //    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", length = 20)
    private String role;
}
