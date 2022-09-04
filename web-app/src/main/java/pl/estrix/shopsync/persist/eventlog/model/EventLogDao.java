package pl.estrix.shopsync.persist.eventlog.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;

@Entity
@Table(name = "event_log",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id"})
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class EventLogDao implements Serializable,Comparable<EventLogDao> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lastupdate", length = 250, nullable = false)
    private String lastupdate;

    @Column(name = "event_type", length = 250, nullable = false)
    private String type;

    @Column(name = "event_message", length = 250, nullable = false)
    private String log;


    @Override
    public int compareTo(@NonNull EventLogDao o) {
        return Comparator.comparing(EventLogDao::getType)
                .thenComparing(EventLogDao::getLog)
                .compare(this, o);
    }
}
