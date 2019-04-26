package com.wissensalt.rnd.fj.account.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@ToString
@Getter
@Setter
@Document(collection = "account")
public class Account implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2531632269877216890L;

    @Id
    private ObjectId id;

    @Indexed(name = "userNameIndex", direction = IndexDirection.ASCENDING, unique = true)
    private String userName;

    @Indexed(unique = true)
    private String accountNumber;

    @Indexed(unique = true)
    private String emailAddress;

    @Indexed(unique = true)
    private String identityNumber;
}
