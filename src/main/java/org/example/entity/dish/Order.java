package org.example.entity.dish;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.user.UserWaiter;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderDetails"})
@EqualsAndHashCode(exclude = {"orderDetails"})
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @UpdateTimestamp
    @Column(name = "order_date_time")
    private LocalDateTime orderDateTime;

    @Column (name = "sum")
    private double sum;

    @Column (name = "table_num")
    private int tableNum;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_details_id", referencedColumnName = "id")
    private OrderDetails orderDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserWaiter userWaiter;

}