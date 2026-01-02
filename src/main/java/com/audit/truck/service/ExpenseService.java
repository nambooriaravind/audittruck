package com.audit.truck.service;

import com.audit.truck.dto.ExpenseRequest;
import com.audit.truck.entity.Expense;
import com.audit.truck.entity.Trip;
import com.audit.truck.repo.ExpenseRepository;
import com.audit.truck.repo.TripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ExpenseService {

    private final TripRepository tripRepository;
    private final ExpenseRepository expenseRepository;

    public ExpenseService(TripRepository tripRepository,
                          ExpenseRepository expenseRepository) {
        this.tripRepository = tripRepository;
        this.expenseRepository = expenseRepository;
    }

    public Expense addExpense(Long tripId, ExpenseRequest request) {

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        Expense expense = new Expense();
        expense.setTrip(trip);
        expense.setExpenseType(request.getExpenseType());
        expense.setAmount(request.getAmount());
        expense.setExpenseDate(
                request.getExpenseDate() != null ? request.getExpenseDate() : LocalDate.now()
        );
        expense.setNotes(request.getNotes());

        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long expenseId, Expense updatedExpense) {
        Expense existing = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        existing.setExpenseType(updatedExpense.getExpenseType());
        existing.setAmount(updatedExpense.getAmount());
        existing.setExpenseDate(updatedExpense.getExpenseDate());
        existing.setNotes(updatedExpense.getNotes());

        return expenseRepository.save(existing);
    }

}
