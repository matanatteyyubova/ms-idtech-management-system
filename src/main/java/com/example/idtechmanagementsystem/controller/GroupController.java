package com.example.idtechmanagementsystem.controller;

import com.example.idtechmanagementsystem.dto.request.CreateGroupDto;
import com.example.idtechmanagementsystem.dto.response.GroupDto;
import com.example.idtechmanagementsystem.dto.response.StudentDto;
import com.example.idtechmanagementsystem.service.GroupService;
import com.example.idtechmanagementsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<GroupDto>> get() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @PostMapping
    public ResponseEntity<GroupDto> createGroup(@RequestBody CreateGroupDto groupDto) {
       GroupDto createdGroup = groupService.createGroup(groupDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdGroup.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdGroup);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GroupDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(groupService.getGroupById(id));
    }

   @GetMapping("/{id}/students")
   public ResponseEntity<List<StudentDto>> getStudentsByGroupId(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getAllStudentsByGroupId(id));
   }
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody CreateGroupDto request) {
        groupService.updateGroup(request);
        return ResponseEntity.ok().build();
    }
}
