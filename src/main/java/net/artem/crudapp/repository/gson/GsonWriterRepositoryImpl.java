package net.artem.crudapp.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.artem.crudapp.enums.WriterStatus;
import net.artem.crudapp.model.Writer;
import net.artem.crudapp.repository.WriterRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class GsonWriterRepositoryImpl implements WriterRepository {
    private final String FILE_PATH = "src/main/resources/writers.json";
    private final Gson GSON = new Gson();

    private Long generateNewId(List<Writer> writers) {
        return writers.stream().mapToLong(Writer::getId)
                .max().orElse(0) + 1;
    }

    private List<Writer> loadWriters() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Writer>>() {
            }.getType();
            return GSON.fromJson(reader, type);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private void saveWriters(List<Writer> writers) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            GSON.toJson(writers, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Writer getById(Long id) {
        return loadWriters().stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Writer> getAll() {

        return loadWriters();
    }

    @Override
    public Writer save(Writer writerToSave) {
        List<Writer> currentWriters = loadWriters();

        Long generatedId = generateNewId(currentWriters);
        writerToSave.setId(generatedId);

        currentWriters.add(writerToSave);
        saveWriters(currentWriters);
        return writerToSave;


    }

    @Override
    public Writer update(Writer writerToUpdate) {
        List<Writer> writersToUpdate = loadWriters().stream()
                .map(currentWriter -> {
                    if (currentWriter.getId().equals(writerToUpdate.getId())) {
                        return writerToUpdate;
                    }
                    return currentWriter;

                }).toList();
        saveWriters(writersToUpdate);
        return writerToUpdate;

     }

    @Override
    public void deleteById(Long id) {
        List<Writer> writersToUpdate = loadWriters().stream()
                .map(currentWriter -> {
                    if (currentWriter.getId().equals(id)) {
                        currentWriter.setWriterStatus(WriterStatus.DELETED);
                    }
                    return currentWriter;
                }).toList();
        saveWriters(writersToUpdate);


    }
}
