package net.artem.crudapp.model;

import lombok.*;
import net.artem.crudapp.enums.WriterStatus;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Writer {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private WriterStatus writerStatus;

//    public Writer(String firstName, String lastName, List<Post> posts, WriterStatus writerStatus) {
//
//    }


    public void addPost(Post post) {
        if (posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(post);
    }
}
