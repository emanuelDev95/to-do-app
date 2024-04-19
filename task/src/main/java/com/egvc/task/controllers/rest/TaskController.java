package com.egvc.task.controllers.rest;

import com.egvc.task.dtos.TaskDto;
import com.egvc.task.dtos.responses.MessageResponse;
import com.egvc.task.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;



    @PostMapping()
    public ResponseEntity<MessageResponse<TaskDto>> save(@RequestBody TaskDto entity) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageResponse<>(
                        "Almacenado Exitosamente",
                        HttpStatus.CREATED.value(),
                        this.taskService.save(entity)));
    }

    @GetMapping()
    public ResponseEntity<MessageResponse<List<TaskDto>>> getAll() {
        return ResponseEntity.ok(new MessageResponse<>(
                "OK", HttpStatus.OK.value(),
                this.taskService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse<TaskDto>> getById(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(MessageResponse.<TaskDto>builder()
                .message("Exito")
                .statusCode(HttpStatus.OK.value())
                .data(this.taskService.getById(id))
                .build());


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse<Void>> deleteById(@PathVariable @NonNull Long id){
        this.taskService.delete(id);
        return ResponseEntity.ok(MessageResponse.<Void>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Eliminado Exitosamente")
                .build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse<TaskDto>> update(@RequestBody TaskDto productDTO,
                                                              @PathVariable @NonNull Long id) {
        return ResponseEntity.ok(MessageResponse.<TaskDto>builder()
                .message("Exito")
                .statusCode(HttpStatus.OK.value())
                .data(this.taskService.update(productDTO,id))
                .build());


    }



}
