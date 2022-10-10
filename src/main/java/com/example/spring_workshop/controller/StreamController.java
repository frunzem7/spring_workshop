package com.example.spring_workshop.controller;

import com.example.spring_workshop.entites.dto.StreamDTO;
import com.example.spring_workshop.service.StreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stream")
public class StreamController {
    private final StreamService streamService;

    @GetMapping
    public List<StreamDTO> getAllStreams() {
        return streamService.getAllStreams();
    }

//    @GetMapping("/department")
//    public List<String> getStreamNamesByDepartmentName(@RequestParam(name = "name") String department) {
//        return streamService.getStreamNamesByDepartment(department);
//    }

    @GetMapping("/{department}")
    public List<String> getStreamNamesByDepartment(@PathVariable String department) {
        return streamService.getStreamNamesByDepartment(department);
    }
}
