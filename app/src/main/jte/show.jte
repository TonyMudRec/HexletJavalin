@import org.example.hexlet.model.Course
@param Course course

<html>
<head>
    <title>Хекслет</title>
</head>
<body>
<h1>Course info</h1>
<div>
    <h2>${course.getName()}</h2>
    <p>${course.getDescription()}</p>
</div>
</body>
</html>