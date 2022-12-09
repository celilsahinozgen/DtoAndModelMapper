package com.example.silinecek.advice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcepitonResponse {

    LocalDateTime timestamp;
    String message;
    String code;

}
