package pl.estrix.shopsync.persist.packages.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "app_version")
@SuppressWarnings("serial")
public class VersionEntry implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "enviroment", nullable = false)
    private String enviroment;

//    @Column(name = "date", nullable = false)
//    private Date date;

    @Column(name = "installer", nullable = false)
    private String installer;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "platform", nullable = false)
    private String platform;

}
