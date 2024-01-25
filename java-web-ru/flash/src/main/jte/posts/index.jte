@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    page = page,
    content = @`
        <h1>Посты</h1>
        <table class="table table-striped">
            @for(var post : page.getPosts())
                <tr>
                    <td>
                        ${post.getName()}
                    </td>
                    <td>
                        ${post.getBody()}
                    </td>
                </tr>
            @endfor
        </table>
    `
)

