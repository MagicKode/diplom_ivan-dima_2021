package tms.diplom_ivan_dima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MoneyEvent {

    private long id;
    private long userId;
    private String date;
    private BigDecimal sum;
    private String cathegory;
    private MoneyEventType moneyEventType;
}
