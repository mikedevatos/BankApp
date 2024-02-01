package com.example.bank.api.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name ="Account")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "sourceAccount")
    private Set<Transaction> sourceTransactions;

    private BigDecimal balance;

    private String currency;

    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

}
