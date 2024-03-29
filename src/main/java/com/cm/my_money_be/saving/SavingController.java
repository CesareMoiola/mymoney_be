package com.cm.my_money_be.saving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/saving")
@CrossOrigin(origins = "*")
public class SavingController {

    @Autowired
    SavingService savingService;

    /**
     * Get all savings owned by the user
     * @param userId User id
     * @return All user's savings
     */
    @GetMapping("/{userId}")
    public ResponseEntity<List<SavingDto>> getSavings(@PathVariable("userId") Long userId) {
        List<SavingDto> savings = savingService.getSavings(userId);
        return new ResponseEntity<>(savings, HttpStatus.OK);
    }

    /**
     * Create a new saving
     * @param userId User id
     * @param savingDto New saving
     * @return Http response
     */
    @PostMapping("/{userId}")
    public ResponseEntity<String> saveSaving(@PathVariable("userId") long userId, @RequestBody SavingDto savingDto) {
        savingService.saveSaving(userId, savingDto);
        return ResponseEntity.ok("Saving saved");
    }

    /**
     * Edit saving
     * @param savingDto Updated saving
     * @return Http response
     */
    @PutMapping("/")
    public ResponseEntity<String> updateSaving(@RequestBody SavingDto savingDto){
        savingService.updateSaving(savingDto);
        return ResponseEntity.ok("Saving updated");
    }

    /**
     * Delete a saving
     * @param savingId Saving id
     * @return Http response
     */
    @DeleteMapping("/{savingId}")
    public ResponseEntity<String> deleteSaving(@PathVariable("savingId") long savingId){
        savingService.deleteSaving(savingId);
        return ResponseEntity.ok("Saving deleted");
    }
}
