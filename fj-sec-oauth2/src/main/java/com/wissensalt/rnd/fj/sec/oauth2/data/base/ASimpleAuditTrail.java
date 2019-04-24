package com.wissensalt.rnd.fj.sec.oauth2.data.base;

import com.wissensalt.rnd.fj.sec.oauth2.data.auditor.AppAuditorAware;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Created on 2/27/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class ASimpleAuditTrail extends KFBaseData<Long> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5338452813229316294L;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Transient
    private AppAuditorAware auditorAware;

    public ASimpleAuditTrail() {
        auditorAware = new AppAuditorAware();
    }
}
