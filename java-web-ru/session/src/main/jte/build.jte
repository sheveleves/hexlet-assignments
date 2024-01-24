@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

<!-- BEGIN -->
@template.layout.page(
content = @`
    <div>
        @if (!page.getError().isEmpty())
            <div>
                ${page.getError()}
            </div>
        @endif
    </div>
    <div>
        <form action="${NamedRoutes.loginPath()}" method="post">
            <div class="mb-3">
                <input type="text" placeholder="Nickname" class="form-control" name="name"
                       value="${page.getName()}"/>
            </div>
            <div class="mb-3">
                <input type="password" placeholder="Password" class="form-control" required name="password"/>
            </div>
            <input type="submit" class="btn btn-primary" />
        </form>
    </div>
`
)
<!-- END -->