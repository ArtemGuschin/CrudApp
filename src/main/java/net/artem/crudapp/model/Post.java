package net.artem.crudapp.model;

import lombok.*;
import net.artem.crudapp.enums.PostStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Post {
    private Long id;
    private String content;
    private PostStatus postStatus;
    private List<Label> labels;
    private Date created;
    private Date updated;




    public void addLabel(Label label){
        if (labels == null){
            labels = new ArrayList<>();
        }
        labels.add(label);
    }









}
