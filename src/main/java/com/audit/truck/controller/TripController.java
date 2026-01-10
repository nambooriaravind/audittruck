package com.audit.truck.controller;

import com.audit.truck.dto.ExpenseRequest;
import com.audit.truck.dto.TripRequest;
import com.audit.truck.entity.Expense;
import com.audit.truck.entity.Trip;
import com.audit.truck.service.ExpenseService;
import com.audit.truck.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin(origins = "http://localhost:3001")
public class TripController {

    private final TripService tripService;
    private final ExpenseService expenseService;

    public TripController(TripService tripService,
                          ExpenseService expenseService) {
        this.tripService = tripService;
        this.expenseService = expenseService;
    }

    @PostMapping
    public Trip createTrip(@RequestBody TripRequest request) {
        return tripService.createTrip(request);
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public Trip getTrip(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    @PostMapping("/{id}/expenses")
    public Expense addExpense(@PathVariable Long id,
                              @RequestBody ExpenseRequest request) {
        return expenseService.addExpense(id, request);
    }

    @PutMapping("/expenses/{expenseId}")
    public Expense updateExpense(
            @PathVariable Long expenseId,
            @RequestBody Expense updatedExpense) {

        return expenseService.updateExpense(expenseId, updatedExpense);
    }
    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }


}
