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


    public Writer createWriter(String firstName, String lastName,
                               List<Post> posts) {
        Writer newWriter = Writer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .writerStatus(WriterStatus.UNDER_REVIEW)
                .posts(posts)
                .build();
        return writerRepository.save(newWriter);
    }

    public Writer updateWriter(Long id, String firstName, String lastName,
                               List<Post> posts, WriterStatus writerStatus) {
        Writer updateWriter = Writer.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .posts(posts)
                .writerStatus(writerStatus)
                .build();
        return writerRepository.update(updateWriter);
    }


    public void deleteWriter(Long id) {
        writerRepository.deleteById(id);

    }

    public List<Writer> getWriter() {
        return writerRepository.getAll();
    }


}
