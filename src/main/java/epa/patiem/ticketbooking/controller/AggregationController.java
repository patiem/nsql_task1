package epa.patiem.ticketbooking.controller;

import epa.patiem.ticketbooking.service.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/stats")
public class AggregationController {

    @Autowired
    private AggregationService statisticsService;

    @GetMapping("/aggregations")
    public ResponseEntity<Map<String, Object>> displayAggregationResults() {
        Map<String, Object> results = statisticsService.getAggregatedData();
        return ResponseEntity.ok(results);
    }
}
