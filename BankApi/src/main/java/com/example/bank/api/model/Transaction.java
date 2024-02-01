package com.example.bank.api.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Entity
@Table(name="transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "source_account_id", referencedColumnName = "id")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "target_account_id", referencedColumnName = "id")
    private Account targetAccount;


    private BigDecimal amount;


   private String currency;

}
