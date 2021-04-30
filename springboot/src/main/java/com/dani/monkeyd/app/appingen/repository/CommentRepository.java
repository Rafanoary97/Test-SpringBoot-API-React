package com.dani.monkeyd.app.appingen.repository;

import com.dani.monkeyd.app.appingen.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comments,Long> {
}
