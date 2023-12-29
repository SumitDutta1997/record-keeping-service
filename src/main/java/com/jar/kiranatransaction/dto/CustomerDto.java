package com.jar.kiranatransaction.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Integer customerId;
    private String name;
    private String phoneNumber;
    private String email;
}
