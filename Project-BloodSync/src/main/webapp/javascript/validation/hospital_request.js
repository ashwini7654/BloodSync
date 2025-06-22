function validateForm(){
    let hospitalName = document.getElementById("hospital_name").value.trim();
    let bloodUnits = document.getElementById("blood_units").value.trim();
    let contactNumber = document.getElementById("contact_number").value.trim();
    bloodUnits=Number(bloodUnits);
    if (hospitalName == "") {
        alert("All fields must be filled out");
        return false;
    }
    if (bloodUnits <= 0) {
        alert("Blood units must be valid ");
        return false;
    }
    if( contactNumber.length < 10) {
        alert("Contact number must be at least 10 digits long");
        return false;
    }

    // Add more validation as needed
    return true;
}
