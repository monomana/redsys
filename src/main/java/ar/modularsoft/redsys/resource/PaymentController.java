package ar.modularsoft.redsys.resource;


import ar.modularsoft.redsys.dto.PostDto;
import ar.modularsoft.redsys.dto.ResponseDto;
import ar.modularsoft.redsys.service.PaymentService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@RequiredArgsConstructor
@RestController
@RequestMapping("${app.end-points.payment}")
public class PaymentController {


private final PaymentService paymentService;
//    @PreAuthorize("permitAll()")
    @Value("${app.end-points.payment}")
    private String enrpoint ;
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<ResponseDto> createMerchantSignature(@Valid @RequestBody PostDto postDto)
            throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        System.out.println(enrpoint);
        return ResponseEntity.ok(paymentService.createMerchantSignature (postDto));
    }



}