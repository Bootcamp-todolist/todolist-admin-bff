package com.todolist.admin.bff.service;

import com.todolist.admin.bff.adapter.client.AccountServiceClient;
import com.todolist.admin.bff.service.models.CreateMemberCommand;
import com.todolist.admin.bff.service.models.MemberAccountDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
  private final AccountServiceClient accountServiceClient;


  public MemberAccountDTO createMember(CreateMemberCommand createMemberCommand) {
    return accountServiceClient.createMember(createMemberCommand);
  }

  public List<MemberAccountDTO> getAllMembers() {
    return accountServiceClient.getAllMembers();
  }


  public void deleteMember(String memberId) {
    accountServiceClient.deleteMember(memberId);
  }
}
