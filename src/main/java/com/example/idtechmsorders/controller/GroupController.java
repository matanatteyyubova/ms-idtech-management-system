package com.example.idtechmsorders.controller;

import com.example.idtechmsorders.dto.request.CreateGroupDto;
import com.example.idtechmsorders.dto.response.GroupDto;
import com.example.idtechmsorders.service.GroupService;
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


    @PutMapping
    public ResponseEntity<Void> update(@RequestBody CreateGroupDto request) {
        groupService.updateGroup(request);
        return ResponseEntity.ok().build();
    }
}
