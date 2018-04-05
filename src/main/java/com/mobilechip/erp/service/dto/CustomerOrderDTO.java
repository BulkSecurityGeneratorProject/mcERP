package com.mobilechip.erp.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import com.mobilechip.erp.domain.enumeration.CustomerOrderStatus;

/**
 * A DTO for the CustomerOrder entity.
 */
public class CustomerOrderDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Instant dateOpened;

    private Instant datePaymentDue;

    private Long amount;

    private CustomerOrderStatus currentStatus;

    private Long cashFlowId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Instant dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Instant getDatePaymentDue() {
        return datePaymentDue;
    }

    public void setDatePaymentDue(Instant datePaymentDue) {
        this.datePaymentDue = datePaymentDue;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public CustomerOrderStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(CustomerOrderStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Long getCashFlowId() {
        return cashFlowId;
    }

    public void setCashFlowId(Long cashFlowId) {
        this.cashFlowId = cashFlowId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomerOrderDTO customerOrderDTO = (CustomerOrderDTO) o;
        if(customerOrderDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), customerOrderDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CustomerOrderDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", dateOpened='" + getDateOpened() + "'" +
            ", datePaymentDue='" + getDatePaymentDue() + "'" +
            ", amount=" + getAmount() +
            ", currentStatus='" + getCurrentStatus() + "'" +
            "}";
    }
}