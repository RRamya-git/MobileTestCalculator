Feature: Dropdown and DragAndDrop

  Scenario: User selects Dropdown and Drag and Drop
    Given User is on Dropdown page
    When Select India from the dropdown
    Then India should be selected
    When Drag the item from Source Image to Trash
    Then Item should be dropped successfully
    
    