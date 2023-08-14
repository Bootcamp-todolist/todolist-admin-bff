package com.todolist.admin.bff.adapter.client;

import com.todolist.admin.bff.adapter.http.models.AdminLoginCommand;
import com.todolist.admin.bff.service.models.CreateMemberCommand;
import com.todolist.admin.bff.service.models.MemberAccountDTO;
import com.todolist.admin.bff.service.models.TokenDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${services.account.name}", url = "${services.account.url}")
public interface AccountServiceClient {

  @PostMapping("/admin/login")
  TokenDTO adminLogin(@RequestBody AdminLoginCommand adminLoginCommand);

  @PostMapping("/admin/member")
  MemberAccountDTO createMember(@RequestBody CreateMemberCommand createMemberCommand);

  @GetMapping("/admin/members")
  List<MemberAccountDTO> getAllMembers();

  @DeleteMapping("/admin/member/{id}")
  void deleteMember(@PathVariable("id") String memberId);
}
