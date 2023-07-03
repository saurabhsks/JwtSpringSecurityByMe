package com.app.springbootmysql.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class JwtRequest {
    private String email;
    private String password;
}
