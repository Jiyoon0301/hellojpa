package jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="ORDERS") // Order가 예약어여서 table name ORDERS라고 보통 씀
public class Order {

    @Id @GeneratedValue
    private Long id;
    private int orderAmount;

    @Embedded // address class의 변수 쓰기
    private Address address;

    // Order에서만 Product를 바라보도록
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

}
