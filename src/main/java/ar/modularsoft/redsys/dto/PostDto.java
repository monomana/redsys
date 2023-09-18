package ar.modularsoft.redsys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto {

    @JsonProperty("DS_MERCHANT_AMOUNT")
    private String dsMerchantAmount;
    @JsonProperty("DS_MERCHANT_ORDER")
    private String dsMerchantOrder;
    @JsonProperty("DS_MERCHANT_MERCHANTCODE")
    private String dsMerchantMerchantCode;
    @JsonProperty("DS_MERCHANT_CURRENCY")
    private String dsMerchantCurrency;
    @JsonProperty("DS_MERCHANT_TRANSACTIONTYPE")
    private String dsMerchantTransactionType;
    @JsonProperty("DS_MERCHANT_MERCHANTURL")
    private String dsMerchantUrl;
    @JsonProperty("DS_MERCHANT_TERMINAL")
    private String dsMerchantTerminal;
    @JsonProperty("DS_MERCHANT_URLOK")
    private String dsMerchantUrlOk;
    @JsonProperty("DS_MERCHANT_URLKO")
    private String dsMerchantUrlKo;
    @JsonProperty("DS_MERCHANT_MERCHANTNAME")
    private String dsMerchantName;

 }
