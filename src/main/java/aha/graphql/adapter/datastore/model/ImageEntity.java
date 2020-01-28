package aha.graphql.adapter.datastore.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "image")
@DynamicUpdate
@DynamicInsert
public class ImageEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="resolution", nullable = false)
    private String resolution;

    @Column(name="location", nullable = false)
    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on",  nullable = false)
    private Date createdOn;

}
