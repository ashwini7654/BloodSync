function
    validateForm() {
        var name = document.getElementById("name").value.trim();
        var city = document.getElementById("city").value.trim();
        var contactNumber = document.getElementById("contact_number").value.trim();

        if (name == "" || city == "" ) {
            alert("All fields must be filled out");
            return false;
        }
        if( contactNumber.length < 10) {
            alert("Contact number must be at least 10 digits long");
            return false;
        }

        // Add more validation as needed
        return true;
    }