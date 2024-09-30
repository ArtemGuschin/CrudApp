package net.artem.crudapp.model;

import lombok.*;
import net.artem.crudapp.enums.PostStatus;

import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Post {
    private long id;
    private List<Post> posts;
    private PostStatus postStatus;


}
