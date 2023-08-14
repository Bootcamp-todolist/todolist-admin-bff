package com.todolist.admin.bff.adapter.http;

import com.todolist.admin.bff.service.MemberService;
import com.todolist.admin.bff.service.models.CreateMemberCommand;
import com.todolist.admin.bff.service.models.MemberAccountDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminMemberController {

  private final MemberService memberService;

  @PostMapping("/member")
  @ResponseStatus(HttpStatus.CREATED)
  public MemberAccountDTO createMember(@RequestBody @Validated CreateMemberCommand createMemberCommand) {
    return memberService.createMember(createMemberCommand);
  }

  @GetMapping("/members")
  public List<MemberAccountDTO> getAllMembers() {
    return memberService.getAllMembers();
  }

  @DeleteMapping("/member/{id}")
  public void deleteMember(@PathVariable("id") String memberId) {
    memberService.deleteMember(memberId);
  }

}
