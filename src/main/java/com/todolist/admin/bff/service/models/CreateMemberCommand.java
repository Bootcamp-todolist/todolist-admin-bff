package com.todolist.admin.bff.service.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberCommand {
  @NotBlank
  @Size(max = 20,message = "用户名最大20位")
  private String username;
  @NotBlank
  @Size(min = 10, max = 32)
  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{10,20}$",
      message = "密码不少于10位，不大于32位，且包含至少一个数字、一个大写字母、一个小写字母")
  private String password;

}
