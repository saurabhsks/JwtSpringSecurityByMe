package com.app.springbootmysql.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class JwtResponse {

    private String jwtToken;
    private String username;
}
