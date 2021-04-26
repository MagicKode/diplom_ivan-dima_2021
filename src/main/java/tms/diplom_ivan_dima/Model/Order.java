package tms.diplom_ivan_dima.Model;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // универсальный инкремент для ID.
    private long id;
    private OrderStatus orderStatus; // статус товара

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> productList;

    @ManyToOne
    private User user;


    private String startData; //дата поступления заказа
    private String endData; // дата отгрузки
    private LocalDate date; // дата


}
