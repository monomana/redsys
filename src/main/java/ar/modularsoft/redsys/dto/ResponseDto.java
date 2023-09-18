package ar.modularsoft.redsys.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
    @JsonProperty("Ds_MerchantParameters")
    private String merchantParameters;
    @JsonProperty("Ds_Signature")
    private String merchantSignature;
    @JsonProperty("Ds_SignatureVersion")
    private String signatureVersion = "HMAC_SHA256_V1";

}
