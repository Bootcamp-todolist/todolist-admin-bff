package com.todolist.admin.bff.adapter.http;

import com.todolist.admin.bff.adapter.http.models.AdminLoginCommand;
import com.todolist.admin.bff.service.AdminService;
import com.todolist.admin.bff.service.models.TokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminAccountController {

  private final AdminService adminService;

  @PostMapping("/login")
  public TokenDTO adminLogin(@RequestBody @Validated AdminLoginCommand adminLoginCommand) {
    return adminService.login(adminLoginCommand);
  }

}
