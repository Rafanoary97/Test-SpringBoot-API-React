package com.dani.monkeyd.app.appingen.services;

import com.dani.monkeyd.app.appingen.models.Comments;
import com.dani.monkeyd.app.appingen.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comments> getAllComment(){
        return commentRepository.findAll();
    }

    /**
     * Get all comment for a car
     * @param idCar
     * @return
     */
    public List<Comments> findCommentByCarId(Long idCar){
        List<Comments> comments1 = null;
        List<Comments> comments=commentRepository.findAll();
        for (Comments u:comments)
            if (u.getIdImage().equals(idCar)){
               comments1.add(commentRepository.findById(u.getId()).get());
            }
        return comments1;
    }

    public Comments addComment(Comments comments){
        return commentRepository.save(comments);
    }

    public Comments updateComment(Comments comments){
        return commentRepository.save(comments);
    }
    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }

}
