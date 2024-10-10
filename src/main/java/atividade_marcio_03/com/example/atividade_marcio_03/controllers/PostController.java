package atividade_marcio_03.com.example.atividade_marcio_03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import atividade_marcio_03.com.example.atividade_marcio_03.dtos.PostDto;
import atividade_marcio_03.com.example.atividade_marcio_03.dtos.CreatePostDto;
import atividade_marcio_03.com.example.atividade_marcio_03.models.Post;
import atividade_marcio_03.com.example.atividade_marcio_03.models.Usuario;
import atividade_marcio_03.com.example.atividade_marcio_03.services.PostService;
import atividade_marcio_03.com.example.atividade_marcio_03.services.UserService;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {


    @Autowired
    private PostService postService;
    
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.findById(id);
        return post != null ? new ResponseEntity<>(post, HttpStatus.OK)
                            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody CreatePostDto post) {
        try{
            postService.save(post);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }
    catch(Exception e){
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostDto postDetails) {
        Post post = postService.findById(id);
        if (post != null) {
            post.setTitle(postDetails.getTitle());
            post.setContent(postDetails.getContent());
            postService.update(postDetails);
            return new ResponseEntity<>(post, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Long userId) {
        List<Post> posts = postService.findByUserId(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
