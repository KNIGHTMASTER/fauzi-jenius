package com.wissensalt.rnd.fj.sec.oauth2.data.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2/27/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <KEY>
 */
@Getter
@Setter
@MappedSuperclass
public abstract class KFBaseData<KEY extends Serializable> implements ISingleKeyDATA<KEY>, Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 4549009572971596811L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name= "id", nullable = false)
    private KEY id;

    @CreatedBy
    @Column(name= "created_by", length=150)
    @Size(max = 150)
    protected String createdBy;

    @CreatedDate
    @Column(name = "created_on", nullable = false, updatable = false)
    protected Date createdOn;

    @LastModifiedBy
    @Column(name = "updated_by", length = 150)
    protected String modifiedBy;

    @LastModifiedDate
    @Column(name = "updated_on")
    protected Date modifiedOn;

    @Override
    public KEY getId() {
        return id;
    }
}
