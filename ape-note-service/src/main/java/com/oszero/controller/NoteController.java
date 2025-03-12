package com.oszero.controller;

import com.oszero.aspect.ApiOperationLog;
import com.oszero.entity.Note;
import com.oszero.pojo.dto.NotePublishDTO;
import com.oszero.response.Response;
import com.oszero.rpc.UserFeignAPi;
import com.oszero.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    //查列表;
    @GetMapping("/list")
    @ApiOperationLog(description = "获取笔记列表")
    public Response<List<Note>> list() {
        List<Note> list = noteService.list();
        return Response.success(list);
    }

    //发布Note;
    @ApiOperationLog(description = "发布笔记")
    @PostMapping("/publish")
    public Response<Boolean> publish(@RequestBody NotePublishDTO notePublishDTO) {
        return noteService.publish(notePublishDTO);
    }
}
