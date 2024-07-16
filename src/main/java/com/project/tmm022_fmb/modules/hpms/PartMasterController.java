package com.project.tmm022_fmb.modules.hpms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartMasterController {

    @Autowired
    private PartMasterService partMasterService;

    @GetMapping("/part-master/window")
    public ResponseEntity<?> getPartMasterWindow() {
        // Logic to retrieve the PART_MASTER window
        return ResponseEntity.ok("PART_MASTER window data");
    }

    @GetMapping("/part-master/initialize")
    public ResponseEntity<?> initializeForm() {
        // Logic to initialize the form
        return ResponseEntity.ok(partMasterService.initializeForm());
    }

    @GetMapping("/part-master/system-date")
    public ResponseEntity<?> getSystemDate() {
        // Logic to get the current system date
        return ResponseEntity.ok(partMasterService.getSystemDate());
    }

    @PostMapping("/part-master/validate-save")
    public ResponseEntity<?> validateAndSavePartDescription(@RequestBody PartDescriptionRequest request) {
        // Logic to validate and save the part description
        return ResponseEntity.ok(partMasterService.validateAndSavePartDescription(request));
    }

    @PostMapping("/part-master/save")
    public ResponseEntity<?> saveFormData(@RequestBody FormData formData) {
        // Logic to save the form data
        return ResponseEntity.ok(partMasterService.saveFormData(formData));
    }

    @PostMapping("/part-master/clear")
    public ResponseEntity<?> clearFormData() {
        // Logic to clear the form data
        return ResponseEntity.ok(partMasterService.clearFormData());
    }

    @PostMapping("/part-master/edit")
    public ResponseEntity<?> editFormData() {
        // Logic to enable form editing
        return ResponseEntity.ok(partMasterService.editFormData());
    }

    @PostMapping("/part-master/exit")
    public ResponseEntity<?> exitForm() {
        // Logic to handle form exit action
        return ResponseEntity.ok(partMasterService.exitForm());
    }

    @GetMapping("/part-master/group-lov")
    public ResponseEntity<?> getGroupLovData(@RequestParam int para, @RequestParam String unitId) {
        // Logic to get the LOV data for group
        return ResponseEntity.ok(partMasterService.getGroupLovData(para, unitId));
    }

    @GetMapping("/part-master/unit-lov")
    public ResponseEntity<?> getUnitLovData(@RequestParam int para) {
        // Logic to get the LOV data for unit
        return ResponseEntity.ok(partMasterService.getUnitLovData(para));
    }

    @GetMapping("/part-master/line-lov")
    public ResponseEntity<?> getLineLovData(@RequestParam int para) {
        // Logic to get the LOV data for line
        return ResponseEntity.ok(partMasterService.getLineLovData(para));
    }

    @GetMapping("/part-master/validate-line-id")
    public ResponseEntity<?> validateLineId(@RequestParam String unitId, @RequestParam String groupId, @RequestParam String lineId, @RequestParam String lineDesc, @RequestParam int para) {
        // Logic to validate the line ID
        return ResponseEntity.ok(partMasterService.validateLineId(unitId, groupId, lineId, lineDesc, para));
    }
}
