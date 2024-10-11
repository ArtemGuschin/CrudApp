package net.artem.crudapp.controller;

import lombok.Data;
import net.artem.crudapp.enums.WriterStatus;
import net.artem.crudapp.model.Post;
import net.artem.crudapp.model.Writer;
import net.artem.crudapp.repository.WriterRepository;
import net.artem.crudapp.repository.gson.GsonWriterRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class WriterController {
    private final WriterRepository writerRepository;

    public WriterController(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public WriterController() {

        this.writerRepository = new GsonWriterRepositoryImpl();
    }


    public Writer  createWriter(Long id,String firstName, String lastName,
                               List<Post> posts, WriterStatus writerStatus) {
        Writer newWriter = new Writer(id,firstName, lastName, posts, writerStatus);
        return writerRepository.save(newWriter);
    }

    public Writer updateWriter(Long id, String firstName, String lastName,
                               List<Post> posts, WriterStatus writerStatus) {

        Writer updateWriter = new Writer(id,firstName, lastName, posts, writerStatus);
        return writerRepository.update(updateWriter);
    }

//    public Writer updateWriter2(Long id, String firstName, String lastName, List<Post> posts, WriterStatus writerStatus) {
//        Writer updateWriter = new Writer(firstName, lastName,  posts, writerStatus);
//        updateWriter.setId(id);
//        updateWriter.setFirstName(firstName);
//        updateWriter.setLastName(lastName);
//        updateWriter.setPosts(posts);
//        updateWriter.setWriterStatus(WriterStatus.ACTIVE);
//        return WriterRepository.update(updateWriter);
//
//    }

    public void deleteWriter(Long id) {
        writerRepository.deleteById(id);

    }


}
