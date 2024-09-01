package com.codewithsam.unboxingPostgres.payloads;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JwtAuthResponse {
    private String jwtToken;
    private String username;
}
