package pl.estrix.shopsync.commons.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class PagingCriteria {

    Integer page;
    int start;
    Integer limit;
    String orderColumn;
    String orderDir;

    /**
     * @return empty immutable instance of PagingCriteria
     */
    public static PagingCriteria empty() {
        return EMPTY;
    }

    private static final PagingCriteria EMPTY = new PagingCriteria() {

        private final RuntimeException uOpException = new UnsupportedOperationException("This is an immutable instance of PagingCriteria");

        public void setLimit(Integer limit) {
            throw uOpException;
        };

        public void setPage(Integer page) {
            throw uOpException;
        };

        public void setStart(int start) {
            throw uOpException;
        };

    };
}

