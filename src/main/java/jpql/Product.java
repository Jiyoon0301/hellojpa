package jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Product {

    @Id @GeneratedValue
    private Long id;
    private int orderAmount;

    @Embedded
    private Address address;
}
