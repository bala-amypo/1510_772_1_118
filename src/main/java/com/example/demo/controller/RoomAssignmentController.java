package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;

@CrossOrigin(origins = "*")   // ⭐ VERY IMPORTANT
@RestController
@RequestMapping("/api/room-assignments")
public class RoomAssignmentController {

    @Autowired
    private RoomAssignmentService roomService;

    @PostMapping
    public RoomAssignmentRecord assignRoom(@RequestBody RoomAssignmentRecord room) {
        return roomService.assignRoom(room);
    }

    @GetMapping
    public List<RoomAssignmentRecord> getAll() {
        return roomService.getAllAssignments();
    }

    @GetMapping("/student/{studentId}")
    public List<RoomAssignmentRecord> getByStudent(@PathVariable Long studentId) {
        return roomService.getAssignmentsForStudent(studentId);
    }
}
