package ar.modularsoft.redsys.service;

import ar.modularsoft.redsys.dto.PostDto;
import ar.modularsoft.redsys.dto.ResponseDto;
import ar.modularsoft.redsys.util.Utils;
import ch.qos.logback.classic.encoder.JsonEncoder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@Slf4j
@Service
public class PaymentService {
    @Value("${app.sha256key}")
    private  String sha256Key ;

    public ResponseDto createMerchantSignature(PostDto postDto)
            throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, IllegalStateException,
            NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

        log.info("{}::{} execution start", this.getClass().getSimpleName(), new Object() {
        }.getClass().getEnclosingMethod().getName());

        System.out.println(sha256Key);

        String merchantParametersB64 = createMerchantParameters(postDto);
        String signature = Utils.encode(sha256Key, postDto.getDsMerchantOrder(), merchantParametersB64 );
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMerchantSignature(signature);
        responseDto.setMerchantParameters(merchantParametersB64);

        log.info("{}::{} execution start", this.getClass().getSimpleName(), new Object() {
        }.getClass().getEnclosingMethod().getName());
        return responseDto;
    }

    public String createMerchantParameters(PostDto parameters) throws UnsupportedEncodingException {

      log.info("{}::{} execution start", this.getClass().getSimpleName(), new Object() {
        }.getClass().getEnclosingMethod().getName());
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {

           jsonString= mapper.writeValueAsString(parameters);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
//        String jsonString = JSONObject.valueToString( parameters);
        System.out.println(jsonString);
//        System.out.println(Utils.encodeB64String(jsonString.getBytes("UTF-8")));
        return Utils.encodeB64String(jsonString.getBytes("UTF-8"));
    }

}
