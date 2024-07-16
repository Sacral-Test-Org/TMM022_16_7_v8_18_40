package com.project.tmm022_fmb.modules.hpms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PartMasterService {

    @Autowired
    private PartMasterRepository partMasterRepository;

    public List<PartMaster> getPartMasterDetails() {
        // Logic to retrieve details related to the PART_MASTER window
        return partMasterRepository.findAll();
    }

    public void initializeForm() {
        // Fetch the current date truncated to the day
        String currentDate = getSystemDate();
        // Initialize the global parameter to 0
        int globalParameter = 0;
        // Determine the mode based on the global parameter
        String mode = (globalParameter == 0) ? "Create Mode" : "Edit Mode";
        // Additional initialization logic if needed
    }

    public String getSystemDate() {
        // Fetch the current system date
        Date date = new Date();
        // Format the date to "DD-MON-RRRR"
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        return formatter.format(date);
    }

    public void validateAndSavePartDescription(String partDescription, String unitId, String unitName, String groupId, String groupName, String lineId, String lineDesc, int globalParameter) {
        // Validate the required fields
        if (partDescription == null || partDescription.isEmpty()) {
            throw new IllegalArgumentException("Part description is required");
        }
        if (unitId == null || unitId.isEmpty() || unitName == null || unitName.isEmpty()) {
            throw new IllegalArgumentException("Unit ID and Unit Name are required");
        }
        if (groupId == null || groupId.isEmpty() || groupName == null || groupName.isEmpty()) {
            throw new IllegalArgumentException("Group ID and Group Name are required");
        }
        if (lineId == null || lineId.isEmpty() || lineDesc == null || lineDesc.isEmpty()) {
            throw new IllegalArgumentException("Line ID and Line Description are required");
        }
        if (globalParameter == 0 && (partDescription == null || partDescription.isEmpty())) {
            throw new IllegalArgumentException("Part Number and Part Description are required in Create Mode");
        }
        if (globalParameter == 1 && (lineId == null || lineId.isEmpty())) {
            throw new IllegalArgumentException("Part ID must be selected from a list of values in Edit Mode");
        }
        // If validation passes, save the part description and update the part status to 'A'
        PartMaster partMaster = new PartMaster();
        partMaster.setPartDescription(partDescription);
        partMaster.setPartStatus("A");
        partMasterRepository.save(partMaster);
    }

    public void saveFormData(PartMaster formData) {
        // Save the form data to the database
        partMasterRepository.save(formData);
    }

    public void clearFormData() {
        // Clear the form data
        // Logic to clear form data
    }

    public void editFormData() {
        // Enable form editing
        // Logic to enable form editing
    }

    public void exitForm() {
        // Handle the form exit action
        // Logic to handle form exit
    }

    public List<GroupLov> getGroupLovData(int para, String unitId) {
        // Logic to fetch GROUP_LOV data based on the global parameter
        if (para == 0) {
            return partMasterRepository.findGroupLovData(unitId);
        } else {
            return partMasterRepository.findEditGroupLovData(unitId);
        }
    }

    public List<UnitLov> getUnitLovData(int para) {
        // Logic to fetch UNIT_LOV data based on the global parameter
        if (para == 0) {
            return partMasterRepository.findUnitLovData();
        } else {
            return partMasterRepository.findEditUnitLovData();
        }
    }

    public List<LineLov> getLineLovData(int para) {
        // Logic to fetch LINE_LOV data based on the global parameter
        if (para == 0) {
            return partMasterRepository.findLineLovData();
        } else {
            return partMasterRepository.findEditLineLovData();
        }
    }

    public boolean validateLineId(String unitId, String groupId, String lineId, String lineDesc, int para) {
        // Logic to validate the 'Line ID' and 'Line Description' for the given 'Unit ID' and 'Group ID'
        if (para == 0) {
            return partMasterRepository.validateLineId(unitId, groupId, lineId, lineDesc);
        } else {
            return partMasterRepository.validateEditLineId(unitId, groupId, lineId, lineDesc);
        }
    }

    public void clearForm() {
        // Clear all form fields without validating the current data
        // Enable the 'UNIT_ID' field if it is disabled
        // Set the 'PART_STATUS' field to 'A'
        // Execute the 'WHEN-NEW-FORM-INSTANCE' trigger
        // Logic to clear form fields and reinitialize
    }

    public void editPart() {
        // Clear the form fields
        // Reinitialize the form as a new instance
        // Set the part status to 'A'
        // Set a global parameter to 1
        // Update the mode based on the global parameter
        // Logic to edit part
    }
}
