package com.arslanesra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.rmi.server.UID;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;
    @Column(name = "ticket_number", nullable = false)
    @Builder.Default
    private String ticketNumber = UUID.randomUUID().toString();
    @Column(nullable = false)
    private String passengerName;
    @Column(nullable = false)
    private String cardNumber;
    private boolean cancelled = false;
    private boolean deleted = false;
}
