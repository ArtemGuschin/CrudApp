package net.artem.crudapp.model;

import lombok.*;
import net.artem.crudapp.enums.PostStatus;

import java.util.Date;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Post {
    private Long id;
    private List<Post> posts;
    private PostStatus postStatus;




    public Post(Long id, String name, List<Post> post, PostStatus postStatus) {
    }

    public Post(String content, Date created, Date update, List<Label> labels) {

    }
}
