package com.wissensalt.rnd.fj.sec.oauth2.data.auditor;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AAuditTrail extends ABaseAuditTrail {
	/**
	 *
	 * 
	 */
	private static final long serialVersionUID = -5401587542468260575L;

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@Transient
	private AppAuditorAware auditorAware;

	public AAuditTrail() {
		auditorAware = new AppAuditorAware();
	}

	/**
	 *
	 * <p>Before persist data into Database</p>
	 */
	/*@PrePersist
	public void onPrePersist(){
		setCreatedBy(auditorAware.getCurrentAuditor());
		setStatus(CommonConstant.GeneralValue.ONE);
		setCreatedOn(new Date());
	}*/

	/**
	 *
	 * <p>Before update data into db</p>
	 */
	/*@PreUpdate
	public void onPreUpdate(){
		setModifiedBy(auditorAware.getCurrentAuditor());
		setModifiedOn(new Date());
	}*/
}
