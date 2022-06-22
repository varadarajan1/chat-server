package com.example.chatserver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMessageRequest {
    @NotNull
    @Min(1)
    @Max(Long.MAX_VALUE)
    private Long fromUserId;
    @NotNull
    @Min(1)
    @Max(Long.MAX_VALUE)
    private Long toUserId;
    @NotBlank
    private String message;
}
