package com.todolist.admin.bff.service;

import com.todolist.admin.bff.adapter.client.AccountServiceClient;
import com.todolist.admin.bff.adapter.http.models.AdminLoginCommand;
import com.todolist.admin.bff.service.models.TokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

  private final AccountServiceClient accountServiceClient;

  public TokenDTO login(AdminLoginCommand adminLoginCommand) {
    return accountServiceClient.adminLogin(adminLoginCommand);
  }


}
