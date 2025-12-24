package com.audit.truck.service;

import com.audit.truck.entity.Expense;
import com.audit.truck.entity.Trip;
import com.audit.truck.repo.TripRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PdfReportService {

    private final TripRepository tripRepository;

    public PdfReportService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public byte[] generateWeeklyReport(LocalDate start, LocalDate end) throws Exception {

        List<Trip> trips = tripRepository.findByTripDateBetween(start, end);

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();
        document.add(new Paragraph("Truck Weekly Report"));
        document.add(new Paragraph("From " + start + " To " + end));
        document.add(new Paragraph(" "));

        BigDecimal totalExpense = BigDecimal.ZERO;

        for (Trip trip : trips) {
            document.add(new Paragraph("Date: " + trip.getTripDate()));
            document.add(new Paragraph("Route: " +
                    trip.getSourceLocation() + " → " + trip.getDestinationLocation()));
            document.add(new Paragraph("Material: " + trip.getMaterialCarried()));

            for (Expense expense : trip.getExpenses()) {
                document.add(new Paragraph(
                        " - " + expense.getExpenseType() + ": ₹" + expense.getAmount()));
                totalExpense = totalExpense.add(expense.getAmount());
            }

            document.add(new Paragraph(" "));
        }

        document.add(new Paragraph("--------------------------------"));
        document.add(new Paragraph("Total Expense: ₹" + totalExpense));

        document.close();
        return out.toByteArray();
    }
}
