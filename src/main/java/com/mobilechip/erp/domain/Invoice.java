package com.mobilechip.erp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Invoice.
 */
@Entity
@Table(name = "invoice")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "date_issued", nullable = false)
    private Instant dateIssued;

    @Column(name = "amount_total")
    private Long amountTotal;

    @Column(name = "payment_due")
    private Integer paymentDue;

    @OneToOne
    @JoinColumn(unique = true)
    private CustomerOrder customerOrder;

    @OneToMany(mappedBy = "invoice")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Customer> customers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Invoice name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getDateIssued() {
        return dateIssued;
    }

    public Invoice dateIssued(Instant dateIssued) {
        this.dateIssued = dateIssued;
        return this;
    }

    public void setDateIssued(Instant dateIssued) {
        this.dateIssued = dateIssued;
    }

    public Long getAmountTotal() {
        return amountTotal;
    }

    public Invoice amountTotal(Long amountTotal) {
        this.amountTotal = amountTotal;
        return this;
    }

    public void setAmountTotal(Long amountTotal) {
        this.amountTotal = amountTotal;
    }

    public Integer getPaymentDue() {
        return paymentDue;
    }

    public Invoice paymentDue(Integer paymentDue) {
        this.paymentDue = paymentDue;
        return this;
    }

    public void setPaymentDue(Integer paymentDue) {
        this.paymentDue = paymentDue;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public Invoice customerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
        return this;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Invoice customers(Set<Customer> customers) {
        this.customers = customers;
        return this;
    }

    public Invoice addCustomer(Customer customer) {
        this.customers.add(customer);
        customer.setInvoice(this);
        return this;
    }

    public Invoice removeCustomer(Customer customer) {
        this.customers.remove(customer);
        customer.setInvoice(null);
        return this;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Invoice invoice = (Invoice) o;
        if (invoice.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), invoice.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Invoice{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", dateIssued='" + getDateIssued() + "'" +
            ", amountTotal=" + getAmountTotal() +
            ", paymentDue=" + getPaymentDue() +
            "}";
    }
}