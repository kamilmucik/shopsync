package pl.estrix.shopsync.persist.product.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;

@Entity
@Table(name = "product",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id"})
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class ProductDao implements Serializable,Comparable<ProductDao> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lastupdate", length = 250, nullable = false)
    private String lastUpdate;

    @Column(name = "prod_name", length = 250, nullable = false)
    private String name;

    @Column(name = "prod_main_img", length = 250, nullable = false)
    private String mainImg;

    @Column(name = "prod_amount", length = 250, nullable = false)
    private String amount;

    @Column(name = "prod_description", length = 250, nullable = false)
    private String description;

    @Override
    public int compareTo(@NonNull ProductDao o) {
        return Comparator.comparing(ProductDao::getName)
                .compare(this, o);
    }
}
