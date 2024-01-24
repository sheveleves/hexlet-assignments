@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

<!-- BEGIN -->
@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        @if(page.getName() != null)
            Добро пожаловать ${page.getName().toString()}
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" class="btn btn-primary" value="Выйти"/>
            </form>
        @else
            <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
        @endif
    </div>
`
)
<!-- END -->
