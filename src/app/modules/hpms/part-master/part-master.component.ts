import { Component, OnInit } from '@angular/core';
import { PartMasterService } from 'src/app/services/part-master.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-part-master',
  templateUrl: './part-master.component.html',
  styleUrls: ['./part-master.component.css']
})
export class PartMasterComponent implements OnInit {
  systemDate: string;
  globalParameter: number = 0;
  partStatus: string = 'A';

  constructor(private partMasterService: PartMasterService, private http: HttpClient) {}

  ngOnInit(): void {
    this.initializeForm();
    this.fetchSystemDate();
  }

  initializeForm(): void {
    // Maximize the main window
    // Set the 'PART_MASTER' window to normal size
    // Set the title of the main window to 'T K A P - [IS]'
    // Display the current form name in the 'SCREENNAME' field
    // Display the current date truncated to the day in the 'SYSDATE' field
    // Initialize the global parameter to 0
    // Display "Create Mode" in the 'MODE' field if the global parameter is 0, and "Edit Mode" if the global parameter is 1
    // Set the cursor style to default
    // Disable the 'SAVE' button
    // Enable the 'GROUP_ID', 'PARTNO', 'PART_STATUS', 'PART_DESC', and 'LINE_ID' fields
    // Enable the 'UNIT_ID' field if it is disabled
    // Move the cursor to the 'UNIT_ID' field
  }

  fetchSystemDate(): void {
    this.http.get('/api/system-date').subscribe((response: any) => {
      this.systemDate = response.date; // Assuming the response contains a date field
    });
  }

  onPartDescriptionClick(): void {
    // If the save button is enabled, disable it
    // If the part description field is not empty, clear it
  }

  validateFields(): void {
    // Check if Unit ID, Unit Name, Group ID, Group Name, Line ID, and Line Description fields are not empty
    // If any field is empty, display an appropriate error message and return focus to the empty field
    // If the global parameter is 0, ensure that Part Number and Part Description fields are not empty
    // If the global parameter is 1, ensure that Part ID is selected from a list of values
  }

  updatePartStatus(): void {
    // If all required fields are filled, update the part status to 'A'
  }

  onSaveButtonClick(): void {
    // Call the back-end service to save the current form data
  }

  onClearButtonClick(): void {
    this.clearForm();
  }

  clearForm(): void {
    // Clear all form fields without validating the current data
    // Enable the 'UNIT_ID' field if it is disabled
    // Set the 'PART_STATUS' field to 'A'
    // Execute the 'WHEN-NEW-FORM-INSTANCE' trigger
  }

  onEditButtonClick(): void {
    // Clear the form fields
    // Reinitialize the form as a new instance
    // Set the part status to 'A'
    // Set a global parameter to 1
    // Update the mode based on the global parameter
    // Disable the 'Edit' button if it was initially enabled
  }

  onExitButtonClick(): void {
    // Display a confirmation message with the text "Do you want to exit?"
    // If the user clicks "Yes", call the back-end service to handle the form exit action
    // If the user clicks "No", close the confirmation message
  }

  onGroupIdDoubleClick(): void {
    // Check the value of the global parameter `PARA`
    // If `PARA` is 0, call the service method to fetch `GROUP_LOV` data
    // If `PARA` is 1, call the service method to fetch `EDIT_GROUP_LOV` data
    // Display the LOV data in a modal or dropdown
    // After the user selects a Group ID, move the focus to the Line ID field
  }

  onUnitIdDoubleClick(): void {
    // Check the value of the global parameter `PARA`
    // If `PARA` is 0, call the service method to fetch `UNIT_LOV` data
    // If `PARA` is 1, call the service method to fetch `EDIT_UNIT_LOV` data
    // Display the LOV data in a modal or dropdown
    // After the user selects a Unit ID, move the focus to the Group ID field
  }

  onLineIdDoubleClick(): void {
    // Check the value of the global parameter `PARA`
    // If `PARA` is 0, call the service method to fetch `LINE_LOV` data
    // If `PARA` is 1, call the service method to fetch `EDIT_LINE_LOV` data
    // Display the LOV data in a modal or dropdown
    // After the user selects a Line ID, move the focus to the 'Part Number' field
  }

  onLineIdClick(): void {
    // If the 'Save' button is enabled, disable it
    // Clear the 'Line ID', 'Line Description', 'Part ID', 'Part Number', and 'Part Description' fields if they are not empty
    // Move the focus back to the 'Line ID' field
  }

  onNextItem(): void {
    // Check if 'Unit ID' or 'Unit Name' is empty. If so, display an error message and move the focus to the 'Unit ID' field
    // Check if 'Group ID' or 'Group Name' is empty. If so, display an error message and move the focus to the 'Group ID' field
    // Check if 'Line ID' or 'Line Description' is empty. If so, display an error message and move the focus to the 'Line ID' field
    // If all required fields are filled, move the focus to the 'Part Number' field
  }

  validateLineId(): void {
    // If the global parameter is 0, call the service method to validate the 'Line ID' and 'Line Description' for the given 'Unit ID' and 'Group ID'
    // If the global parameter is 1, call the service method to validate the 'Line ID' and 'Line Description' for the given 'Unit ID' and 'Group ID' in a different context
    // Display an error message if validation fails
  }
}
