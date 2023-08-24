@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
content = @`
    @if(page.getCourses().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
    @else
        <div>
            <form action="/courses" method="get">
                <input type="search" name="term" value="${page.getTerm()}"/>
                <input type="submit" value="Filter" />
            </form>
        </div>
        @for(var course : page.getCourses())
            <div>
                <h2><a href="/courses/${course.getId()}">${course.getName()}</a></h2>
                <p>${course.getDescription()}</p>
            </div>
        @endfor
    @endif
`,
footer = @`
    <p><a href="https://github.com/TonyMudRec/hexlet-javalin"><h3>Creator</h3></a></p>
`
)