package exercise.controller;

import java.util.Collections;
import java.util.List;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", Collections.singletonMap("page", page));
    }

    // BEGIN
    public static void create(Context ctx) {
        String body = ctx.formParam("body");
        try {
            String name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Название должно быть не короче двух символов")
                    .get();
            Post post = new Post(name, body);
            PostRepository.save(post);
            ctx.sessionAttribute("flash","Пост был успешно создан!");
            ctx.redirect(NamedRoutes.postsPath());
        } catch (ValidationException e) {
            BuildPostPage page = new BuildPostPage(ctx.formParam("name"), body, e.getErrors());
            ctx.render("posts/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void index(Context ctx) {
        List<Post> posts = PostRepository.getEntities();
        PostsPage page = new PostsPage(posts);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
}
