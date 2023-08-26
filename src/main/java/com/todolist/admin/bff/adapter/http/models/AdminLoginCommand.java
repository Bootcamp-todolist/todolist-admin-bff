package com.todolist.admin.bff.adapter.http.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AdminLoginCommand {
  @NotBlank
  private String username;
  @NotBlank
  private String password;

}
