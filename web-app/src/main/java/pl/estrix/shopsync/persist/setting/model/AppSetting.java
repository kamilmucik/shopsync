package pl.estrix.shopsync.persist.setting.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;

@Entity
@Table(name = "appsetting",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id"})
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class AppSetting implements Serializable,Comparable<AppSetting> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "setting_name", length = 250, nullable = false)
    private String name;

    @Column(name = "setting_code", length = 250, nullable = false)
    private String code;

    @Column(name = "setting_value", length = 250, nullable = false)
    private String value;

    @Column(name = "setting_type", length = 250, nullable = false)
    private String type;

    @Override
    public int compareTo(@NonNull AppSetting o) {
        return Comparator.comparing(AppSetting::getName)
                .thenComparing(AppSetting::getCode)
                .thenComparing(AppSetting::getValue)
                .thenComparing(AppSetting::getType)
                .compare(this, o);
    }
}
