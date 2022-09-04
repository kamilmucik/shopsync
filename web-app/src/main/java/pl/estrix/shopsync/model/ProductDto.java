package pl.estrix.shopsync.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.estrix.shopsync.commons.entity.BaseEntityDto;

import java.util.Objects;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductDto extends BaseEntityDto<Long> {


    private String name;

    private String mainImg;

    private String amount;

    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
