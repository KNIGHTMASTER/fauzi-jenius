package com.wissensalt.rnd.fj.sec.oauth2.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wissensalt.rnd.fj.sec.oauth2.data.auditor.AAuditTrail;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 1/3/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Where(clause = "status=true")
@Getter
@Setter
@Entity
@Table(name = "sec_role")
public class Role extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6493012093767231395L;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
