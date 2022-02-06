package pl.estrix.shopsync.commons.core.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class Attendance {

    /**
     * Information whether all data has been returned
     * <ul>
     * <li>STANDARD - Data not need sensitive protection, all data returned,</li>
     * <li>MIX  - Data not need sensitive protection, part data returned, system was removed sensitive data,</li>
     * <li>SENSITIVE - System not return data, to read the hidded data you must authorize access;</li>
     * </ul>
     */
    private String care;

    /**
     * Lower time limit
     */
    private Date below;
}




