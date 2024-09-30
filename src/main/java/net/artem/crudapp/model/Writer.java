package net.artem.crudapp.model;

import lombok.*;
import net.artem.crudapp.enums.WriterStatus;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Writer {
    private long id;
    private String firstName;
    private String lastName;
    private List<Post> posts;



    public void addPost(Post post) {
        if (posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(post);
    }
}
