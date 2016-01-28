package autorepair;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    // Persistent Fields:
    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "name")
    private String name;
    @Column(name = "signingdate")
    private Date signingDate;
    @Column(name = "email")
    private String email;
    @Column(name = "telephonenumber")
    private String telephoneNumber;
    // Constructors:
    public Client() {
        /*nop*/
    }

    public Client(String firstName, String lastName, String email, String telephoneNumber) {
        this.name = firstName + " " + lastName;
        this.signingDate = new Date(System.currentTimeMillis());
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }

    // Вывыдом на страничцу :
    @Override
    public String toString() {
        return name + " " + email + " " + telephoneNumber + " (Добавлен :" + signingDate + ")";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}