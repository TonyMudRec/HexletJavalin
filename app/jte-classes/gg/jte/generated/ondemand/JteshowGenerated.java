package gg.jte.generated.ondemand;
import org.example.hexlet.model.Course;
public final class JteshowGenerated {
	public static final String JTE_NAME = "show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,10,10,10,10,11,11,11,14};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Course course) {
		jteOutput.writeContent("\n<html>\n<head>\n    <title>Хекслет</title>\n</head>\n<body>\n<h1>Course info</h1>\n<div>\n    <h2>");
		jteOutput.setContext("h2", null);
		jteOutput.writeUserContent(course.getName());
		jteOutput.writeContent("</h2>\n    <p>");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(course.getDescription());
		jteOutput.writeContent("</p>\n</div>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Course course = (Course)params.get("course");
		render(jteOutput, jteHtmlInterceptor, course);
	}
}
