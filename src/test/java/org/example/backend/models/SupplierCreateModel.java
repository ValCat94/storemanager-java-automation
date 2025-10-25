package org.example.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*
Ради эксперимента, будем и в запросе, и в ответе использовать одну модель
 */
public class SupplierCreateModel {
    @JsonProperty("name")
    private String name;
    @JsonProperty("contact_name")
    private String contactName;
    @JsonProperty("contact_email")
    private String contactEmail;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("address")
    private String address;
    @JsonProperty("country")
    private String country;
    @JsonProperty("city")
    private String city;
    @JsonProperty("website")
    private String website;
    @JsonProperty("supplier_id")
    private String supplierId;

    public static SupplierCreateModel generate() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        /*
        return SupplierCreateModel.builder()
                .name("Supplier_" + timestamp)
                .contactName("Contact_" + timestamp)
                .contactEmail(timestamp + "@test.com")
                .phoneNumber("+1234567" + timestamp.substring(0,4))
                .address("Test Address " + timestamp)
                .country("TestCountry")
                .city("TestCity")
                .website("https://" + timestamp + "-test.com")
                .build();
         */
        return SupplierCreateModel.builder()
                .name("Test")
                .contactName("123321")
                .contactEmail("supplier@supplier.ru")
                .phoneNumber(null)
                .address(null)
                .country(null)
                .city(null)
                .website(null)
                .build();
    }
}
