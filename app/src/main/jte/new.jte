@param String error

@template.layout.page(
content = @`
    <h3 class="text-center">New course</h3>
    @if(error != null)
        ${error}
    @endif
    <div class="container-sm">
        <form class="row g-3 needs-validation" action="/courses" method="post" novalidate>
            <div class="col-md-4">
                <label for="name" class="form-label">
                    Course Name
                    <input type="text" class="form-control" name="name" value="Name" required>
                </label>
            </div>
            <div class="col-md-4">
                <label for="description" class="form-label">
                    Course Description
                    <input type="text" class="form-control" name="description" value="Description">
                </label>
            </div>
            <div class="col-12">
                <button class="btn btn-primary" type="submit">Submit</button>
            </div>
        </form>
    </div>
`
)