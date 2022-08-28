package pl.estrix.shopsync.persist.shop.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;

@Entity
@Table(name = "shop",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id"})
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class ShopDao implements Serializable,Comparable<ShopDao> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lastupdate", length = 250, nullable = false)
    private String lastUpdate;

    @Column(name = "shop_name", length = 250, nullable = false)
    private String name;

    @Column(name = "shop_url", length = 250, nullable = false)
    private String url;

    @Column(name = "shop_api_url", length = 250, nullable = false)
    private String apiUrl;

    @Override
    public int compareTo(@NonNull ShopDao o) {
        return Comparator.comparing(ShopDao::getName)
                .thenComparing(ShopDao::getUrl)
                .thenComparing(ShopDao::getApiUrl)
                .compare(this, o);
    }
}
