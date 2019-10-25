package com.eluon.nu.activityhistory.api.ActivityHistory.other;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseApi {

    int status;
    String message;
    Object data;

    public ResponseEntity toOk(ResponseApi responseApi) {
        return ResponseEntity
                .ok()
                .body(this);
    }

    public ResponseEntity toBadRequest() {
        return  ResponseEntity
                .badRequest()
                .body(this);
    }

}

