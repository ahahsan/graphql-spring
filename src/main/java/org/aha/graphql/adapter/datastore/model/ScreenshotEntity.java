package org.aha.graphql.adapter.datastore.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "screenshot")
@DynamicInsert
@DynamicUpdate
public class ScreenshotEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Column(name = "title")
    private String title;

    @Column(name = "locale", nullable = false)
    private String locale;

    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "image1x_id", nullable = false)
    private ImageEntity imageIx;

    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "image2x_id", nullable = false)
    private ImageEntity image2x;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified")
    private Date lastModified;
}
