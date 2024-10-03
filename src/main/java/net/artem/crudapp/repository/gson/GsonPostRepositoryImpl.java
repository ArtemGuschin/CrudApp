package net.artem.crudapp.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.artem.crudapp.enums.PostStatus;
import net.artem.crudapp.model.Post;
import net.artem.crudapp.repository.PostRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class GsonPostRepositoryImpl implements PostRepository {
    private final String FILE_PATH = "src/main/resources/posts.json";
    private final Gson GSON = new Gson();

    private Long generateNewId(List<Post> posts) {
        return posts.stream().mapToLong(Post::getId).max().orElse(0) + 1;
    }

    private List<Post> loadPosts() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Post>>() {
            }.getType();
            return GSON.fromJson(reader, type);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private void savePosts(List<Post> posts) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            GSON.toJson(posts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Post getById(Long id) {
        return loadPosts().stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return loadPosts();
    }

    @Override
    public Post save(Post postToSave) {
        List<Post> currentPosts = loadPosts();

        Long generatedId = generateNewId(currentPosts);
        postToSave.setId(generatedId);

        currentPosts.add(postToSave);
        savePosts(currentPosts);
        return postToSave;
    }

    @Override
    public Post update(Post postToUpdate) {
        List<Post> postsToUpdate = loadPosts().stream()
                .map(currentPost -> {
                    if (currentPost.getId().equals(postToUpdate.getId())) {
                        return postToUpdate;
                    }
                    return currentPost;
                }).toList();
        savePosts(postsToUpdate);
        return postToUpdate;
    }

    @Override
    public void deleteById(Long id) {
        List<Post> postsToUpdate = loadPosts().stream()
                .map(currentPost -> {
                    if (currentPost.getId().equals(id)) {
                        currentPost.setPostStatus(PostStatus.DELETED);

                    }
                    return currentPost;
                }).toList();
        savePosts(postsToUpdate);

    }
}
