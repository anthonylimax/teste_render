package atividade_marcio_03.com.example.atividade_marcio_03.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    @JoinColumn(name = "post_id")
    @JsonIgnore
    Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    Usuario user;
    @JsonProperty("post_id")
    public int getIdPost(){
        return this.post.id;
    }
    @JsonProperty("user_id")
    public int getIdUser(){
        return this.user.id;
    }
}
