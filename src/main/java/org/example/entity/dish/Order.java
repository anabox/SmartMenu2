package org.example.entity.dish;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.user.UserWaiter;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"order_details"})
@EqualsAndHashCode(exclude = {"order_details"})
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

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetails> orderDetailsList = new ArrayList<>();

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private UserWaiter userWaiter;

}