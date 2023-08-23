@import org.example.hexlet.model.Course
@param Course course

@template.layout.page(
content = @`
    <h1>Course info</h1>
    <div>
        <h2>${course.getName()}</h2>
        <p>${course.getDescription()}</p>
    </div>
`
)