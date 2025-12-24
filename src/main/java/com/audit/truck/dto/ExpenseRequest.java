package com.audit.truck.dto;

import com.audit.truck.entity.ExpenseType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseRequest {

    private ExpenseType expenseType;
    private BigDecimal amount;
    private LocalDate expenseDate;
    private String notes;

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
