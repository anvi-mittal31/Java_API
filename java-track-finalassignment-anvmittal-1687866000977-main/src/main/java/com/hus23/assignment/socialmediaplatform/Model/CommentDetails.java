package com.hus23.assignment.socialmediaplatform.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="COMMENTS")
public class CommentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CommentId;

    @Column(name="message",length = 200)
    private String message;

    @Column(name="timestamp")
    private LocalDateTime datetime;

    @PrePersist //indicates that the annotated method should be called before the entity is persisted (i.e., before it is saved to the database).
    public void prePersist() {

        datetime = LocalDateTime.now();
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Long getCommentId() {
        return CommentId;
    }

    public void setCommentId(Long commentId) {
        CommentId = commentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
