package com.mobilechip.erp.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import com.mobilechip.erp.domain.enumeration.CashFlowDirection;
import com.mobilechip.erp.domain.enumeration.CashFlowType;
import com.mobilechip.erp.domain.enumeration.CashFlowStatus;

/**
 * A DTO for the CashFlow entity.
 */
public class CashFlowDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant datePayment;

    @NotNull
    private CashFlowDirection direction;

    @NotNull
    private CashFlowType type;

    @NotNull
    private Long amount;

    private String description;

    @NotNull
    private CashFlowStatus currentStatus;

    private Long purchaseOrderId;

    private String purchaseOrderName;

    private Long customerOrderId;

    private String customerOrderName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Instant datePayment) {
        this.datePayment = datePayment;
    }

    public CashFlowDirection getDirection() {
        return direction;
    }

    public void setDirection(CashFlowDirection direction) {
        this.direction = direction;
    }

    public CashFlowType getType() {
        return type;
    }

    public void setType(CashFlowType type) {
        this.type = type;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CashFlowStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(CashFlowStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getPurchaseOrderName() {
        return purchaseOrderName;
    }

    public void setPurchaseOrderName(String purchaseOrderName) {
        this.purchaseOrderName = purchaseOrderName;
    }

    public Long getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(Long customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getCustomerOrderName() {
        return customerOrderName;
    }

    public void setCustomerOrderName(String customerOrderName) {
        this.customerOrderName = customerOrderName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CashFlowDTO cashFlowDTO = (CashFlowDTO) o;
        if(cashFlowDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), cashFlowDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CashFlowDTO{" +
            "id=" + getId() +
            ", datePayment='" + getDatePayment() + "'" +
            ", direction='" + getDirection() + "'" +
            ", type='" + getType() + "'" +
            ", amount=" + getAmount() +
            ", description='" + getDescription() + "'" +
            ", currentStatus='" + getCurrentStatus() + "'" +
            "}";
    }
}
