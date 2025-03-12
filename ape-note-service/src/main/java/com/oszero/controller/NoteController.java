package com.oszero.controller;

import com.oszero.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;
}
