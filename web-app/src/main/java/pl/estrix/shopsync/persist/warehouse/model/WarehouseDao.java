package pl.estrix.shopsync.persist.warehouse.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;

@Entity
@Table(name = "warehouse",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id"})
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class WarehouseDao implements Serializable,Comparable<WarehouseDao> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lastupdate", length = 250, nullable = false)
    private String lastUpdate;

    @Column(name = "warehouse_name", length = 250, nullable = false)
    private String name;

    @Column(name = "warehouse_url", length = 250, nullable = false)
    private String url;

    @Column(name = "warehouse_api_url", length = 250, nullable = false)
    private String apiUrl;

    @Override
    public int compareTo(@NonNull WarehouseDao o) {
        return Comparator.comparing(WarehouseDao::getName)
                .thenComparing(WarehouseDao::getUrl)
                .thenComparing(WarehouseDao::getApiUrl)
                .compare(this, o);
    }
}
