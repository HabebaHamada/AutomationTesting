package api.Payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Candidate {
        @JsonProperty("firstName")
        private String firstName;
        @JsonProperty("middleName")
        private String middleName;
        @JsonProperty("lastName")
        private String lastName;
        @JsonProperty("email")
        private String email;

        // Getters and Setters
        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }
        public String getMiddleName() { return middleName; }
        public void setMiddleName(String middleName) { this.middleName = middleName; }
        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
}

