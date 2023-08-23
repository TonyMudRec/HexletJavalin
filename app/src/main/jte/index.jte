@import org.example.hexlet.Data
@param Data data

@template.layout.page(
content = @`
    @if(data.getCourses().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
    @else
        @for(var course : data.getCourses())
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