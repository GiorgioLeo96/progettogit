package com.example.progettogit.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Temporal(TemporalType.TIMESTAMP) // Se non passo valori, default data e ora istantanei
    private LocalDateTime timeDep;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timeArr;

    @ManyToOne
    private Airport depAirport;

    @ManyToOne
    private Airport arrAirport;

    public Flight() {
    }

    public Flight(LocalDateTime timeDep, LocalDateTime timeArr, Airport depAirport, Airport arrAirport) {
        this.timeDep = timeDep;
        this.timeArr = timeArr;
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeDep() {
        return timeDep;
    }

    public void setTimeDep(LocalDateTime timeDep) {
        this.timeDep = timeDep;
    }

    public LocalDateTime getTimeArr() {
        return timeArr;
    }

    public void setTimeArr(LocalDateTime timeArr) {
        this.timeArr = timeArr;
    }

    public Airport getDepAirport() {
        return depAirport;
    }

    public void setDepAirport(Airport depAirport) {
        this.depAirport = depAirport;
    }

    public Airport getArrAirport() {
        return arrAirport;
    }

    public void setArrAirport(Airport arrAirport) {
        this.arrAirport = arrAirport;
    }

}
