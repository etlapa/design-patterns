package mx.edev.design.patterns.structural.bridge.exercise3;

import java.util.List;

public class HtmlFormatter implements Formatter {

    @Override
    public String format(String header, List<Detail> details) {

        StringBuilder sb = new StringBuilder();

        sb.append("<table>");
        sb.append("<th>");
        sb.append("<td>");
        sb.append("Classification");
        sb.append("</td>");
        sb.append("<td>");
        sb.append("Header");
        sb.append("</td>");

        for (Detail detail : details) {
            sb.append("<th>");
            sb.append("<td>");
            sb.append(detail.getLabel());
            sb.append("</td>");
            sb.append("<td>");
            sb.append(detail.getValue());
            sb.append("</td>");
        }

        sb.append("</th>");
        sb.append("</table>");

        return sb.toString();
    }
}