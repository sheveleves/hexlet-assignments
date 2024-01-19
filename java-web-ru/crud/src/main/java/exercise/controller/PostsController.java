package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        PostPage page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }

    public static void index(Context ctx) {
        List<Post> posts = PostRepository.getEntities();
        Integer page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int firstIndex = (page - 1) * 5;
        int secondIndex = Math.min(posts.size(), (firstIndex + 5));
        List<Post> sliceOfPosts = posts.subList(firstIndex, secondIndex);
        PostsPage postsPage = new PostsPage(sliceOfPosts, page, posts.size());
        ctx.render("posts/index.jte", Collections.singletonMap("page", postsPage));
    }
    // END
}
