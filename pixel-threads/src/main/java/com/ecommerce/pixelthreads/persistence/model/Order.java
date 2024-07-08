package com.ecommerce.pixelthreads.persistence.model;

import com.ecommerce.pixelthreads.persistence.enumeration.OrderState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<OrderProduct> orderProducts;

    @Enumerated(EnumType.STRING)
    private OrderState orderStatus;

    @ManyToOne
    private User user;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
