package com.dani.monkeyd.app.appingen.controllers;

import com.dani.monkeyd.app.appingen.models.Comments;
import com.dani.monkeyd.app.appingen.models.Users;
import com.dani.monkeyd.app.appingen.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/comment")
public class CommentsController {
    private final CommentService commentService;

    @Autowired
    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comments>> getAllComment(){
        List<Comments> comments=commentService.getAllComment();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/findCarComment/{idComment}")
    public ResponseEntity<List<Comments>> getCommentByCar(@PathVariable("idComment") Long idComment){
        List<Comments> comments=commentService.findCommentByCarId(idComment);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Comments> addComment(@RequestBody Comments comments){
        Comments comments1=commentService.addComment(comments);
        return new ResponseEntity<>(comments1, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Comments> updateUsers(@RequestBody Comments comments){
        Comments comments1=commentService.updateComment(comments);
        return new ResponseEntity<>(comments1, HttpStatus.OK);
    }


}
