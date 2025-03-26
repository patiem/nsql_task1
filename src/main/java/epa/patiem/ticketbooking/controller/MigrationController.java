package epa.patiem.ticketbooking.controller;

import epa.patiem.ticketbooking.service.SqlToMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/migrate")
@RequiredArgsConstructor
public class MigrationController {

    private final SqlToMongoService migrationService;

    @GetMapping
    public ResponseEntity<String> migrate() {
        migrationService.migrate();
        return ResponseEntity.ok().body("Migration to MongoDb successful");
    }


}

