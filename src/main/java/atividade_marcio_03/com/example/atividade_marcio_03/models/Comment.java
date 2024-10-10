package atividade_marcio_03.com.example.atividade_marcio_03.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String content;
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    Post post;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    Usuario user;
}
