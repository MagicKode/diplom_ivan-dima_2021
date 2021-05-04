package tms.diplom_ivan_dima.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private OrderStatus orderStatus;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> productList;

    @ManyToOne
    private User user;


    private String startData;
    private String endData;
    private LocalDate date;


}
