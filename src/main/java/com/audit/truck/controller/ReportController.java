package com.audit.truck.controller;

import com.audit.truck.service.PdfReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin
public class ReportController {

    private final PdfReportService pdfReportService;

    public ReportController(PdfReportService pdfReportService) {
        this.pdfReportService = pdfReportService;
    }

    @GetMapping("/weekly")
    public ResponseEntity<byte[]> getWeeklyReport(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) throws Exception {

        byte[] pdf = pdfReportService.generateWeeklyReport(start, end);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=weekly-report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }



}
